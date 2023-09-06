package com.project.QuizApp.controller;


import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.project.QuizApp.dto.QuestionWrapper;
import com.project.QuizApp.dto.Questions;
import com.project.QuizApp.dto.Quiz;
import com.project.QuizApp.service.QuizService;

@RestController
@RequestMapping("/quiz")
public class QuizController {
	
	@Autowired
	QuizService  quizService; 

@PostMapping("/create")
	public ResponseEntity<String> createQuiz(@RequestParam String category , @RequestParam int numQ, @RequestParam String title){
		return quizService.createQuiz(category, numQ,title);
	}
@GetMapping("/get/{id}")
public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(@PathVariable Integer id){
	return quizService.getQuizQuestions(id);
}
@PostMapping("/submit/{id}")
public ResponseEntity<Integer> submitQuiz(@PathVariable Integer id, @RequestBody List<com.project.QuizApp.dto.Response>responses){
	System.out.println(id);
	return quizService.calculateResult(id,responses);
}
}
