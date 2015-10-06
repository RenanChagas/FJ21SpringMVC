package br.com.caelum.tarefas.hibernate;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class BuscaProdutos {
	
	public static void main(String args[]){
		
		Configuration config = new Configuration().configure();
		config.addAnnotatedClass(Produto.class);
		
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
				config.getProperties()).build();
		
		SessionFactory factory = config.buildSessionFactory(serviceRegistry);
		
		Session session = factory.openSession();
		
		Query query = session.createQuery("Select p from Produto as p where p.preco > :paramPreco");

		query.setParameter("paramPreco", 10.0);
		List<Produto> lista = query.list();
		
		for (Produto p : lista) {
            System.out.println(p.getNome());
		}
		
		session.close();
		
	}

}
