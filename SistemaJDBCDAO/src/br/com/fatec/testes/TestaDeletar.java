package br.com.fatec.testes;

import java.sql.SQLException;

import br.com.fatec.dao.UsuarioDAO;

public class TestaDeletar {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		
		UsuarioDAO.removeById(1);
		
	}

}
