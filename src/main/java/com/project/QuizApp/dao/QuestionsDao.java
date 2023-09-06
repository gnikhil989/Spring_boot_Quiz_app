package com.project.QuizApp.dao;

import java.util.List;

import org.hibernate.annotations.NamedNativeQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.QuizApp.dto.Questions;

import jakarta.persistence.NamedNativeQueries;

@Repository
public interface QuestionsDao extends  	JpaRepository<Questions, Integer>{
	List<Questions> findByCategory(String category);
	@Query(value = "SELECT * FROM questions q WHERE q.category = :category ORDER BY RAND() LIMIT :numQ", nativeQuery = true)
	List<Questions> findRandomQuestionsByCategory(@RequestParam("category") String category, @RequestParam("numQ") int numQ);


	
}
