package com.snm.service;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.snm.entity.student;

public interface studentService  {
	
	student createStudent(student stu);
	
    void deleteStu(Integer id);
	
		
	student getStudent(Integer id);

	student updateStudent(student stu, Integer id);
	
	List<student> getAll();
	
	Page<student>getStu(Pageable pageable);

}
