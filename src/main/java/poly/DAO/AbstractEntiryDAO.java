package poly.DAO;

import java.util.List;

import javax.persistence.EntityManager;

import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;

import poly.model.Video_TB;
import poly.serve.JPAUtils;

public abstract class AbstractEntiryDAO<T> {
	private Class<T> entityclass;
	
	
	
	public AbstractEntiryDAO(Class<T> entityclass) {
		super();
		this.entityclass = entityclass;
	}

	public void insert(T entity) {
		EntityManager em = JPAUtils.getEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			em.persist(entity);
			trans.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			trans.rollback();
			throw e;
		}
	}
	
	public void update(T entity) {
		EntityManager em = JPAUtils.getEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			em.merge(entity);
			trans.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			trans.rollback();
			throw e;
		}
	}
	
	public void delete(Object id) {
		EntityManager em = JPAUtils.getEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			T entity = em.find(entityclass, id);
			em.remove(entity);
			trans.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			trans.rollback();
			throw e;
		}
	}
	
	
	public T findByID(Object id) {
		EntityManager em = JPAUtils.getEntityManager();
		EntityTransaction trans = em.getTransaction();
		T entity = null;
		try {
			trans.begin();
			entity = em.find(entityclass, id);
			trans.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			trans.rollback();
			throw e;
		}
		return entity;
	}
	
	
	

	public List<T> findAll() {
		EntityManager em = JPAUtils.getEntityManager();
		CriteriaQuery cq = em.getCriteriaBuilder().createQuery();		
		try {
			em.getTransaction().begin();
			cq.select(cq.from(entityclass));
			em.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
			em.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		}
		return em.createQuery(cq).getResultList();
	}
	
}
