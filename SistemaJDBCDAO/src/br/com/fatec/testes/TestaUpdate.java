package br.com.fatec.testes;

import br.com.fatec.dao.UsuarioDAO;
import br.com.fatec.model.Usuario;

public class TestaUpdate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Usuario sirley = new Usuario(2, "Sirley Addão","sirley.gmail.com","1234");
		
				
		UsuarioDAO.UpdateById(sirley);

	}

}
