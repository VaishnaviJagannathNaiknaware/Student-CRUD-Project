package com.CrudApplication.StudentInformation.Services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CrudApplication.StudentInformation.dao.Studentdao;
import com.CrudApplication.StudentInformation.entity.Student;


@Service
public class StudentService {

	@Autowired
	Studentdao sd;
	
	public String insertRecord(Student s) {
		
		String msg = sd.insertRecord(s);
		return msg;
	}
	
	public String updateRecord(Student s) {
		String msg = sd.updateRecord(s);
		return msg;
	}

	public List<Student> fetchRecord()
	{
		List<Student> list = sd.fetchRecord();
		return list;
	}

	public String deleteRecord(int id) {
		String msg = sd.deleteRecord(id);
		return msg;
	}

	
}