/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.giovani.cadastro;

/**
 *
 * @author giova
 */
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Dao {
	
	Connection con;  // Conexao ao Banco de Dados
	PreparedStatement stmt; // Acessa a Tabela ( insert, update, delete , select)
	ResultSet rs; // Consulta a Tabela( select )
	CallableStatement call; // Procedures e Function
	
	public void open() throws Exception{
		// pega o endereço do banco de dados, e salva na variável -> url
	    String url = "jdbc:mysql://localhost:3306/cadastro";

		// pega o nome de usuário, na variável -> user
	    String user = "root";

		// pega a senha, e salva na variável
	    String password = "";

		// try -> para tratar possivéis erros nessa parte do código
	    try {
			// instancia a classe for name -> pega o endereço do drive que fará a conexão com o banco de dados
	        Class.forName("com.mysql.cj.jdbc.Driver");

			// pega os valores das variáves e salva na variável de Connection -> con
	        con = DriverManager.getConnection(url, user, password);

			// exibi essa mensagem para dizer que deu certo a conexão com o banco de dados
	        System.out.println("Dao => Conectado ao banco de dados....");

	    } catch (SQLException | ClassNotFoundException ex) {

			// se der erro vai exibir essa mensagem
	        System.out.println("Dao => Erro ao conectar com o banco");
	    }
	}
	
	// método para fechar a conexão com o banco de dados
	public void close() throws Exception{
		
		// fecha a conexão
		con.close();
	}


}