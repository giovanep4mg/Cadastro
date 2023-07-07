/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.giovani.cadastro;

import java.util.List;

/**
 *
 * @author giova
 */
public class Cadastro {

    public static void main(String[] args) {

        PessoaDao pd = new PessoaDao();
		try {

    System.out.println("=========================== Incluir Pessoa ===============================\n");
			/* Está funcionando perfeitamente */
		/* 
			// Incluir uma pessoa
			Pessoa p1 = new Pessoa(19,"MariaLuiza", "marialuiza@gmail.com");
			Pessoa p2 = new Pessoa(28,"Ana", "ana@gmail.com");
			pd.incluirPessoa(p1);
			pd.incluirPessoa(p2);
        */       
                     
	System.out.println("================== Consultar Pessoa Individual ============================\n");
				/*   Está Funcionando perfeitamente    */
			/* 
				// Você passa qual é o id da pessoa que deseja consultar
				System.out.println("Resposta da consulta Pessoa Individual:\n "
				+pd.consultarPessoaIndividual(22));
			*/
                       
    System.out.println("============================ listar Pessoas ===============================\n");
				/*  Está funcionando  */
			/* 
				// exibi a lista das pessoas que estão no banco de dados
				System.out.println("Listas do banco de dados \n -> "+pd.ListarPessoas());
            */   
			pd.ListarPessoas();

	System.out.println("============================ Alterar Pessoa ===============================\n");			
			/*   Está funcionando perfeitamente  */
		/* 	
			// Alterar uma pessoa
			// - Alterar a informa��o desejada usando o set(Classe encapsulada)
			try {
				Pessoa pes = pd.consultarPessoaIndividual(2);
			
				// se o resultado da consulta a pessoa retornar null � porque n�o encontrou
				// a pessoa
				if (pes != null) {
					System.out.println("Principal -> a consulta não está vazia "+pes);
					
						pes.setEmail("giovani@gmail.com");
						System.out.print("Principal -> setando o email -> "+pes);

						// chamar o m�todo de cont�m o comando update
						pd.alterarPessoa(pes);
						System.out.print("Principal -> chamando o método alterar pessoa e passando os parâmetros -> "+pes);

				} else {

					System.out.println("Pessoa n�o encontrada ou falha no acesso ao banco de dados");
				}
		
				// Listando todas as pessoas
				List<Pessoa> listaPessoas = pd.ListarPessoas();
				for(Pessoa p : listaPessoas){
					System.out.println("Id.: " + p.getIdPessoa());
					System.out.println("Nome : "  +p.getNomePessoa());
					System.out.println("Email : " +p.getEmail());
				}
			}
			catch (Exception ex ){
		        System.out.println("Alguma coisa deu errado no acesso ao banco de dados. Contate a TI");
			}
        */	                

    System.out.println("=========================== Excluir Pessoa ================================\n");                    
                  /* Está funcionando perfeitamente  */      
		/*
			// Excluir uma pessoa    
			// verificar se a pessoa existe por c�digo
			Pessoa pessoa1 = pd.consultarPessoaIndividual(10);
			// chamar o m�todo que cont�m o comando delete
			pd.excluirPessoa(pessoa1);
			// Listando todas as pessoas
			List<Pessoa> listaPessoas = pd.ListarPessoas();
			for(Pessoa p : listaPessoas){
				System.out.println("Id.: " + p.getIdPessoa());
				System.out.println("Nome : "  +p.getNomePessoa());
				System.out.println("Email : " +p.getEmail());
			}
		*/

	System.out.println("=============================== FIM =======================================\n");		
			
		} catch (Exception e) {
			System.out.println("Error:  " + e.getMessage());
		}		
		
	}
}

