package br.com.gellog.dao;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.gellog.model.TabelaFreteModel;

public class TabelaFreteQueries {
	private TabelaFreteModel result;
	private EntityManager emf = new JpaEMF().getEntityManager();
	
	public TabelaFreteModel lastResult() {
		try {
			emf = new JpaEMF().getEntityManager();
		
			TypedQuery<TabelaFreteModel> query = emf.createQuery("SELECT o FROM TabelaFreteModel o order by o.id desc", TabelaFreteModel.class);
			query.setMaxResults(1);
			result =  query.getSingleResult();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
}
