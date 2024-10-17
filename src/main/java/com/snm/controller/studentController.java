package com.snm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.snm.entity.student;
import com.snm.service.studentService;


@RestController
public class studentController {

	@Autowired
	private studentService stuService;

	@PostMapping("/")
	public ResponseEntity<student> createStudent(@RequestBody student stu) {

	student createStu = stuService.createStudent(stu);
		return new ResponseEntity<>(createStu,HttpStatus.CREATED);

	}
	
	@GetMapping("/{id}")
	public ResponseEntity<student> getStudent(@PathVariable int id) {
		
		student getById = stuService.getStudent(id);
		return new ResponseEntity<>(getById,HttpStatus.OK);
	}
	
	@GetMapping("/getAll")
	public List<student>getAll(){
		return stuService.getAll();
		
	}

	
	@PutMapping("/{id}")
	public student updateById(@RequestBody student stu,@PathVariable Integer id) {
		
		student updateStudent = stuService.updateStudent(stu, id);
		return updateStudent;
		
	}
	
	@DeleteMapping("/{id}")
	public void deleteStu(@PathVariable Integer id) {
		
		stuService.deleteStu(id);
	}
	
	
	 @GetMapping("/api")
	    public Page<student> getAllUsers(Pageable pageable) {
	        return stuService.getStu(pageable);
	    }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
