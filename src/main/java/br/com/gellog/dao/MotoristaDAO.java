package br.com.gellog.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.gellog.model.Motorista;
import br.com.gellog.model.Pessoa;

public class MotoristaDAO {
	private Pessoa resultPessoa;
	private Motorista result;
	private List<Motorista> resultList;
	private List<Pessoa> resultListPessoa;
	private EntityManager emf = new JpaEMF().getEntityManager();

	public Pessoa motoristaLastResult() {
		try {
			emf = new JpaEMF().getEntityManager();

			TypedQuery<Pessoa> query = emf.createQuery("SELECT o FROM Pessoa o ORDER BY o.id DESC", Pessoa.class);
			query.setMaxResults(1);
			resultPessoa = query.getSingleResult();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultPessoa;
	}



	public List<Pessoa> comparaNome(String nome) {
		try {
			emf = new JpaEMF().getEntityManager();
			TypedQuery<Pessoa> query = emf.createQuery("SELECT o FROM Pessoa o WHERE o.nome LIKE (:pNome)",
					Pessoa.class);	
			resultListPessoa = query.setParameter("pNome","%" + nome + "%").getResultList();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultListPessoa;
	}
	
	public Motorista procuraMotoristaid(int id) {
		try {
			result = new Motorista();
			emf = new JpaEMF().getEntityManager();
			result = emf.find(result.getClass(), id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	public List<Motorista> comparaCPF(String cPF) {
		try {
			emf = new JpaEMF().getEntityManager();
			TypedQuery<Motorista> query = emf.createQuery("SELECT o FROM Pessoa o WHERE o.cpf LIKE (:ppf)",
					Motorista.class);
			resultList = query.setParameter("pCNPJ", "%" + cPF + "%").getResultList();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultList;
	}
	
	public void updateMotorista(Motorista motorista) {
		try {
			emf = new JpaEMF().getEntityManager();
			emf.getTransaction().begin();
			Pessoa pessoa = emf.find(Pessoa.class, motorista.getId());
			
			pessoa.setNome(motorista.getNome());
			pessoa.setCpf(motorista.getCpf());
			pessoa.setEmail(motorista.getEmail());
			pessoa.setTelefone(motorista.getTelefone());
			pessoa.setTelefone2(motorista.getTelefone2());
			pessoa.setAtivo(motorista.getAtivo());
			pessoa.setLogin(motorista.getLogin());
			pessoa.setDate(motorista.getDate());
			
			emf.merge(pessoa);
			emf.getTransaction().commit();
			emf.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
