package br.com.caelum.tarefas.hibernate;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class GeraTabelas2 {
	
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("k21");
		factory.close(); 
	}

}
