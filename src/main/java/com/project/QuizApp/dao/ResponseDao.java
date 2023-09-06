package com.project.QuizApp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.QuizApp.dto.Response;

@Repository
public interface ResponseDao extends JpaRepository<Response, Integer> {

}
