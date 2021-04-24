package br.com.gellog.dao;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.gellog.model.Pessoa;

public class PessoaDAO {
	private Pessoa result;
	private EntityManager emf = new JpaEMF().getEntityManager();
	
	public Pessoa lastResult() {
		try {
			emf = new JpaEMF().getEntityManager();
		
			TypedQuery<Pessoa> query = emf.createQuery("SELECT o FROM Pessoa o order by o.id desc", Pessoa.class);
			query.setMaxResults(1);
			result =  query.getSingleResult();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
}