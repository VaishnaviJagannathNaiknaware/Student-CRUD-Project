package com.CrudApplication.StudentInformation.dao;


import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.CrudApplication.StudentInformation.entity.Student;

@Repository
public class Studentdao {
    @Autowired
	SessionFactory sf;
    
	public String insertRecord(Student s) {
		Session session=sf.openSession();
		Transaction tr=session.beginTransaction();
		session.save(s);
		tr.commit();
		return "Data Inserted Successfully";	
	}
	
	public String updateRecord(Student s) {
		Session session=sf.openSession();
		Transaction tr=session.beginTransaction();
		session.update(s);
		tr.commit();
		return "Data Updated Successfully";	
	}

	public List<Student> fetchRecord()
	{
		Session session=sf.openSession();
		Criteria criteria=session.createCriteria(Student.class);
        List<Student> list  = criteria.list();
		return list;
	}

	public String deleteRecord(int id) {
		Session session=sf.openSession();
		Transaction tr=session.beginTransaction();
		Student s=session.get(Student.class, id);
		session.delete(s);
		tr.commit();
		session.close();
		return "Data Deleted Successfully";
	}
}
