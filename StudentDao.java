package com.railworld.hibernate.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.railworld.hibernate.entity.*;
import com.railworld.hibernate.utility.HibernateUtil;

public class StudentDao {
	public void saveStudent(String name,String address ){
        Session session = HibernateUtil.getSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Student student=new Student();
      	  student.setName(name);
    	  student.setAddress(address);
    	              
            session.save(student);
            transaction.commit();
            System.out.println("Records inserted sucessessfully");
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
	 public List<Student> getStudents(){
	    	Session session = HibernateUtil.getSession(); 
	        Query query = session.createQuery("from Student");
	        List<Student> students =  query.list();
	        session.close();
	        return students;
	    }
	 public int updateStudent(Student s){
	        if(s.getId() <=0)  
	              return 0;  
	        	Session session = HibernateUtil.getSession(); 
	           Transaction tx = session.beginTransaction();
	           String hql = "update Student set name = :name, address=:address, where id = :id";
	           Query query = session.createQuery(hql);
	           query.setInteger("id",s.getId());
	           query.setString("name",s.getName());
	           query.setString("address",s.getAddress());
	           
	           int rowCount = query.executeUpdate();
	           
	           System.out.println("Rows affected: " + rowCount);
	           tx.commit();
	           session.close();
	           return rowCount;
	   }
	    public int deleteStudent(int id) {
	    	Session session = HibernateUtil.getSession(); 
	        Transaction tx = session.beginTransaction();
	        String hql = "delete from Student where id = :id";
	        Query query = session.createQuery(hql);
	        query.setInteger("id",id);
	        int rowCount = query.executeUpdate();
	        System.out.println("Rows affected: " + rowCount);
	        tx.commit();
	        session.close();
	        return rowCount;
	    
}
	    
	    
	    
	    
	    
	    
	    
}
