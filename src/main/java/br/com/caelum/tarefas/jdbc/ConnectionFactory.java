package br.com.caelum.tarefas.jdbc;

import java.sql.*;


public class ConnectionFactory {


	public Connection getConnection (){
	
	try {
	
	DriverManager.registerDriver(new com.mysql.jdbc.Driver()); //Essa linha foi a diferença
	
	return DriverManager.getConnection("jdbc:mysql://localhost:3306/jf21","root","123456");
	
	
	} catch (SQLException e){
	
	throw new RuntimeException(e);
	
	}
	
	
	} //Fim do método getConnection

} //Fim da classe ConnectionFactory

