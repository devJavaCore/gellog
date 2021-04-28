package br.com.gellog.dao;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.gellog.model.Endereco;

public class EnderecoDAO {
	private Endereco result;
	private EntityManager emf = new JpaEMF().getEntityManager();
	
	public Endereco lastResult() {
		try {
			emf = new JpaEMF().getEntityManager();
		
			TypedQuery<Endereco> query = emf.createQuery("SELECT o FROM Endereco o order by o.id desc", Endereco.class);
			query.setMaxResults(1);
			result =  query.getSingleResult();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	public void adicionaEndereco(Endereco endereco ) {
		try {
			emf = new JpaEMF().getEntityManager();
			emf.getTransaction().begin();
			emf.persist(endereco);
			emf.getTransaction().commit();
			emf.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}