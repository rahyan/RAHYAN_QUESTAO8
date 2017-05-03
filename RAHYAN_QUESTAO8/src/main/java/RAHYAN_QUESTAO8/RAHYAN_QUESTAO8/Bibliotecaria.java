package RAHYAN_QUESTAO8.RAHYAN_QUESTAO8;

public class Bibliotecaria {

	private Biblioteca biblioteca;
	
	public Bibliotecaria(Biblioteca biblioteca){
		this.biblioteca = biblioteca;
	}
	
	public boolean adicionarUsuario(Usuario user){
		if(biblioteca.bancoUsuarios.contains(user)){
			//System.out.println("Usuário já cadastrado!");
			return false;
		}
		else {
			biblioteca.bancoUsuarios.add(user);
			return true;
		}
	}
	
	public boolean removerUsuario(Usuario user){
		if(!biblioteca.bancoUsuarios.contains(user)){
			//System.out.println("Usuário não cadastrado, impossível remover!");
			return false;
		}
		else {
			biblioteca.bancoUsuarios.remove(user);
			return true;
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
}