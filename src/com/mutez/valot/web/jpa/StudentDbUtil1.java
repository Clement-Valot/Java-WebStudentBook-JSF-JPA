package com.mutez.valot.web.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.omg.CORBA.SystemException;


@ManagedBean
@ApplicationScoped
public class StudentDbUtil1 {
	
	private static final String PERSIS_NAME = "JSFJPA";
	private static EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSIS_NAME);
	static EntityManager em = factory.createEntityManager();
	
	public StudentDbUtil1() {
		
	}
	
	public static List<Student1> getStudents() throws Exception {
		List<Student1> students= new ArrayList<Student1>();
		students = em.createQuery("SELECT a FROM Student1 a", Student1.class).getResultList();
		return students;
	}
	
	public static void addStudent(Student1 s){
		try{
			em.getTransaction().begin();
			em.persist(s);
			em.getTransaction().commit();
		}
		catch (SystemException e){
		e.printStackTrace();
		}
	}
	
	public static Student1 fetchStudent(int id) { 
		Student1 s = em.find(Student1.class, id);
		return s;
	}
	
	public static void updateStudent(Student1 student) { 
		Student1 updateStudent = em.find(Student1.class, student.getId());
		try{
			em.getTransaction().begin();
			updateStudent.setFirst_Name(student.getFirst_Name());
			updateStudent.setLast_Name(student.getLast_Name());
			updateStudent.setEmail(student.getEmail());
			em.getTransaction().commit();
		}
		catch (SystemException e){
		e.printStackTrace();
		}
	}
	
	public static void deleteStudent(int id) {
		Student1 s = em.find(Student1.class, id);
		try{
			em.getTransaction().begin();
			em.remove(s);
			em.getTransaction().commit();
		}
		catch (SystemException e){
		e.printStackTrace();
		}
	}

}
