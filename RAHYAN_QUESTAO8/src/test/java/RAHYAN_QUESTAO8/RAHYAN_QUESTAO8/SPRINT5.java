package RAHYAN_QUESTAO8.RAHYAN_QUESTAO8;

import static org.junit.Assert.*;

import org.junit.Test;

public class SPRINT5 {

	@Test
	public void testandoBloqueioDesbloqueioPorExtravio() {
		Biblioteca biblioteca = new Biblioteca();
		Bibliotecaria bibliotecaria = biblioteca.contratarBibliotecaria();
		SetorFinanceiro setorFinanceiro = new SetorFinanceiro();
		Usuario user1 = new Usuario("Pedro");
		Livro livro1 = new Livro("Cândido, ou O Otimismo");
		Livro livro2 = new Livro("Ensaio sobre a Cegueira");
		bibliotecaria.adicionarUsuario(user1);
		bibliotecaria.adicionarLivro(livro1);
		bibliotecaria.adicionarLivro(livro2);
		
		//Usúario cadastrado liberado retirando livro disponível: True
		assertTrue(bibliotecaria.registrarRetiradaLivro(livro1, user1));
		//Usuário perde o livro
		assertTrue(user1.perderLivro(livro1));
		assertEquals(livro1.situacao, 2);
		//Usuário é bloqueado pela bibliotecária
		assertTrue(bibliotecaria.bloquearUsuarioPorExtravio(user1));
		assertEquals(user1.status, 2);
		//Setor Financeiro tenta desbloquear o usuário antes do pagamento,
		//status do usuário permanece bloqueado
		assertTrue(setorFinanceiro.desbloquearUsuario(user1));
		assertEquals(user1.status, 2);
		//Usuário paga o boleto do livro extraviado
		assertTrue(user1.pagarBoletoLivroExtraviado(livro1));
		assertTrue(livro1.extraviadoPago);
		//Usuário tenta retirar outro livro antes da liberação do Setor Financeiro
		assertFalse(bibliotecaria.registrarRetiradaLivro(livro2, user1));
		//Usuário é liberado pelo Setor Financeiro
		assertTrue(setorFinanceiro.desbloquearUsuario(user1));
		assertEquals(user1.status, 0);
		
	}
	
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
		
		//Bibliotecária cadastrada pesquisando livro indisponível: True
		assertTrue(bibliotecaria.pesquisarLivro(livro1));
		//Bibliotecária cadastrada pesquisando livro disponpível: True
		assertTrue(bibliotecaria.pesquisarLivro(livro2));
		//Bibliotecária cadastrada pesquisando livro não cadastrado: False
		assertFalse(bibliotecaria.pesquisarLivro(livro3));
		
		user1.perderLivro(livro1);
		
		//Bibliotecária cadastrada pesquisando livro extraviado: True
		assertTrue(bibliotecaria.pesquisarLivro(livro1));
		
	}
}
