package examples.pubhub.service;

import org.hibernate.Session;
import org.hibernate.Transaction;

import examples.pubhub.model.Book;
import examples.pubhub.utilities.HibernateUtil;

public class PublishBookService {

	public boolean addBook(Book book) {
		Session session = HibernateUtil.openSession();
		// if(isUserExists(user)) return false;

		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			session.saveOrUpdate(book);
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return true;
	}

}