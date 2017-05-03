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
	}
	
}