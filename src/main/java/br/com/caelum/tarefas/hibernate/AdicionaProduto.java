package br.com.caelum.tarefas.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class AdicionaProduto {
	
	public static void main(String args[]){
		
		Produto produto = new Produto();
		
		produto.setDescricao("Teclado");
		produto.setNome("Apple");
		produto.setPreco(250);
		
		Configuration config = new Configuration().configure();
		config.addAnnotatedClass(Produto.class);
		
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
				config.getProperties()).build();
		
		SessionFactory factory = config.buildSessionFactory(serviceRegistry);
	    
	    Session session = factory.openSession();
	    
	    session.beginTransaction();
	    session.save(produto);
	    session.getTransaction().commit();
	    
	    System.out.println("Produto: " + produto.getId());
	    session.close();
		
		
	}

}
