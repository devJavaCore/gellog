package br.com.gellog.dao;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.gellog.model.Login;

public class LoginDAO {
	private Login results;
	private EntityManager emf = new JpaEMF().getEntityManager();

	public Login loginResult(String user, String pass) {
		try {
			emf = new JpaEMF().getEntityManager();
			TypedQuery<Login> query = emf.createQuery(
					"SELECT o FROM Login o WHERE o.userName = (:pUser) AND o.password = (:pPass)", Login.class);
			results = query.setParameter("pUser", user).setParameter("pPass", pass).getSingleResult();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return results;
	}
}
