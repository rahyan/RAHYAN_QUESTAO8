package RAHYAN_QUESTAO8.RAHYAN_QUESTAO8;

import java.util.ArrayList;

public class Usuario {
	
	
	String nome;
	int ID;
	int status; //0: liberado; 1: bloqueado por atraso; 2: bloqueado por extravio
	
	ArrayList<Livro> livrosAlugados = new ArrayList<Livro> ();
	
	public Usuario (String nome, int ID){
		this.nome = nome;
		this.ID = ID;
		this.status = 0;
	}
	
	
}