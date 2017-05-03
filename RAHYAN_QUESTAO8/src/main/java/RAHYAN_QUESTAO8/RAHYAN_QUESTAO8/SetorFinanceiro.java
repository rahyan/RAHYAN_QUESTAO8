package RAHYAN_QUESTAO8.RAHYAN_QUESTAO8;

import java.util.Iterator;

public class SetorFinanceiro {
		public boolean desbloquearUsuario(Usuario user){
			if(user.status != 2) {
				//System.out.println("Usuário não está bloqueado por extravio!");
				return false;
			}
			else{
				boolean todosLivrosExtraviadosPagos = true;
				boolean algumLivroForaDoPrazo = false;
				
				for (Iterator iterator = user.livrosAlugados.iterator(); iterator.hasNext(); ) { 
					Livro livro = (Livro) iterator.next();
					if(livro.situacao == 2 && !livro.extraviadoPago) todosLivrosExtraviadosPagos = false;
					if(livro.situacao == 1) algumLivroForaDoPrazo = true;
				}
				
				if(todosLivrosExtraviadosPagos && !algumLivroForaDoPrazo) user.status = 0;
				if(todosLivrosExtraviadosPagos && algumLivroForaDoPrazo) user.status = 1;
				return true;
			}
		}
}
