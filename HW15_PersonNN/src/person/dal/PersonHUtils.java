package person.dal;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

//@SuppressWarnings("deprecation")
public class PersonHUtils 
{
	static final SessionFactory sessionFactory = buildSessionFactory();

	static SessionFactory buildSessionFactory()
	{
		try
		{
			return new AnnotationConfiguration().configure().buildSessionFactory();
		}
		catch (Throwable ex) { 
			// Make sure you log the exception, as it might be swallowed 
			System.err.println("Initial SessionFactory creation failed." + ex); 
			throw new ExceptionInInitializerError(ex); 
		} 
	} 

	public static SessionFactory getSessionFactory() { 
		return sessionFactory; 
	} 

	public static void shutdown() 
	{ 
		// Close caches and connection pools 
		getSessionFactory().close(); 
	} 
}