package br.com.gellog.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.gellog.model.Pessoa;

public class PeopleQueries {
	private Pessoa people;
	private List<Pessoa> listPeople;
	private EntityManager emf = new JpaEMF().getEntityManager();
	public Pessoa idSearch(int id) {
		try {
			emf = new JpaEMF().getEntityManager();
			people = emf.find(Pessoa.class, id);
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

	public List<Pessoa> nameSearch(String name) {
		try {
			emf = new JpaEMF().getEntityManager();
			TypedQuery<Pessoa> query = emf.createQuery("SELECT o FROM People o WHERE o.name = (:pName)", Pessoa.class);
			listPeople = (List<Pessoa>) query.setParameter("pName", name).getResultList();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listPeople;
	}

	public List<Pessoa> tableSearch() {
		try {
			emf = new JpaEMF().getEntityManager();
			TypedQuery<Pessoa> query = emf.createQuery("SELECT o FROM People o", Pessoa.class);
			listPeople = (List<Pessoa>) query.getResultList();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listPeople;
	}
}
