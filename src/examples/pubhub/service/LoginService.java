package examples.pubhub.service;


import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import examples.pubhub.model.User;
import examples.pubhub.utilities.HibernateUtil;
 
@SuppressWarnings("deprecation")
public class LoginService {
 
    public boolean authenticateUser(String userName, String password) {
        User user = getUserByUserName(userName);         
        if(user!=null && user.getUserName().equals(userName) && user.getPassword().equals(password)){
            return true;
        }else{
            return false;
        }
    }
 
    
	@SuppressWarnings("unchecked")
	public User getUserByUserName(String userName) {
        Session session = HibernateUtil.openSession();
        Transaction tx = null;
        User user = null;
        try {
            tx = session.getTransaction();
            tx.begin();
           
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
     
   
	@SuppressWarnings("unchecked")
	public List<User> getListOfUsers(){
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
}