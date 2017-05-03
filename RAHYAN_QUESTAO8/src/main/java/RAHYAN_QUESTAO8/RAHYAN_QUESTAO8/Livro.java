package RAHYAN_QUESTAO8.RAHYAN_QUESTAO8;

public class Livro {
	String nome;
	int situacao; //0: disponível; 1: retirado; 2: extraviado
	int diasQueFaltamParaSerDevoldido;
	Usuario owner;
	
	public Livro(String nome){
		this.nome = nome;
		situacao = 0;
		diasQueFaltamParaSerDevoldido = 0;
		owner = null;
	}
}

