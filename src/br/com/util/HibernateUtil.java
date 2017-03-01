package br.com.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HibernateUtil {

	private static EntityManagerFactory emf;

	private HibernateUtil() {
	}

	public static EntityManagerFactory geteEntityManagerFactory() {
		if (emf == null) {
			try {
				emf = Persistence
						.createEntityManagerFactory("exemplohibernate");
			} catch (Exception ex) {
				System.err.println("Initial SessionFactory creation failed."
						+ ex.getMessage());
				emf.close();
				
			}
		}
		return emf;
	
	}
}
