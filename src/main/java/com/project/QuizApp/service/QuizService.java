package com.project.QuizApp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.QuizApp.dao.QuestionsDao;
import com.project.QuizApp.dao.QuizDao;
import com.project.QuizApp.dao.ResponseDao;
import com.project.QuizApp.dto.QuestionWrapper;
import com.project.QuizApp.dto.Questions;
import com.project.QuizApp.dto.Quiz;
import com.project.QuizApp.dto.Response;

@Service
public class QuizService {
	@Autowired
	QuizDao quizDao;
	@Autowired
	QuestionsDao questionsDao;
	@Autowired
	ResponseDao responseDao;

	public ResponseEntity<String> createQuiz(String category, int numQ, String title) {
		List<Questions> questions = questionsDao.findRandomQuestionsByCategory(category, numQ);
		Quiz quiz = new Quiz();
		quiz.setTitle(title);
		quiz.setQuestions(questions);
		quizDao.save(quiz);
		return new ResponseEntity<String>("success", HttpStatus.CREATED);
	}

	public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id) {
		// TODO Auto-generated method stub
		Optional<Quiz> quiz = quizDao.findById(id);
		List<QuestionWrapper> questionWrappers = new ArrayList<>();
		List<Questions> questionsfromDB = quiz.get().getQuestions();
		for (Questions q : questionsfromDB) {
			QuestionWrapper qw = new QuestionWrapper(q.getId(), q.getQuestionstitle(), q.getOption1(), q.getOption2(),
					q.getOption3(), q.getOption4());
			questionWrappers.add(qw);

		}

		return new ResponseEntity<List<QuestionWrapper>>(questionWrappers, HttpStatus.OK);

	}

	public ResponseEntity<Integer> calculateResult(Integer id, List<Response> responses) {
		// TODO Auto-generated method stub
		Quiz quiz = quizDao.findById(id).get();
//		System.out.println(quiz.getId());
		List<Questions> questions = quiz.getQuestions();
		int i = 0;  
		int correctAnswer = 0;
		for (Response response : responses) {
			if (response.getResponse().equals(questions.get(i).getCorrectanswer())) {
				i++;
			correctAnswer++;
			
			}
		}
		System.out.println(correctAnswer);
		Response response = new Response();
		response.setScore(correctAnswer);
		Response response2=responseDao.save(response);
		System.out.println("score is : "+ response2.getScore());
			return new ResponseEntity<Integer>(correctAnswer, HttpStatus.OK);
	}

}
