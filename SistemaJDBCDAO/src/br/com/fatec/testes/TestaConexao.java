package br.com.fatec.testes;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.fatec.factory.ConnectionFactory;

public class TestaConexao {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Connection conn;
         conn= ConnectionFactory.createConnection();// criar a conexão
         System.out.println("Conexão aberta com sucesso!");
        
	}

}
