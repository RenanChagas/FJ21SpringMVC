package br.com.caelum.tarefas.hibernate;

import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class GeraTabelas {
	
	public static void main(String args[]){
		Configuration config = new Configuration().configure();
		config.addAnnotatedClass(Produto.class);
		
		SchemaExport se = new SchemaExport(config);
		se.create(true, true);
	}

}
