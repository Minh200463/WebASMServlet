package poly.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;

import poly.model.Report_TB;
import poly.model.Video_TB;
import poly.serve.JPAUtils;

public class VideoDAO extends AbstractEntiryDAO<Video_TB>{

	public VideoDAO() {
		super(Video_TB.class);
	}

	
	public List<Video_TB> findByKeyWord(String keyword){
		EntityManager em = JPAUtils.getEntityManager();
		List<Video_TB> list = null;
		try {
			em.getTransaction().begin();
			TypedQuery<Video_TB> query = em.createNamedQuery("Video.findByKeyWord", Video_TB.class);
			query.setParameter("keyword", "%"+keyword+"%");
			list = query.getResultList();
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		}
		return list;
	}
	
	
	
	
	public List<Video_TB> showTop4Video(){
		EntityManager em = JPAUtils.getEntityManager();
		List<Video_TB> list = null;
		try {
			em.getTransaction().begin();
			Query query = em.createNamedQuery("Video.random4");
			list = query.getResultList();
			em.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Unsuccess!");
			e.printStackTrace();
	        em.getTransaction().rollback();
		}
		return list;
	}

	public List<Video_TB> showTop6Video(){
		EntityManager em = JPAUtils.getEntityManager();
		List<Video_TB> list = null;
		try {
			em.getTransaction().begin();
			Query query = em.createNamedQuery("Video.random6");
			list = query.getResultList();
			em.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Unsuccess!");
			e.printStackTrace();
	        em.getTransaction().rollback();
		}
		return list;
	}
	
	
	public List<Video_TB> showVideoDesc(){
		EntityManager em = JPAUtils.getEntityManager();
		List<Video_TB> list = null;
		try {
			em.getTransaction().begin();
			Query query = em.createNamedQuery("Video.videodesc");
			list = query.getResultList();
			em.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Unsuccess!");
			e.printStackTrace();
	        em.getTransaction().rollback();
		}
		return list;
	}
	
	public List<Video_TB> findByUser(int id) {
		EntityManager em = JPAUtils.getEntityManager();
		List<Video_TB> list = null;
		try {
			em.getTransaction().begin();
			TypedQuery<Video_TB> query = em.createNamedQuery("Video.findByUser", Video_TB.class);
			query.setParameter("id", id);
			list = query.getResultList();
			
			System.out.println("Successfully!");
			em.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Unsuccess!");
			e.printStackTrace();
	        em.getTransaction().rollback();
			// TODO: handle exception
		}
		return list;
	}
	
	public List<Report_TB> showByYear(int year){
		EntityManager em = JPAUtils.getEntityManager();
		List<Report_TB> list = null;
		try {
			em.getTransaction().begin();
			StoredProcedureQuery query = em.createNamedStoredProcedureQuery("Report.favoriteByYear");
		
			query.setParameter("Year", year);
			list = query.getResultList();
			em.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Unsuccess!");
			e.printStackTrace();
	        em.getTransaction().rollback();
		}
		return list;
	}
	
	
	
	public List<Video_TB> showPage(int offset, int limit){
		EntityManager em = JPAUtils.getEntityManager();
		List<Video_TB> list = null;
		try {
			em.getTransaction().begin();
			Query query = em.createNamedQuery("Video.findpage");
			query.setParameter("offset", offset);
			query.setParameter("limit", limit);
			list = query.getResultList();
			em.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Unsuccess!");
			e.printStackTrace();
	        em.getTransaction().rollback();
		}
		return list;
	}
	
}
