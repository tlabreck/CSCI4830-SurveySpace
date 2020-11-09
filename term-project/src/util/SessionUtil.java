package util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

public class SessionUtil {
    private static SessionFactory sessionFactory;
    
    /**
     * Initializes sessionFactory to the default configuration (hibernate.cfg.xml).
     */
    private static void buildSessionFactory() {
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().build();
        Metadata metadata = new MetadataSources(serviceRegistry).getMetadataBuilder().build();
        
        sessionFactory = metadata.getSessionFactoryBuilder().build();
    }
    
    /**
     * Lazily initializes sessionFactory and then returns the reference.
     * 
     * @return the SessionFactory for the database connection
     */
    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            buildSessionFactory();
        }
        return sessionFactory;
    }
}