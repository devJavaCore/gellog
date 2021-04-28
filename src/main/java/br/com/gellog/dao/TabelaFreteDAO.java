package br.com.gellog.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.gellog.model.TabelaFreteModel;

public class TabelaFreteDAO {
	private List<TabelaFreteModel> resultList;
	private TabelaFreteModel result;
	private EntityManager emf = new JpaEMF().getEntityManager();
	
	public List<TabelaFreteModel> lastResultEmpresa() {
		try {
			emf = new JpaEMF().getEntityManager();
		
			TypedQuery<TabelaFreteModel> query = emf.createQuery("SELECT o FROM TabelaFreteModel o WHERE o.tabelaPadrao = 0 ORDER BY o.id DESC", TabelaFreteModel.class);
			query.setMaxResults(1);
			resultList =  query.getResultList();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultList;
	}
	
	public TabelaFreteModel procuraTabelaEmpresa(int id) {
		try {
			emf = new JpaEMF().getEntityManager();
		
			TypedQuery<TabelaFreteModel> query = emf.createQuery("SELECT o FROM TabelaFreteModel o WHERE o.tabelaPadrao = 0 AND EMPRESA_ID = (:pId) ORDER BY o.id DESC", TabelaFreteModel.class);
			query.setMaxResults(1);
			result =  query.setParameter("pId", id).getSingleResult();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	public List<TabelaFreteModel> tabelaPadrao() {
		try {
			emf = new JpaEMF().getEntityManager();
		
			TypedQuery<TabelaFreteModel> query = emf.createQuery("SELECT o FROM TabelaFreteModel o WHERE o.tabelaPadrao = 1 ORDER BY o.id DESC", TabelaFreteModel.class);
			query.setMaxResults(1);
			resultList =  query.getResultList();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultList;
	}
	
	public void adiconaTabelaFrete(TabelaFreteModel tabela) {
		try {
			emf = new JpaEMF().getEntityManager();
			emf.getTransaction().begin();
			emf.persist(tabela);
			emf.getTransaction().commit();
			emf.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
