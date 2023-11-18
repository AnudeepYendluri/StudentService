package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;

@Service 
public class StudentService {

	@Autowired
	private StudentRepository studentRepo;
	
	public String addStudent(Student student) {	
		Student stu = studentRepo.save(student);
		if(stu != null) {
			return "Registration was succesfully";
		}
		return "Something went wrong";
	}
	
	public String deleteStudentById(int id) {
		studentRepo.deleteById(id);
		return "Deleted succefully";
	}
	
	
	
	
	
}
