package br.com.gellog.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import br.com.gellog.model.FuncionarioCliente;

public class FuncionarioClienteDAO {
	private FuncionarioCliente result;
	private List<FuncionarioCliente> resultList;
	private EntityManager emf = new JpaEMF().getEntityManager();
	
	public FuncionarioCliente lastResult() {
		try {
			emf = new JpaEMF().getEntityManager();
		
			TypedQuery<FuncionarioCliente> query = emf.createQuery("SELECT o FROM FuncionarioCliente o order by o.id desc", FuncionarioCliente.class);
			query.setMaxResults(1);
			result =  query.getSingleResult();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	
	public List<FuncionarioCliente> resultList() {
		try {
			emf = new JpaEMF().getEntityManager();
		
			TypedQuery<FuncionarioCliente> query = emf.createQuery("SELECT o FROM FuncionarioCliente o", FuncionarioCliente.class);
			resultList =  query.getResultList();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultList;
	}
	
	public List<FuncionarioCliente> funcionarioPorEmpresaId(int id) {
		try {
			emf = new JpaEMF().getEntityManager();
		
			TypedQuery<FuncionarioCliente> query = emf.createQuery("SELECT o FROM FuncionarioCliente o WHERE EMPRESA_ID = (:pId)", FuncionarioCliente.class);
			resultList =  query.setParameter("pId", id).getResultList();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultList;
	}
	
	@Transactional
	public void deleteById(FuncionarioCliente funcionario, int id) {
		try {
			emf = new JpaEMF().getEntityManager();
			funcionario = emf.find(funcionario.getClass(), id);
			emf.getTransaction().begin();
			emf.remove(funcionario);
			emf.getTransaction().commit();
			emf.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void adiconaFuncionario(FuncionarioCliente funcionario) {
		try {
			emf = new JpaEMF().getEntityManager();
			emf.getTransaction().begin();
			emf.persist(funcionario);
			emf.getTransaction().commit();
			emf.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}