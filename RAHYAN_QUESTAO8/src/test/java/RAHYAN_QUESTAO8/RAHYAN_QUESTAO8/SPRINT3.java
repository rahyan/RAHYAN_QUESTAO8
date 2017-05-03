package RAHYAN_QUESTAO8.RAHYAN_QUESTAO8;

import static org.junit.Assert.*;

import org.junit.Test;

public class SPRINT3 {

	@Test
	public void usuarioPesquisandoLivros() {
		Biblioteca biblioteca = new Biblioteca();
		Bibliotecaria bibliotecaria = biblioteca.contratarBibliotecaria();
		
		Usuario user1 = new Usuario("Pedro");
		Usuario user2 = new Usuario("Irineu");
		Livro livro1 = new Livro("Cândido, ou O Otimismo");
		Livro livro2 = new Livro("Ensaio sobre a Cegueira");
		Livro livro3 = new Livro("Cem Anos de Solidão");
		
		bibliotecaria.adicionarUsuario(user1);
		bibliotecaria.adicionarLivro(livro1);
		bibliotecaria.adicionarLivro(livro2);
		bibliotecaria.registrarRetiradaLivro(livro1, user1);
		
		//Usuário cadastrado pesquisando livro indisponível: True
		assertTrue(user1.pesquisarLivro(livro1));
		//Usuário cadastrado pesquisando livro disponpível: True
		assertTrue(user1.pesquisarLivro(livro2));
		//Usuário cadastrado pesquisando livro não cadastrado: False
		assertFalse(user1.pesquisarLivro(livro3));
		
		user1.perderLivro(livro1);
		
		//Usuário cadastrado pesquisando livro extraviado: True
		assertTrue(user1.pesquisarLivro(livro1));
		//Usuário não cadastrado pesquisando livro: False
		assertFalse(user2.pesquisarLivro(livro2));
		
	}

}
