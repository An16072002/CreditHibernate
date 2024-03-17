package vnua.fita.credit;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import hibernate.HibernateUtil;
import jakarta.persistence.Transient;
import org.hibernate.Transaction;


public class StudentDAO {
	@SuppressWarnings("unchecked")
	public static List<Student> getALLStudent(){
		Transaction transaction = null;
		List <Student> listOfStudent = null;
		try(Session session = CreditHiberateUtil.getSessionFactory().openSession()){
			transaction =session.beginTransaction();
            
            listOfStudent = session.createQuery("from Student").getResultList();
            transaction.commit();
		}catch(Exception e) {
			if (transaction != null && transaction.isActive()) {
		        transaction.rollback();
		    }
			e.printStackTrace();
		}
		return listOfStudent;
		
				
	}
	
	public static Student getStudent(int id){
		org.hibernate.Transaction transaction = null;
		Student student = null;
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
            transaction =session.beginTransaction();
            
            student = session.get(Student.class, id);
            transaction.commit();
 
		}catch(Exception e) {
			if(transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return student;
		
				
	}
	public static void main(String[] args) {
		List<Student> studentList = StudentDAO.getALLStudent();
		studentList.forEach(std->System.out.println(std));
	}
}
