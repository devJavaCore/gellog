package br.com.gellog.dao;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.gellog.model.Empresa;


public class EmpresaDAO {
	private Empresa result;
	private EntityManager emf = new JpaEMF().getEntityManager();
	
	public Empresa lastResult() {
		try {
			emf = new JpaEMF().getEntityManager();
		
			TypedQuery<Empresa> query = emf.createQuery("SELECT o FROM Empresa o order by o.id desc", Empresa.class);
			query.setMaxResults(1);
			result =  query.getSingleResult();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
}
