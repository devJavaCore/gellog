package br.com.gellog.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import br.com.gellog.model.Veiculo;

public class VeiculoDAO {
	private Veiculo result;
	private List<Veiculo> resultList;
	private EntityManager emf = new JpaEMF().getEntityManager();
	
	public Veiculo lastResult() {
		try {
			emf = new JpaEMF().getEntityManager();
		
			TypedQuery<Veiculo> query = emf.createQuery("SELECT o FROM Veiculo o order by o.id desc", Veiculo.class);
			query.setMaxResults(1);
			result =  query.getSingleResult();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	
	public List<Veiculo> resultList() {
		try {
			emf = new JpaEMF().getEntityManager();
		
			TypedQuery<Veiculo> query = emf.createQuery("SELECT o FROM Veiculo o", Veiculo.class);
			resultList =  query.getResultList();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultList;
	}
	
	public List<Veiculo> veiculoPorMotoristaId(int id) {
		try {
			emf = new JpaEMF().getEntityManager();
		
			TypedQuery<Veiculo> query = emf.createQuery("SELECT o FROM Veiculo o WHERE MOTORISTA_ID = (:pId)", Veiculo.class);
			resultList =  query.setParameter("pId", id).getResultList();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultList;
	}
	
	public List<Veiculo> comparaTipo(String tipo) {
		try {
			emf = new JpaEMF().getEntityManager();
			TypedQuery<Veiculo> query = emf.createQuery("SELECT o FROM Veiculo o WHERE o.tipo LIKE (:pTipo)",
					Veiculo.class);	
			resultList = query.setParameter("pTipo","%" + tipo + "%").getResultList();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultList;
	}
	
	@Transactional
	public void deleteById(Veiculo veiculo, int id) {
		try {
			emf = new JpaEMF().getEntityManager();
			veiculo = emf.find(veiculo.getClass(), id);
			emf.getTransaction().begin();
			emf.remove(veiculo);
			emf.getTransaction().commit();
			emf.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void adiconaVeiculo(Veiculo veiculo) {
		try {
			emf = new JpaEMF().getEntityManager();
			emf.getTransaction().begin();
			emf.persist(veiculo);
			emf.getTransaction().commit();
			emf.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}