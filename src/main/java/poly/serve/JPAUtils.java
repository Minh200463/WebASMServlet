package poly.serve;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtils {

	public static EntityManager entityManager;

	public static EntityManager getEntityManager() {
		if (entityManager == null) {
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("DATA_JAVA4");
			entityManager = factory.createEntityManager();
		}
		return entityManager;
	}

	public static void shutdown() {
		if (entityManager != null && entityManager.isOpen()) {
			entityManager.close();
		}
		entityManager = null;
	}
}
