package br.com.hudson.transporte.repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import br.com.hudson.transporte.domain.Cliente;

@Repository
public class ClienteCustomRepository {
	
	private final EntityManager em;

	public ClienteCustomRepository(EntityManager em) {
		this.em = em;
	}

	public List<Cliente> find(Long id, String nome){
		
		String query = "select c from Cliente as c ";
		String condicao = "where";
		
		if (id != null) {
			query += condicao + " c.id like :id ";
			condicao = " and ";
		}
		
		if (nome != null) {
			query += condicao + " c.nome like :nome ";
		}
		
		var q = em.createQuery(query, Cliente.class);
		
		if (id != null) {
			q.setParameter("id", id);
		}
		
		if (nome != null) {
			q.setParameter("nome", nome);
		}
		
		return q.getResultList();
	}
	
}
