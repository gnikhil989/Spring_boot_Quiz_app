package com.project.QuizApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.QuizApp.dto.Questions;
import com.project.QuizApp.service.QuestionService;

@RestController
@RequestMapping("/question")
public class QuestionController {
	@Autowired
	QuestionService questionService;
	
	@GetMapping("/allquestions")
	public  ResponseEntity<List<Questions>> getAllQuestion() {
		return  questionService.getAllQuetions();
	}
	@GetMapping("/category/{category}")
	public  ResponseEntity<List<Questions>> getQuestionsByCategory(@PathVariable String category){
		return questionService.getQuestionsBycategory(category); 
	}
	@PostMapping("/add")
	public ResponseEntity<String> addQuestions(@RequestBody  Questions questions) {
		System.out.println(questions.getCategory());
	return	questionService.addQuestion(questions);
	}
	@PutMapping("/update")
	public ResponseEntity<String> updatewQuestionsById(@PathVariable Integer id, @RequestBody Questions questions){
		return questionService.updateQuestionById(id,questions);
	}
}
