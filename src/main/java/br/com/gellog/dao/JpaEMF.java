package br.com.gellog.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaEMF {
    private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("gellog");
	
	public EntityManager getEntityManager() {
		return entityManagerFactory.createEntityManager();
	}
}
