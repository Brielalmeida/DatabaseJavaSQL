package br.com.fatec.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.fatec.factory.ConnectionFactory;
import br.com.fatec.model.Usuario;


public class UsuarioDAO {
	
	public static void insere(Usuario user) throws SQLException{
        String sql="INSERT INTO usuarios(nome,login,senha) VALUES (?,?,?) ";
        Connection conn= null;
        PreparedStatement pstm=null;
        try{
            //criar uma conexão com o BD
            conn= ConnectionFactory.createConnection();
            //Preparando a query
            pstm= (PreparedStatement) conn.prepareStatement(sql);
           // indicar as substituições na query- noem, login e senha do usuário
            pstm.setString(1,user.getNome());
            pstm.setString(2, user.getLogin());
            pstm.setString(3,user.getSenha());
            //Executando a query
             pstm.execute();

        }catch(Exception e){
            e.printStackTrace();
        }finally{
            if(pstm!=null)pstm.close();
            if(conn!=null)conn.close();
        }
             
    }//fim insere
    
    public static void removeById(int id){

    	String sql = "DELETE FROM usuarios WHERE id = ?";
    	Connection conn = null;
    	PreparedStatement pstm = null;

    	try {
    		conn = ConnectionFactory.createConnection();
    		pstm = conn.prepareStatement(sql);

    		pstm.setInt(1, id);
    		pstm.execute();

    	} catch (Exception e) {
    		e.printStackTrace();
    	}finally{

    		try{
    			if(pstm != null){

    				pstm.close();
    			}

    			if(conn != null){
    				conn.close();
    			}

    		}catch(Exception e){
    			e.printStackTrace();
    		}
    	}
    }
    	
	public static ArrayList<Usuario> listarUsuarios(){

    	String sql = "SELECT * FROM usuarioS";
    	ArrayList<Usuario> usuarios = new ArrayList<>();
    	Connection conn = null;
    	PreparedStatement pstm = null;
    	ResultSet rset = null;
	    try {
	    	conn = ConnectionFactory.createConnection();
	
	    	pstm = conn.prepareStatement(sql);
	    	rset = pstm.executeQuery();
	    	
	    	while(rset.next()) {
	    		Usuario user = new Usuario();
	       	 	//Recupera o id do banco e atribui ele ao objeto
	       	 	user.setId(rset.getInt("id"));
	       	 	//Recupera o nome do banco e atribui ele ao objeto
	       	 	user.setNome(rset.getString("nome"));
	       	 	//Recupera a idade do banco e atribui ele ao objeto
	       	 	user.setLogin(rset.getString("login"));
	       	 	//Recupera asenha do banco e atribui ela ao objeto
	       	 	user.setSenha(rset.getString("senha"));
	       	 	//Adiciono o contato recuperado, a lista de contatos
	       	 	usuarios.add(user);
	    		
	    	}
	    } catch (Exception e) {
	    	// TODO Auto-generated catch block
	    	e.printStackTrace();
	    }finally{
	
	        try{
	        	if(pstm != null){
	
	        	pstm.close();
	        	}
	
	        	if(conn != null){
	        	conn.close();
	        	}
	
	        }catch(Exception e){
	
	        	e.printStackTrace();
	        }
	    }
	    
	    return usuarios;
	}
	
	public static void UpdateById(Usuario user){

    	String sql = "UPDATE usuarios SET nome = ?, login = ?, senha = ?" + "WHERE id = ?";
    	Connection conn = null;
    	PreparedStatement pstm = null;

    	try {
    		conn = ConnectionFactory.createConnection();
    		pstm = conn.prepareStatement(sql);
    		
    		pstm.setString(1,user.getNome());
            pstm.setString(2, user.getLogin());
            pstm.setString(3,user.getSenha());
            
            pstm.setLong(4, user.getId());
    		
    		pstm.execute();

    	} catch (Exception e) {
    		e.printStackTrace();
    	}finally{

    		try{
    			if(pstm != null){

    				pstm.close();
    			}

    			if(conn != null){
    				conn.close();
    			}

    		}catch(Exception e){
    			e.printStackTrace();
    		}
    	}
    }
}
