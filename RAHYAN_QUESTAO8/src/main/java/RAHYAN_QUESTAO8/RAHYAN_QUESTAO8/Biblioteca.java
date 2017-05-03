package RAHYAN_QUESTAO8.RAHYAN_QUESTAO8;

import java.util.ArrayList;

public class Biblioteca {
	
	ArrayList<Livro> bancoLivros = new ArrayList<Livro> ();	
	ArrayList<Usuario> bancoUsuarios = new ArrayList<Usuario> ();
	
	public int numeroUsuarios(){
		return bancoUsuarios.size();
	}
	
	public Bibliotecaria contratarBibliotecaria(){
		return new Bibliotecaria(this);
	}
	
}