package poly.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import poly.model.User_TB;
import poly.model.Video_TB;
import poly.serve.JPAUtils;

public class UserDAO extends AbstractEntiryDAO<User_TB> {

	public UserDAO() {
		super(User_TB.class);
	}
	
	
	public List<User_TB> findByKeyWord(String keyword){
		EntityManager em = JPAUtils.getEntityManager();
		List<User_TB> list = null;
		try {
			em.getTransaction().begin();
			TypedQuery<User_TB> query = em.createNamedQuery("User.findByKeyWord", User_TB.class);
			query.setParameter("keyword", "%"+keyword+"%");
			list = query.getResultList();
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		}
		return list;
	}

	
	public User_TB findOne(String username, String password) {
		EntityManager em = JPAUtils.getEntityManager();
		User_TB user = null;
		try {
			em.getTransaction().begin();
			TypedQuery<User_TB> query = em.createNamedQuery("User.findOne", User_TB.class);
			query.setParameter("us", username);
			query.setParameter("pw", password);
			user = query.getSingleResult();
			
			System.out.println("Successfully!");
			em.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Unsuccess!");
			e.printStackTrace();
	        em.getTransaction().rollback();
			// TODO: handle exception
		}
		return user;
	}
}
