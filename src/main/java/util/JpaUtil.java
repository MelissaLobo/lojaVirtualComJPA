package util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtil {

	private static final String PERSISTENCE_UNIT = "lojaVirtualComJPA";
	private static EntityManagerFactory entityManagerFactory;
	
	private JpaUtil(){
	}

	public static EntityManager getEntityManager(){
		if (entityManagerFactory == null) {
			entityManagerFactory = Persistence
					.createEntityManagerFactory(PERSISTENCE_UNIT);
		}
		return entityManagerFactory.createEntityManager();
	}
}
