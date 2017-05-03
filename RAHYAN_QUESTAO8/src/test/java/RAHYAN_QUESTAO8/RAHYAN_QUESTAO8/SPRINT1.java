package RAHYAN_QUESTAO8.RAHYAN_QUESTAO8;

import static org.mockito.Mockito.mock;

import static org.junit.Assert.*;
import org.junit.Test;

public class SPRINT1 {

	@Test
	public void adicionandoRemovendoUsuarios() {
		Biblioteca biblioteca = new Biblioteca();
		Bibliotecaria bibliotecaria = biblioteca.contratarBibliotecaria();
		
		Usuario dummy_user1 = mock(Usuario.class);
		Usuario dummy_user2 = mock(Usuario.class);
		Usuario dummy_user3 = mock(Usuario.class);
		Usuario dummy_user4 = mock(Usuario.class);
		Usuario dummy_user5 = mock(Usuario.class);
		Usuario dummy_user6 = mock(Usuario.class);

		assertTrue(bibliotecaria.adicionarUsuario(dummy_user1));
		assertEquals(biblioteca.numeroUsuarios(), 1);
		
		assertTrue(bibliotecaria.adicionarUsuario(dummy_user2));
		assertTrue(bibliotecaria.adicionarUsuario(dummy_user3));
		assertEquals(biblioteca.numeroUsuarios(), 3);
		
		assertTrue(bibliotecaria.adicionarUsuario(dummy_user4));
		assertTrue(bibliotecaria.adicionarUsuario(dummy_user5));
		assertTrue(bibliotecaria.adicionarUsuario(dummy_user6));
		assertEquals(biblioteca.numeroUsuarios(), 6);
		
		assertFalse(bibliotecaria.adicionarUsuario(dummy_user1));
		assertEquals(biblioteca.numeroUsuarios(), 6);
		
		assertFalse(bibliotecaria.adicionarUsuario(dummy_user2));
		assertFalse(bibliotecaria.adicionarUsuario(dummy_user3));
		assertFalse(bibliotecaria.adicionarUsuario(dummy_user4));
		assertFalse(bibliotecaria.adicionarUsuario(dummy_user5));
		assertFalse(bibliotecaria.adicionarUsuario(dummy_user6));
		assertEquals(biblioteca.numeroUsuarios(), 6);
		
		assertTrue(bibliotecaria.removerUsuario(dummy_user1));
		assertEquals(biblioteca.numeroUsuarios(), 5);
		assertTrue(bibliotecaria.removerUsuario(dummy_user2));
		assertEquals(biblioteca.numeroUsuarios(), 4);
		assertTrue(bibliotecaria.removerUsuario(dummy_user3));
		assertEquals(biblioteca.numeroUsuarios(), 3);
		assertTrue(bibliotecaria.removerUsuario(dummy_user4));
		assertEquals(biblioteca.numeroUsuarios(), 2);
		assertTrue(bibliotecaria.removerUsuario(dummy_user5));
		assertEquals(biblioteca.numeroUsuarios(), 1);
		assertTrue(bibliotecaria.removerUsuario(dummy_user6));
		assertEquals(biblioteca.numeroUsuarios(), 0);
		
		assertFalse(bibliotecaria.removerUsuario(dummy_user1));
		assertFalse(bibliotecaria.removerUsuario(dummy_user2));
		assertFalse(bibliotecaria.removerUsuario(dummy_user3));
		assertFalse(bibliotecaria.removerUsuario(dummy_user4));
		assertFalse(bibliotecaria.removerUsuario(dummy_user5));
		assertFalse(bibliotecaria.removerUsuario(dummy_user6));
		assertEquals(biblioteca.numeroUsuarios(), 0);
						
	}

	@Test
	public void bloqueandoUsuarios(){
		Biblioteca biblioteca = new Biblioteca();
		Bibliotecaria bibliotecaria = biblioteca.contratarBibliotecaria();
		
		Usuario dummy_user1 = mock(Usuario.class);
		Usuario dummy_user2 = mock(Usuario.class);
		
		bibliotecaria.adicionarUsuario(dummy_user1);
		
		assertTrue(bibliotecaria.bloquearUsuarioPorAtraso(dummy_user1));
		assertEquals(dummy_user1.status, 1);
		assertFalse(bibliotecaria.bloquearUsuarioPorAtraso(dummy_user2));
		
	}

}
