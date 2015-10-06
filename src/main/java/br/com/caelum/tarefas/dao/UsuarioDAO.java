package br.com.caelum.tarefas.dao;

import br.com.caelum.tarefas.jdbc.*;
import br.com.caelum.tarefas.modelo.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class UsuarioDAO {

	private Connection conexao = null;

	// Construtor que sempre realiza a conexao ao chamar o DAO
	public UsuarioDAO(){

	conexao = new ConnectionFactory().getConnection();

	}
	
	// Funcao para adicionar um Usuario
		public void adicionaUsuario(Usuario usuario){
				
			try{
				
				String sql = "Insert into Usuarios " +
							 "(login, nome, email, senha) "+
							 "(?, ?, ?, ?) ";
				
				PreparedStatement stmt = conexao.prepareStatement(sql);
				
				stmt.setString(1, usuario.getLogin());
				stmt.setString(2, usuario.getNome());
				stmt.setString(3, usuario.getEmail());
				stmt.setString(4, usuario.getSenha());
					
				stmt.execute();
				stmt.close();
					
			} catch (Exception e){
				throw new RuntimeException(e);
			}
				
		} //Fim do método adicionaUsuario
	
	//Função para verificar um usuario no sistema
		public boolean existeUsuario(Usuario usuario){
			
			try {
				
				String sql = "Select * from Usuarios " +
							 "Where login = ? " +
							 "	and senha = ? " ;
				
				PreparedStatement stmt = conexao.prepareStatement(sql);
				
				stmt.setString(1, usuario.getLogin());
				stmt.setString(2, usuario.getSenha());
				
				ResultSet rs = stmt.executeQuery();
				
				rs.beforeFirst();
				
				if (rs.next()){
					return true;
				}
				else{ 
					return false;
				}
				
			} catch (Exception e){
				throw new RuntimeException(e);
			}
			
		}
		
}