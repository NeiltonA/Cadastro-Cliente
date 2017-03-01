package br.com.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.entidade.Cliente;



public class ClienteDao {
	long vazio;

	public void saveOrUpdate(Cliente cliente) throws Exception {
		try {
			EntityManager em = br.com.util.HibernateUtil.geteEntityManagerFactory().createEntityManager();

			if (em.getTransaction().isActive() == false) {
				em.getTransaction().begin();
			}
			if (cliente.getId() == vazio)

				em.persist(cliente);

			else

				em.merge(cliente);

			em.getTransaction().commit();

			em.close();

		} finally {

		}

	}

	public void delete(Cliente cliente) {
		EntityManager em = br.com.util.HibernateUtil.geteEntityManagerFactory().createEntityManager();
		try {
			em.getTransaction().begin();
			Cliente al = em.find(Cliente.class, cliente.getId());
			em.remove(al);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			em.close();
		}
	}

	public List<Cliente> list() {
		List<Cliente> result = null;
		try {
			EntityManager em = br.com.util.HibernateUtil.geteEntityManagerFactory().createEntityManager();
			Query query = em.createQuery("FROM Cliente");
			result = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

}
