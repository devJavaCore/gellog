package br.com.gellog.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.gellog.model.Login;

public class LoginDAO {
	private List<Login> listResults;
	private EntityManager emf = new JpaEMF().getEntityManager();
	
	public List<Login>  resultList() {
		try {
			emf = new JpaEMF().getEntityManager();
		
			TypedQuery<Login> query = emf.createQuery("SELECT o FROM Login o", Login.class);
			
			listResults = (List<Login>) query.getResultList();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listResults;
	}
}
