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

    System.out.println("=================== Incluir Pessoa ============================");
			/* Está funcionando perfeitamente */
		/* 
			// Incluir uma pessoa
			Pessoa p1 = new Pessoa(17,"jose", "jose@gmail.com");
			Pessoa p2 = new Pessoa(26,"joao", "joao@gmail.com");
			pd.incluirPessoa(p1);
			pd.incluirPessoa(p2);
        */       
                     
	System.out.println("==================Consultar Pessoa Individual ============================");
				/*   Está Funcionando perfeitamente    */
			/* 
				// Você passa qual é o id da pessoa que deseja consultar
				System.out.println("Resposta da consulta Pessoa Individual:\n "
				+pd.consultarPessoaIndividual(22));
			*/
                       
    System.out.println("============================ listar ====================================");
				/*  Está funcionando  */
			/* 
				// exibi a lista das pessoas que estão no banco de dados
				System.out.println("Listas do banco de dados \n -> "+pd.ListarPessoas());
            */   

	System.out.println("========================= Alterar Pessoa ===============================");			

                     

		
			
			// Alterar uma pessoa
			// - Alterar a informa��o desejada usando o set(Classe encapsulada)
			try {
				Pessoa pes = pd.consultarPessoaIndividual(3);
			
				// se o resultado da consulta a pessoa retornar null � porque n�o encontrou
				// a pessoa
				if (pes != null) {
						pes.setEmail("joao2@gmail.com");
						// chamar o m�todo de cont�m o comando update
						pd.alterarPessoa(pes);
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
                        

    System.out.println("========================= Excluir Pessoa ==============================");                    
                        
			/*
			// Excluir uma pessoa    
			// verificar se a pessoa existe por c�digo
			Pessoa pessoa1 = pd.consultarPessoaIndividual(1);
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
	System.out.println("============================ FIM =====================================");		
			
		} catch (Exception e) {
			System.out.println("Error:  " + e.getMessage());
		}		
		
	}
}

