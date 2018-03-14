package examples.pubhub.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import examples.pubhub.model.User;
import examples.pubhub.utilities.HibernateUtil;

@SuppressWarnings("deprecation")
public class UserDAOImpl implements UserDAO {

	@SuppressWarnings({ "unchecked" })
	@Override
	public List<User> getListOfUsers() {
		List<User> list = new ArrayList<User>();
        Session session = HibernateUtil.openSession();
        Transaction tx = null;       
        try {
            tx = session.getTransaction();
            tx.begin();
            list = session.createQuery("from User").list();                       
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return list;
    
	}

	@Override
	public User getUserByUserName(String userName) {
		Session session = HibernateUtil.openSession();
        Transaction tx = null;
        User user = null;
        try {
            tx = session.getTransaction();
            tx.begin();
           
			@SuppressWarnings("unchecked")
			Query<User> query = session.createQuery("from User where userName='"+userName+"'");
            user = (User)query.uniqueResult();
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return user;
    }
     

	@Override
	public boolean register(User user) {
		Session session = HibernateUtil.openSession();
		 //if(isUserExists(user)) return false;	
		
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 session.saveOrUpdate(user);		
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

	@Override
	public boolean isUserExists(User user) {
		Session session = HibernateUtil.openSession();
		 boolean result = false;
		 Transaction tx = null;
		 try{
			 tx = session.getTransaction();
			 tx.begin();
			Query<?> query = session.createQuery("from User where userName='"+user.getUserName()+"'");
			 User u = (User)query.uniqueResult();
			 tx.commit();
			 if(u!=null) result = true;
		 }catch(Exception ex){
			 if(tx!=null){
				 tx.rollback();
			 }
		 }finally{
			 session.close();
		 }
		 return result;
	}

	@Override
	public boolean authenticateUser(String userName, String password) {
		User user = getUserByUserName(userName);         
        if(user!=null && user.getUserName().equals(userName) && user.getPassword().equals(password)){
            return true;
        }else{
            return false;
        }
	}

}
