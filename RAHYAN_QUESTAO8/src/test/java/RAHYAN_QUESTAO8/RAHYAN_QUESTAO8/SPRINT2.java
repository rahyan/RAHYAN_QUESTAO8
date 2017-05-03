package RAHYAN_QUESTAO8.RAHYAN_QUESTAO8;

import static org.junit.Assert.*;
import org.junit.Test;

public class SPRINT2 {

	@Test
	public void registrandoRetiradasDevolucoes() {
		Biblioteca biblioteca = new Biblioteca();
		Bibliotecaria bibliotecaria = biblioteca.contratarBibliotecaria();
		
		Usuario user1 = new Usuario("Pedro");
		Usuario user2 = new Usuario("Ernesto");
		Usuario user3 = new Usuario("Irineu");
		Usuario user4 = new Usuario("Rahyan");
		Livro livro1 = new Livro("Cândido, ou O Otimismo");
		Livro livro2 = new Livro("Ensaio sobre a Cegueira");
		Livro livro3 = new Livro("Cem Anos de Solidão");
		
		bibliotecaria.adicionarUsuario(user1);
		bibliotecaria.adicionarUsuario(user2);
		bibliotecaria.adicionarUsuario(user3);
		bibliotecaria.bloquearUsuarioPorAtraso(user3);
		bibliotecaria.adicionarLivro(livro1);
		bibliotecaria.adicionarLivro(livro3);
		
		//Usuário liberado alugando livro disponível: True
		assertTrue(bibliotecaria.registrarRetiradaLivro(livro1, user1));
		//Usuário liberado alugando livro que não existe na biblioteca: False
		assertFalse(bibliotecaria.registrarRetiradaLivro(livro2, user1));
		//Usuário liberado alugando livro indisponível: False
		assertFalse(bibliotecaria.registrarRetiradaLivro(livro1, user2));
		//Usuário bloqueado alugando livro disponível: False
		assertFalse(bibliotecaria.registrarRetiradaLivro(livro2, user3));
		//Usuário não registrado alugando livro disponível: False
		assertFalse(bibliotecaria.registrarRetiradaLivro(livro2, user4));
		
		//Devolução de livro indisponível: True
		assertTrue(bibliotecaria.registrarDevolucaoLivro(livro1));
		//Usuário liberado alugando livro que foi devolvido (disponível): True
		assertTrue(bibliotecaria.registrarRetiradaLivro(livro1, user2));
		//Devolução de livro disponível: False
		assertFalse(bibliotecaria.registrarDevolucaoLivro(livro3));
		//Usuário liberado alugando outro livro disponível: True
		assertTrue(bibliotecaria.registrarRetiradaLivro(livro3, user2));
	}

}
