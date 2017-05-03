package RAHYAN_QUESTAO8.RAHYAN_QUESTAO8;

import static org.junit.Assert.*;

import org.junit.Test;

public class SPRINT4 {

	@Test
	public void listandoLivros() {
		Biblioteca biblioteca = new Biblioteca();
		Bibliotecaria bibliotecaria = biblioteca.contratarBibliotecaria();
		
		Usuario user1 = new Usuario("Pedro");
		Usuario user2 = new Usuario("Irineu");
		Usuario user3 = new Usuario("Ernesto");
		Usuario user4 = new Usuario("Rahyan");
		Livro livro1 = new Livro("Cândido, ou O Otimismo");
		Livro livro2 = new Livro("Ensaio sobre a Cegueira");
		Livro livro3 = new Livro("Cem Anos de Solidão");
		
		bibliotecaria.adicionarUsuario(user1);
		bibliotecaria.adicionarUsuario(user2);
		bibliotecaria.adicionarUsuario(user3);
		bibliotecaria.adicionarLivro(livro1);
		bibliotecaria.adicionarLivro(livro2);
		bibliotecaria.adicionarLivro(livro3);
		bibliotecaria.registrarRetiradaLivro(livro1, user1);
		bibliotecaria.registrarRetiradaLivro(livro2, user1);
		bibliotecaria.registrarRetiradaLivro(livro3, user1);
		
		user1.expirarPrazoDevolucaoLivro(livro2);
		user1.perderLivro(livro3);
		
		bibliotecaria.bloquearUsuarioPorAtraso(user2);
		bibliotecaria.bloquearUsuarioPorExtravio(user3);
		
		assertTrue(user1.listarLivrosRetirados());
		
		//Acessando perfil de usuários cadastrados: True
		assertTrue(user1.acessarPerfil());
		assertTrue(user2.acessarPerfil());
		assertTrue(user3.acessarPerfil());
		//Acessando perfil de usuário não cadastrado: False
		assertFalse(user4.acessarPerfil());
		
	}

}
