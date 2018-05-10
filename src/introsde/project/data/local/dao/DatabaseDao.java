package introsde.project.data.local.dao;

import javax.persistence.*;

public enum DatabaseDao {
    instance;
    private EntityManagerFactory emf;

    private DatabaseDao() {
        if (emf!=null) {
        	
            emf.close();
        }
        emf = Persistence.createEntityManagerFactory("introsde_project_data");

    }

    public EntityManager createEntityManager() {
        try {
            return emf.createEntityManager();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;    
    }

    public void closeConnections(EntityManager em) {
        em.close();
    }

    public EntityTransaction getTransaction(EntityManager em) {
        return em.getTransaction();
    }

    public EntityManagerFactory getEntityManagerFactory() {
        return emf;
    }  
}
