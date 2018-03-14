package examples.pubhub.utilities;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import examples.pubhub.dao.BookDAO;
import examples.pubhub.dao.BookDAOImpl;

public class HibernateUtil {

	private static final SessionFactory sessionFactory;

	static {
		try {
			sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		} catch (Throwable ex) {
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static Session openSession() {
		return sessionFactory.openSession();
	}

	public static BookDAO getBookDAO() {
		// TODO Auto-generated method stub
		return new BookDAOImpl();
	}

}