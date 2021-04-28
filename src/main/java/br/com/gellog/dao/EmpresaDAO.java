package br.com.gellog.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.gellog.model.Empresa;

public class EmpresaDAO {
	private Empresa result;
	private List<Empresa> resultList;
	private EntityManager emf = new JpaEMF().getEntityManager();

	public Empresa lastResult() {
		try {
			emf = new JpaEMF().getEntityManager();

			TypedQuery<Empresa> query = emf.createQuery("SELECT o FROM Empresa o ORDER BY o.id DESC", Empresa.class);
			query.setMaxResults(1);
			result = query.getSingleResult();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	public void adiconaEmpresa(Empresa empresa) {
		try {
			emf = new JpaEMF().getEntityManager();
			emf.getTransaction().begin();
			emf.persist(empresa);
			emf.getTransaction().commit();
			emf.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void atualizaEmpresa(Empresa empresa) {
		try {
			emf = new JpaEMF().getEntityManager();
			emf.getTransaction().begin();
			emf.merge(empresa);
			emf.getTransaction().commit();
			emf.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<Empresa> comparaNome(String razaoSocial) {
		try {
			emf = new JpaEMF().getEntityManager();
			TypedQuery<Empresa> query = emf.createQuery("SELECT o FROM Empresa o WHERE o.nome LIKE (:pNome)",
					Empresa.class);	
			resultList = query.setParameter("pNome","%" + razaoSocial + "%").getResultList();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultList;
	}
	
	public Empresa procuraEmpresaId(int id) {
		try {
			result = new Empresa();
			emf = new JpaEMF().getEntityManager();
			result = emf.find(result.getClass(), id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	public List<Empresa> comparaCNPJ(String cNPJ) {
		try {
			emf = new JpaEMF().getEntityManager();
			TypedQuery<Empresa> query = emf.createQuery("SELECT o FROM Empresa o WHERE o.cnpj LIKE (:pCNPJ)",
					Empresa.class);
			resultList = query.setParameter("pCNPJ", "%" + cNPJ + "%").getResultList();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultList;
	}
}
