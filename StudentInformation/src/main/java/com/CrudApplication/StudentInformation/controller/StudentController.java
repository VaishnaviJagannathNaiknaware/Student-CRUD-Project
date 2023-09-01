package com.CrudApplication.StudentInformation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.CrudApplication.StudentInformation.Services.StudentService;
import com.CrudApplication.StudentInformation.entity.Student;


@RestController
public class StudentController {

	@Autowired
	StudentService ss;
	
	@PostMapping("/insert")
	public String insertStudentData(@RequestBody Student s)
	{
		String msg = ss.insertRecord(s);
		return msg;
	}
	
	@PutMapping("/update")
	public String updateStudentData(@RequestBody Student s)
	{
		String msg = ss.updateRecord(s);
		return msg;
	}
	
	@GetMapping("/fetch")
	public List<Student> fetchRecord()
	{
		List<Student> list = ss.fetchRecord();
		return list;	
	}
	@DeleteMapping("/delete/{id}")
	public String deleteRecord(@PathVariable int id)
	{
		String msg = ss.deleteRecord(id);
		return msg;
	}
	
	
}