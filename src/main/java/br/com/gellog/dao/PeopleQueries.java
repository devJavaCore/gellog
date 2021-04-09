package br.com.gellog.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.gellog.model.People;

public class PeopleQueries {
	private People people;
	private List<People> listPeople;
	private EntityManager emf = new JpaEMF().getEntityManager();
	public People idSearch(int id) {
		try {
			emf = new JpaEMF().getEntityManager();
			people = emf.find(People.class, id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return people;
	}

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

	public List<People> nameSearch(String name) {
		try {
			emf = new JpaEMF().getEntityManager();
			TypedQuery<People> query = emf.createQuery("SELECT o FROM People o WHERE o.name = (:pName)", People.class);
			listPeople = (List<People>) query.setParameter("pName", name).getResultList();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listPeople;
	}

	public List<People> tableSearch() {
		try {
			emf = new JpaEMF().getEntityManager();
			TypedQuery<People> query = emf.createQuery("SELECT o FROM People o", People.class);
			listPeople = (List<People>) query.getResultList();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listPeople;
	}
}
