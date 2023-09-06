package com.project.QuizApp.dto;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.RequiredArgsConstructor;
@Entity
@Data
@RequiredArgsConstructor
public class Response {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int U_id;
	private Integer id;
	private String response;
	private int score;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getResponse() {
		return response;
	}
	public void setResponse(String response) {
		this.response = response;
	}
	public int getU_id() {
		return U_id;
	}
	public void setU_id(int u_id) {
		U_id = u_id;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	


}
