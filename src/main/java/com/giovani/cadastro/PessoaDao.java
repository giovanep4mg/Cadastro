/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.giovani.cadastro;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author giova
 */
public class PessoaDao extends Dao {
	
	public void incluirPessoa(Pessoa p) throws Exception {
		open();
		System.out.println("IncluirPessoa -> Conectado ao banco de dados");

		stmt = con.prepareStatement("INSERT INTO pessoa VALUES (?,?,?)");
		System.out.println("IncluirPessoa -> PreparedStatement "+stmt);

		stmt.setInt(1, p.getIdPessoa());
		System.out.println("IncluirPessoa -> Pegando o idPessoa e seta outro..."+stmt);

		stmt.setString(2, p.getNomePessoa());
		System.out.println("IncluirPessoa -> Pegando o nomePessoa e setando outro..."+stmt);

		stmt.setString(3, p.getEmail());
		System.out.println("IncluirPessoa -> Pegando o email e setando outro email..."+stmt);

		stmt.execute();
		System.out.println("IncluirPessoa -> executando o stmt..."+stmt);

		stmt.close();
		System.out.println("IncluirPessoa -> Fechando o stmt "+stmt);

		close();
		System.out.println("IncluirPessoa -> Fechando a conexão com o banco de dados");
	}

	
	public void alterarPessoa(Pessoa p) throws Exception {
		open();
		System.out.println("AlterarPessoa -> Conectando ao banco de dados..");

		stmt = con.prepareStatement("UPDATE pessoa SET nomePessoa = ?, email = ? WHERE idPessoa = ? ");
		System.out.println("AlterarPessoa -> PrepareStatement -> "+stmt);
		
		stmt.setInt(1, p.getIdPessoa());
		System.out.println("AlterarPessoa -> Pega o idPessoa, e seta outro idPessoas"+stmt);

		stmt.setString(2, p.getNomePessoa());
		System.out.println("AlterarPessoa -> pega o nome da pessoa, e seta outro nome..."+stmt);

		stmt.setString(3, p.getEmail());
		System.out.println("AlterarPessoa -> pega o email, e seta outro email..."+stmt);

		stmt.execute();
		System.out.println("AlterarPessoa -> Executando o execute -> "+stmt);

		stmt.close();
		System.out.println("AlterarPessoa -> Fechando o STMT -> "+stmt);

		close();
		System.out.println("Fechando a conexão com o banco de dados...");
	}

	public void excluirPessoa(Pessoa p) throws Exception {

		open();
		System.out.println("Excluir -> Conectando ao banco de dados..");

		stmt = con.prepareStatement("DELETE FROM pessoa WHERE idPessoa = ?");
		System.out.println("Excluir -> PeparedStatement "+stmt);


		stmt.setInt(1, p.getIdPessoa());
		System.out.println("Excluir -> setando o idPessoa"+stmt);

		stmt.execute();
		System.out.println("Excluir -> stmt execute "+stmt);

		stmt.close();
		System.out.println("Excluir -> stmt close "+stmt);

		close();
		System.out.println("Excluir -> Fechando a conecão com o banco de dados...");


	}
	

	// método para fazer consultas individual
	public Pessoa consultarPessoaIndividual(int cod) throws Exception {
			open();
			System.out.println("Consulta -> Fazendo a conexão com o banco de dados...");

			stmt = con.prepareStatement("SELECT * FROM pessoa WHERE idPessoa = ? ");
			System.out.println("Consulta -> Preparando a conexão sql -> "+stmt);

			stmt.setInt(1, cod);
			System.out.println("Consulta -> Setando o parâmetro recebido -> "+stmt);

			try {
				rs = stmt.executeQuery();
				System.out.println("Consulta -> Resultset sendo executado -> "+rs);			
			}
			catch (SQLException ex) {
				throw new Exception(ex);
                            //    System.out.println(ex.getMessage());
			
			}
			finally {
				System.out.println("Consulta -> Fechando a conexão com banco de dados no Finally");
				
			}
			

			Pessoa p = null;
			System.out.println("Consultar -> Pessoa p -> "+p);

			if (rs != null) {
				System.out.println("rs não está null!! ");

				if (rs.next()) {
					System.out.println("Consulta -> fazendo uma varredura na tabela ... ");
					
					p = new Pessoa();
					System.out.println("Consulta -> Criando objeto Pessoa"+p);

					p.setIdPessoa(rs.getInt("idPessoa"));
					System.out.println("Consulta -> Pegando o id da pessoa e setando outro "+p.getIdPessoa());

					p.setNomePessoa(rs.getString("nomePessoa"));
					System.out.println("Consulta -> Pegando o nomePessoa da pessoa e setando outro  "+p.getNomePessoa());

					p.setEmail(rs.getString("email"));	
					System.out.println("Consulta -> Pegando o email da pessoa e setando outro  "+p.getEmail());	
					
					
				} 
			}

			close();
			System.out.println("consulta -> Fechando a conexão com o banco de dados...");

		return p ;
			
			
	}

	// método para listar as pessoas do banco de dados
	public List<Pessoa> ListarPessoas() {
		try {
			open();
			System.out.println("ListarPessoas -> Conectando ao banco de dados...");

			stmt = con.prepareStatement("SELECT * FROM pessoa");
			System.out.println("ListarPessoas -> Preparando a conexão -> "+stmt);
			rs = stmt.executeQuery();
			System.out.println("ListarPessoas -> Executando a Query -> "+rs);

	        List<Pessoa> listaPessoas = new ArrayList<>();
			System.out.println("ListarPessoas -> Criando uma ArrayList -> PESSOA. ");

			while (rs.next()) {
				Pessoa p = new Pessoa();
				p.setIdPessoa(rs.getInt("idPessoa"));
				p.setNomePessoa(rs.getString("nomePessoa"));
				p.setEmail(rs.getString("email"));
				listaPessoas.add(p);
			}
			close();
			System.out.println("ListarPessoas -> Fechando a conexão com o banco de dados...");

			System.out.println("ListarPessoas -> Retorna lista de pessoas..."+listaPessoas);
			
			return listaPessoas;
		 	
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			
			return null;
			
		}
	}
}