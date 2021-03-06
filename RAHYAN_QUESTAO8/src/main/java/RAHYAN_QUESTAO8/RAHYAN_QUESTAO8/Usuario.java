package RAHYAN_QUESTAO8.RAHYAN_QUESTAO8;

import java.util.ArrayList;
import java.util.Iterator;

public class Usuario {
	
	String nome;
	int status; //0: liberado; 1: bloqueado por atraso; 2: bloqueado por extravio
	Biblioteca biblioteca;
	
	ArrayList<Livro> livrosAlugados = new ArrayList<Livro> ();
	
	public Usuario (String nome){
		this.nome = nome;
		this.status = 0;
		biblioteca = null;
	}
	
	//Método criado para auxiliar na realização dos testes
	public boolean perderLivro(Livro livro){
		if(!this.livrosAlugados.contains(livro)){
			//System.out.println("Impossível perder livro que não está com você!");
			return false;
		}
		else{
			livro.situacao = 2;
			return true;
		}
	}
	
	//Método criado para auxiliar na realização dos testes
	public boolean expirarPrazoDevolucaoLivro(Livro livro){
		if(!this.livrosAlugados.contains(livro)){
			//System.out.println("Impossível perder o prazo de um livro que não está com você!");
			return false;
		}
		else{
			livro.diasQueFaltamParaSerDevoldido = -1;
			return true;
		}
	}
	
	//Método criado para auxiliar na realização dos testes
		public boolean pagarBoletoLivroExtraviado(Livro livro){
			if(!this.livrosAlugados.contains(livro)){
				//System.out.println("Impossível pagar o boleto de um livro que você não retirou!");
				return false;
			}
			else{
				livro.extraviadoPago = true;
				return true;
			}
		}
	
	public boolean pesquisarLivro(Livro livro){
		if(biblioteca == null){
			//System.out.println("Usuário não cadastrado no sistema!");
			return false;
		}
		else{
			if(!biblioteca.bancoLivros.contains(livro)){
				System.out.println("Esse livro não existe na biblioteca!");
				return false;
			}
			else{
				System.out.println("Livro: " + livro.nome + ".");
				System.out.print("Situação: ");
				if(livro.situacao == 0) System.out.println("disponível.");
				else if(livro.situacao == 1) {
					if(livro.diasQueFaltamParaSerDevoldido >= 0) System.out.println("retirado.");
					else System.out.println("retirado, porém fora do prazo de entrega");
				}
				else if(livro.situacao == 2) System.out.println("extraviado.");
				return true;
			}
		}
	}
	
	public boolean listarLivrosRetirados(){
		if(biblioteca == null){
			//System.out.println("Usuário não cadastrado no sistema!");
			return false;
		}
		
		else{
			if(livrosAlugados.isEmpty()){
				System.out.println("Não há nenhum livro pendente!");
				return true;
			}
			else{
				for (Iterator iterator = livrosAlugados.iterator(); iterator.hasNext(); ) { 
						Livro livro = (Livro) iterator.next();
						System.out.print("Livro: " + livro.nome + ". ");
						System.out.print("Situação: ");
						if(livro.situacao == 0) System.out.println("disponível.");
						else if(livro.situacao == 1) {
							if(livro.diasQueFaltamParaSerDevoldido >= 0) System.out.println("retirado.");
							else System.out.println("retirado, porém fora do prazo de entrega");
						}
						else if(livro.situacao == 2) System.out.println("extraviado.");
				}
			return true;
			}
		}
	}
	
	public boolean acessarPerfil(){
		if(biblioteca == null){
			//System.out.println("Usuário não cadastrado no sistema!");
			return false;
		}
		else{
			System.out.print("Olá " + nome + "! Sua situação atual é: ");
			if(status == 0) System.out.println("liberado.");
			else if(status == 1) System.out.println("bloqueado por atraso.");
			else if(status == 2) System.out.println("bloqueado por extravio.");
			return true;
		}
	}
	
}