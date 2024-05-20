package com.railworld.maven.hbdemo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.railworld.hibernate.dao.StudentDao;
import com.railworld.hibernate.entity.Student;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        SessionFactory factory=new Configuration().configure().buildSessionFactory();
        System.out.println(factory);
        System.out.println(factory.isClosed());
        
        Student student=new Student();
        StudentDao s=new StudentDao();
        
        
      /* student.setId(102);
        student.setName("Hobber");
        student.setAddress("Bihar");
        System.out.println(student);
        
        Session session =factory.openSession();
        Transaction tx= session.beginTransaction();
        session.save(student);
        tx.commit();
        session.close();*/
        
        
        
        /**#################################################################
		 * Call Add Student
		 *#################################################################*/
        s.saveStudent("Sameer", "uttarpradesh");
        
        
        /**#################################################################
		 * Call get Student
		 *#################################################################*/
		List<Student> st=s.getStudents();
		System.out.println(st.get(0));
		
		
		/**#################################################################
		 * Update Student
		 *#################################################################*/
		student.setName("murli");
		student.setAddress("South");
		student.setId(1);		
		System.out.println(s.updateStudent(student));
		
		/**#################################################################
		 * DeleteStudent
		 *#################################################################*/
		System.out.println(s.deleteStudent(2));
		


        
    }
}
