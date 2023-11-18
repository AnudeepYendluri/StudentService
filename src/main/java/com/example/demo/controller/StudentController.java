package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.model.Book;
import com.example.demo.model.Student;
import com.example.demo.service.StudentService;

@RestController
@RequestMapping("/studentService")
public class StudentController {

	@Autowired
	private StudentService studentService;
	@Autowired
	private RestTemplate restTemplate;
	
	@PostMapping("/addStudent")
	public String registerStudent(@RequestBody Student student) {
		String email = student.getStudentEmail();
		String response = restTemplate.getForObject("http://emailservice/emailService/sendOtp/"+ email,String.class);
		System.out.println(response);
		String result = studentService.addStudent(student);
		return result;
	}
	
	@GetMapping("/getAllBooks")
	public List<Book> getAllBooks() {
		Book[] books =restTemplate.getForObject("http://bookservice/bookService/getAll",Book[].class);
		List al = Arrays.asList(books);
		return al;
	}
	
	@DeleteMapping("/deleteStudentById/{id}")
	public String removeStudentById(@PathVariable int id) {
		String result = studentService.deleteStudentById(id);
		return result;
	}
	
	
	
}
