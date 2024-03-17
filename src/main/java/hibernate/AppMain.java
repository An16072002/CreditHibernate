package hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import hibernate.HibernateUtil;
import jakarta.persistence.Transient;
import org.hibernate.Transaction;


public class AppMain {
	@SuppressWarnings("unchecked")
	public static List<User> getALLStudent(){
		Transaction transaction = null;
		List <User> listOfStudent = null;
		List<User> users = null;
		try(Session session = 	HibernateUtil.getSessionFactory().openSession()){
			transaction =session.beginTransaction();
            
            listOfStudent = session.createQuery("from User").getResultList();
            String hql = "FROM User";
            users = session.createQuery(hql, User.class).list();
            transaction.commit();
		}catch(Exception e) {
			if (transaction != null && transaction.isActive()) {
		        transaction.rollback();
		    }
			e.printStackTrace();
		}
		return users;
		
				
	}
	
	
	
	public static User getStudent(int id){
		org.hibernate.Transaction transaction = null;
		User user = null;
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
            transaction =session.beginTransaction();
            
            String hql = "FROM User AS u WHERE u.id = :id";
            user = session.createQuery(hql, User.class).setParameter("id", 1L).uniqueResult();
            transaction.commit();
 
		}catch(Exception e) {
			if(transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return user;
		
				
	}
	public static void main(String[] args) {
		List<User> studentList = AppMain.getALLStudent();
		studentList.forEach(std->System.out.println(std));
		
		User user = new User();
		
		user = AppMain.getStudent(1);
		System.out.println(user);
	}
}
