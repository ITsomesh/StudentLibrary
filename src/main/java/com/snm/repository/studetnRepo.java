package com.snm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.snm.entity.student;


@Repository
public interface studetnRepo extends JpaRepository<student, Integer> {

}
