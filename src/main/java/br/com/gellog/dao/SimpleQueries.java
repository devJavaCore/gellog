package br.com.gellog.dao;

import javax.persistence.EntityManager;

public class SimpleQueries {
	// private TabelaFrete tabela;
	// private List<TabelaFrete> listTabela;
	private EntityManager emf = new JpaEMF().getEntityManager();
	private Object obj;

	public void simpleInsert(Object obj) {
		try {
			emf = new JpaEMF().getEntityManager();
			emf.getTransaction().begin();
			emf.merge(obj);
			emf.getTransaction().commit();
			emf.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Object idSearch(Object objClass, int id) {
		try {
			emf = new JpaEMF().getEntityManager();
			obj = emf.find(objClass.getClass(), id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return obj;
	}

	public Object updateObject(Object objClass, int id) {
		try {
			emf = new JpaEMF().getEntityManager();
			emf.getTransaction().begin();
			obj = emf.find(objClass.getClass(), id);
			obj = objClass;
			emf.merge(obj);
			emf.getTransaction().commit();
			emf.close();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return obj;
	}
}
