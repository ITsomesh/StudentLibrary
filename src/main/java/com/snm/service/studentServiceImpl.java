package com.snm.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.snm.entity.student;
import com.snm.repository.studetnRepo;

@Service
public class studentServiceImpl  implements studentService{
	
	@Autowired
	private studetnRepo stuRepo;

	@Override
	public student createStudent(student stu) {
		return stuRepo.save(stu);
	}

	
	@Override
	public List<student> getAll() {
	
		List<student> allStu = stuRepo.findAll();
		List<student> list = allStu.stream().map(a->a).toList();
		return list;
	}

	@Override
	public student getStudent(Integer id) {
		if (id == null) {
	        throw new IllegalArgumentException("Student ID cannot be null");
	    }
		
		return stuRepo.findById(id).orElseThrow(()->new RuntimeException(""+id));
	}


	@Override
	public student updateStudent(student stu, Integer id) {
		student updateStu = stuRepo.findById(id).orElseThrow(()->new RuntimeException("not foud by Id "+ id));
		
		
		updateStu.setName(stu.getName());
		updateStu.setAge(stu.getAge());
		updateStu.setCity(stu.getCity());
		
		return stuRepo.save(updateStu);
	}


	@Override
	public void deleteStu(Integer id) {
		student stu = stuRepo.findById(id).orElseThrow(()->new RuntimeException("Not Found"+id));
		
		stuRepo.delete(stu);
		
		
	}


	@Override
	public Page<student> getStu(Pageable pageable) {
		
			return stuRepo.findAll(pageable);
	}


	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
