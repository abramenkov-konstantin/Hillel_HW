package person.dal;

import java.util.ArrayList;
import org.hibernate.Session;
import person.hibernate.utils.HibernateUtil;

public class PersonDAO_Hibernate implements PersonDAO 
{
	@Override
	public void create(Person p) 
	{
		Session session = null;
		try 
		{
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.save(p); //update
			session.getTransaction().commit();
		} 
		catch (Exception e) 
		{
		} 
		finally 
		{
			if (session != null && session.isOpen()) {session.close(); }
		}
	}

	@Override
	public ArrayList<Person> read() 
	{
		Session session = null;
		ArrayList<Person> ar = new ArrayList<Person>();
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			ar = (ArrayList<Person>) session.createCriteria(Person.class).list();
			//ar = (ArrayList<Person>) session.createQuery("from Person").list();
		} catch (Exception e) {
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return ar;
	}

	@Override
	public void update(Person p) 
	{
		Session session = null;
		try 
		{
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.update(p); //update
			session.getTransaction().commit();
		} 
		catch (Exception e) 
		{
		} 
		finally 
		{
			if (session != null && session.isOpen()) {session.close(); }
		}
	}

	@Override
	public void delete(Person p) 
	{
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.delete(p);
			session.getTransaction().commit();
		} catch (Exception e) {
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
	}
}