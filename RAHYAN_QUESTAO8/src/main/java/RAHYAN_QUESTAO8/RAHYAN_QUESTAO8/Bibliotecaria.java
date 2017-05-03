package RAHYAN_QUESTAO8.RAHYAN_QUESTAO8;

public class Bibliotecaria {

	private Biblioteca biblioteca;
	
	public Bibliotecaria(Biblioteca biblioteca){
		this.biblioteca = biblioteca;
	}
	
	//Esse método foi criado para ajudar na criação do banco de livros
	public void adicionarLivro(Livro livro){
		biblioteca.bancoLivros.add(livro);
	}
	
	public boolean adicionarUsuario(Usuario user){
		if(biblioteca.bancoUsuarios.contains(user)){
			//System.out.println("Usuário já cadastrado!");
			return false;
		}
		else {
			biblioteca.bancoUsuarios.add(user);
			user.biblioteca = biblioteca;
			return true;
		}
	}
	
	public boolean removerUsuario(Usuario user){
		if(!biblioteca.bancoUsuarios.contains(user)){
			//System.out.println("Usuário não cadastrado, impossível remover!");
			return false;
		}
		else {
			if(user.status == 0){
				biblioteca.bancoUsuarios.remove(user);
				return true;
			}
			else{
				//System.out.println("Usuário deve devolver quitar todas dívidas antes de ser removido!");
				return false;
			}
		}
	}
	
	public boolean bloquearUsuarioPorAtraso(Usuario user){
		if(!biblioteca.bancoUsuarios.contains(user)){
			//System.out.println("Usuário não cadastrado, impossível bloquear!");
			return false;
		}
		else{
			user.status = 1;
			return true;
		}
	}
	
	public boolean bloquearUsuarioPorExtravio(Usuario user){
		if(!biblioteca.bancoUsuarios.contains(user)){
			//System.out.println("Usuário não cadastrado, impossível bloquear!");
			return false;
		}
		else{
			user.status = 2;
			return true;
		}
	}
	
	public boolean registrarRetiradaLivro(Livro livro, Usuario user){
		
		if(!biblioteca.bancoUsuarios.contains(user)){
			//System.out.println("Apenas usuários cadastrados podem utilizar o sistema");
			return false;
		}
		
		else{
			if(!biblioteca.bancoLivros.contains(livro)) {
				//System.out.println("Livro não encontrado na biblioteca!");
				return false; 
			}
		
			else{
				if(user.status == 0){
					if(livro.situacao == 0){
						livro.situacao = 1;
						livro.diasQueFaltamParaSerDevoldido = 3; //Decidi que o usuario tem 3 dias para devolver o livro
						livro.owner = user;
						user.livrosAlugados.add(livro);
						System.out.println("Livro '"+ livro.nome + "' retirado por " + user.nome + "!");
						return true;
					}
					else{
						//System.out.println("Livro indisponível para retirada!");
						return false;
					}
				}
				else{
					//System.out.println("Usuário está bloqueado para retirada de mais livros");
					return false;
				}
			}
		}
	}
	
	public boolean registrarDevolucaoLivro(Livro livro){

		if(!biblioteca.bancoLivros.contains(livro)) {
			//System.out.println("Livro não registrado na biblioteca!");
			return false; 
		}
		
		else{
			if(livro.situacao == 0){
				//System.out.println("O livro está disponível no sistema, impossível devolvê-lo!");
				return false;
			}
			else{
				System.out.println("Livro '"+ livro.nome + "' devolvido por " + livro.owner.nome + "!");
				livro.owner.livrosAlugados.remove(livro);
				livro.situacao = 0;
				livro.diasQueFaltamParaSerDevoldido = 0;
				livro.owner = null;
				return true;
			}
		}
	}
	
	public boolean pesquisarLivro(Livro livro){
		if(biblioteca == null){
			//System.out.println("Bibliotecária não cadastrada no sistema!");
			return false;
		}
		else{
			if(!biblioteca.bancoLivros.contains(livro)){
				System.out.println("Esse livro não existe na biblioteca!");
				return false;
			}
			else{
				System.out.println("Livro: " + livro.nome + ".");
				System.out.print("Situação: ");
				if(livro.situacao == 0) System.out.println("disponível.");
				else if(livro.situacao == 1) {
					if(livro.diasQueFaltamParaSerDevoldido >= 0) System.out.println("retirado.");
					else System.out.println("retirado, porém fora do prazo de entrega");
				}
				else if(livro.situacao == 2) System.out.println("extraviado.");
				return true;
			}
		}
	}
	
}