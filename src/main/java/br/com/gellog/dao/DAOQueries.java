package br.com.gellog.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import br.com.gellog.model.People;

public class DAOQueries {
	//private TabelaFrete tabela;
	//private List<TabelaFrete> listTabela;
	private EntityManager emf = new JpaEMF().getEntityManager();
	private Object obj;
	
	public void simpleInsert(Object obj) {
		try {
			emf = new JpaEMF().getEntityManager();
			emf.getTransaction().begin();
			emf.persist(obj);
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
	public Object listObj(Object objClass, String restriction, Object field) {
	
	 CriteriaBuilder cb = emf.getCriteriaBuilder();

	  CriteriaQuery<Object> q = cb.createQuery(Object.class);
	  Root<Object> c = q.from(Object.class);
	  ParameterExpression<Integer> p = cb.parameter(Integer.class);
	  q.select(c).where(cb.gt(c.get("population"), p));
	}
}
