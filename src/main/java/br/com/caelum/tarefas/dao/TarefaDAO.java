package br.com.caelum.tarefas.dao;

import br.com.caelum.tarefas.jdbc.*;
import br.com.caelum.tarefas.modelo.Tarefa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


public class TarefaDAO {

	private Connection conexao = null;

	// Construtor que sempre realiza a conexao ao chamar o DAO
	public TarefaDAO(){

	conexao = new ConnectionFactory().getConnection();

	}
	
	// Funcao para adicionar uma Tarafa
	public void adiciona(Tarefa tarefa){
			
			try{
				
				String sql = "Insert into tarefas " +
					 	 	 "(descricao) " +
					 	     "values (?) ";
				
				PreparedStatement stmt = conexao.prepareStatement(sql);
				
				stmt.setString(1, tarefa.getDescricao());
				
				stmt.execute();
				stmt.close();
			
			} catch (Exception e){
				throw new RuntimeException(e);
			}
			
	} //Fim do método adicionaContato
	
	// Função para retornar todos os resultados da tabela "Tarefas" em um objeto do tipo "Lista"
		
	public List<Tarefa> getListaTarefa(){
		
		try{

			List<Tarefa> listaTarefa = new ArrayList<>();
			
			String sql = "Select * from Tarefas";
			
			PreparedStatement stmt = conexao.prepareStatement(sql);
			
			ResultSet rs = stmt.executeQuery();
			
			rs.beforeFirst();
			while (rs.next()){
				
				Tarefa tarefa = new Tarefa();
				
				tarefa.setId(rs.getLong("id"));
				tarefa.setDescricao(rs.getString("descricao"));
				tarefa.setFinalizado(rs.getBoolean("finalizado"));
				
				//Condição que verifica a data nula
				if (rs.getString("dataFinalizacao") != null){
				
				//Convertendo a data de "String" para "Date/Calendar"
				String dataFinalizacaoString = rs.getString("dataFinalizacao");
				DateFormat dataFinalizacaoDate = new SimpleDateFormat("yyyy-MM-dd");
				Calendar dataFinalizacao  = Calendar.getInstance();
				dataFinalizacao.setTime(dataFinalizacaoDate.parse(dataFinalizacaoString));
				
				tarefa.setDataFinalizacao(dataFinalizacao);
				}
				
				// Adicionando ao objeto Tarefa
				listaTarefa.add(tarefa);
	
			} //Fim do While
			
			//Fecha Objetos
			rs.close();
			stmt.close();
			
			// Retorna Lista
			return listaTarefa; 
			
		} catch (Exception e){
			throw new RuntimeException(e);
		}
		
	} //Fim do método getLista
	
	// Método para remover um registro a partir de seu ID
	public void remove(Tarefa tarefa){
		
		try{
			
			String sql = "delete from tarefas " +
						 "where id = ? ";
			
			PreparedStatement stmt = conexao.prepareStatement(sql);
			
			stmt.setLong(1, tarefa.getId());
			
			stmt.execute();
			stmt.close();	
			
		} catch (Exception e){
			throw new RuntimeException(e);
		}
		
	} // Fim do método remove
	
	public void altera(Tarefa tarefa){
		
		try {
			
			String sql = "select * from tarefas " +
						 "where id = ? ";
			
			//Necessário para dar update em um ResultSet
			PreparedStatement stmt = conexao.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE,
			          ResultSet.CONCUR_UPDATABLE);
			
			stmt.setLong(1, tarefa.getId());
			
			ResultSet rs = stmt.executeQuery();
			
			rs.beforeFirst();
			
			while (rs.next()){
				
				rs.updateString("descricao", tarefa.getDescricao());
				rs.updateBoolean("finalizado", tarefa.getFinalizado());
				
				//Convertendo a data de "Date/Calendar" para "String"				
				DateFormat dataFinalizacaoDate = new SimpleDateFormat("yyyy-MM-dd");
				String dataFinalizacaoString = dataFinalizacaoDate.format(tarefa.getDataFinalizacao().getTime());
				
				rs.updateString("dataFinalizacao", dataFinalizacaoString);

				rs.updateRow();
			}
			
		} catch (Exception e){
			throw new RuntimeException(e);
		}
		
	} // Fim do método altera
	
	// Função para retornar todos os resultados da tabela "Tarefas" em um objeto do tipo "Lista"
	
		public Tarefa getVisualizarTarefa(Tarefa tarefaId){
			
			try{

				String sql = "select * from tarefas " +
						 	 "where id = ? ";
				
				PreparedStatement stmt = conexao.prepareStatement(sql);
				
				stmt.setLong(1, tarefaId.getId());
				
				
				ResultSet rs = stmt.executeQuery();
				
				Tarefa tarefa = new Tarefa();
				
				rs.beforeFirst();
				while (rs.next()){
					
					tarefa.setId(rs.getLong("id"));
					tarefa.setDescricao(rs.getString("descricao"));
					tarefa.setFinalizado(rs.getBoolean("finalizado"));
					
					//Condição que verifica a data nula
					if (rs.getString("dataFinalizacao") != null){
					
					//Convertendo a data de "String" para "Date/Calendar"
					String dataFinalizacaoString = rs.getString("dataFinalizacao");
					DateFormat dataFinalizacaoDate = new SimpleDateFormat("yyyy-MM-dd");
					Calendar dataFinalizacao  = Calendar.getInstance();
					dataFinalizacao.setTime(dataFinalizacaoDate.parse(dataFinalizacaoString));
					
					tarefa.setDataFinalizacao(dataFinalizacao);
					}
		
				} //Fim do While
				
				//Fecha Objetos
				rs.close();
				stmt.close();
				
				// Retorna Lista
				return tarefa;
				
			} catch (Exception e){
				throw new RuntimeException(e);
			}
			
		} //Fim do método getVisualizarTarefa
		
		
		// Funcao para adicionar uma Tarafa
		public void finalizaTarefa(Long id){
				
				try{
					
					String sql = "Update tarefas " +
						 	 	 "Set finalizado = true " +
						 	     "Where id = ?";
					
					PreparedStatement stmt = conexao.prepareStatement(sql);
					
					stmt.setLong(1, id);
					
					stmt.execute();
					stmt.close();
				
				} catch (Exception e){
					throw new RuntimeException(e);
				}
				
		} //Fim do método adicionaContato

	
	
		
} //Fim da Classe TarefaDAO
