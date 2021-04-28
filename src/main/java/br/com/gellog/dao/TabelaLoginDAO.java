package br.com.gellog.dao;

import javax.persistence.EntityManager;

import br.com.gellog.model.TabelaLogin;

public class TabelaLoginDAO {
	
	private EntityManager emf = new JpaEMF().getEntityManager();
	
	public void adiconaTabelaLogin(TabelaLogin tabelaLogin) {
		try {
			emf = new JpaEMF().getEntityManager();
			emf.getTransaction().begin();
			emf.persist(tabelaLogin);
			emf.getTransaction().commit();
			emf.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
