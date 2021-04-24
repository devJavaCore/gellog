package br.com.gellog.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

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
}