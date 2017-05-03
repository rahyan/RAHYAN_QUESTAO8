package RAHYAN_QUESTAO8.RAHYAN_QUESTAO8;

import java.util.ArrayList;

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
				else if(livro.situacao == 1) System.out.println("retirado.");
				else if(livro.situacao == 2) System.out.println("extraviado.");
				return true;
			}
		}
	}
	
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
	
}