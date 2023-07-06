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
		System.out.println("Conectado ao banco de dados");

		stmt = con.prepareStatement("INSERT INTO pessoa VALUES (?,?,?)");

		stmt.setInt(1, p.getIdPessoa());
		System.out.println("Pegando o idPessoa e seta outro...");

		stmt.setString(2, p.getNomePessoa());
		System.out.println("Pegando o nomePessoa e setando outro...");

		stmt.setString(3, p.getEmail());
		System.out.println("Pegando o email e setando outro email...");

		stmt.execute();
		System.out.println("executando o stmt...");

		stmt.close();
		System.out.println("Conectado ao banco de dados");

		close();
		System.out.println("Fechando a conexão com o banco de dados");
	}

	
	public void alterarPessoa(Pessoa p) throws Exception {
		open();
		stmt = con.prepareStatement("UPDATE pessoa SET idPessoa ?, nomePessoa = ?, email = ? WHERE = ?");
		stmt.setString(1, p.getNomePessoa());
		stmt.setString(2, p.getEmail());
		stmt.setInt(3, p.getIdPessoa());
		stmt.execute();
		stmt.close();
		close();
	}

	public void excluirPessoa(Pessoa p) throws Exception {

		open();
		stmt = con.prepareStatement("DELETE FROM pessoa WHERE idPessoa = ?");
		stmt.setInt(1, p.getIdPessoa());
		stmt.execute();
		stmt.close();
		close();

	}
	

	// método para fazer consultas individual
	public Pessoa consultarPessoaIndividual(int cod) throws Exception {
			open();
			System.out.println("Fazendo a conexão com o banco de dados...");

			stmt = con.prepareStatement("SELECT * FROM pessoa WHERE idPessoa = ? ");
			System.out.println("Preparando a conexão sql -> "+stmt);

			stmt.setInt(1, cod);
			System.out.println("Setando o parâmetro recebido -> "+stmt);

			try {
				rs = stmt.executeQuery();
				System.out.println("Resultset sendo executado -> "+rs);			
			}
			catch (SQLException ex) {
				throw new Exception(ex);
                            //    System.out.println(ex.getMessage());
			
			}
			finally {
				System.out.println("Fechando a conexão com banco de dados no Finally");
				
			}
			

			Pessoa p = null;
			System.out.println("Pessoa p -> "+p);

			if (rs != null) {
				System.out.println("rs não está null!! ");

				if (rs.next()) {
					System.out.println(" fazendo uma varredura na tabela ... ");
					
					p = new Pessoa();
					System.out.println("Criando objeto Pessoa"+p);

					p.setIdPessoa(rs.getInt("idPessoa"));
					System.out.println("Pegando o id da pessoa e setando outro "+p.getIdPessoa());

					p.setNomePessoa(rs.getString("nomePessoa"));
					System.out.println("Pegando o nomePessoa da pessoa e setando outro  "+p.getNomePessoa());

					p.setEmail(rs.getString("email"));	
					System.out.println("Pegando o email da pessoa e setando outro  "+p.getEmail());	
					
					System.out.println("Retorno  valor de p -> "+p);
				} 
			}
			close();
			System.out.println("Retorno if -> "+rs);

			return p ;
			
	}

	// método para listar as pessoas do banco de dados
	public List<Pessoa> ListarPessoas() {
		try {
			open();
			System.out.println("Conectando ao banco de dados...");

			stmt = con.prepareStatement("SELECT * FROM pessoa");
			System.out.println("Preparando a conexão -> "+stmt);
			rs = stmt.executeQuery();
			System.out.println("Executando a Query -> "+rs);

	        List<Pessoa> listaPessoas = new ArrayList<>();
			System.out.println("Criando uma ArrayList -> PESSOA. ");

			while (rs.next()) {
				Pessoa p = new Pessoa();
				p.setIdPessoa(rs.getInt("idPessoa"));
				p.setNomePessoa(rs.getString("nomePessoa"));
				p.setEmail(rs.getString("email"));
				listaPessoas.add(p);
			}
			close();
			System.out.println("Fechando a conexão com o banco de dados...");

			System.out.println("Retorna lista de pessoas..."+listaPessoas);
			
			return listaPessoas;
		 	
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			
			return null;
			
		}
	}
}