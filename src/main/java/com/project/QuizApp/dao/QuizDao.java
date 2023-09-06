package com.project.QuizApp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.QuizApp.dto.Quiz;

public interface QuizDao extends JpaRepository<Quiz, Integer>{
	
	

}
