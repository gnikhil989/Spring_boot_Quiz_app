package com.project.QuizApp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.QuizApp.dao.QuestionsDao;
import com.project.QuizApp.dto.Questions;

@Service
public class QuestionService {

	@Autowired
	QuestionsDao questionsDao;

	public ResponseEntity<List<Questions>> getAllQuetions() {
		try {
			return new ResponseEntity<>(questionsDao.findAll(), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			
		}
return new ResponseEntity<>( new ArrayList<>(),HttpStatus.BAD_REQUEST);
	}

	public ResponseEntity< List<Questions>> getQuestionsBycategory(String category) {
try {
	return  new  ResponseEntity<List<Questions>>(questionsDao.findByCategory(category), HttpStatus.OK);
} catch (Exception e) {
	e.printStackTrace();
}
		return new ResponseEntity<List<Questions>>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
	}

	public ResponseEntity<String> addQuestion(Questions questions) {
		try {
			questionsDao.save(questions);
			return new ResponseEntity<String>("Success", HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		return new ResponseEntity<String>("error in adding question", HttpStatus.NOT_ACCEPTABLE);
	}

	public ResponseEntity<String> updateQuestionById(Integer id, Questions questions) {
		try {
			Questions questions2=questionsDao.findById(id).get();
			questions2.setCategory(questions.getCategory());
			questions2.setCorrectanswer(questions.getCorrectanswer());
			questions2.setDifficultylevel(questions.getDifficultylevel());
			questions2.setOption1(questions.getOption1());
			questions2.setOption2(questions.getOption2());
			questions2.setOption3(questions.getOption3());
			questions2.setOption4(questions.getOption4());
			questions2.setQuestionstitle(questions.getQuestionstitle());
			questionsDao.save(questions2);
			return new ResponseEntity<String>("question updated ", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<String>("not updated", HttpStatus.NOT_ACCEPTABLE);
	}

}
