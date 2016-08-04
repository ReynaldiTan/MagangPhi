package com.phiintegration.ws.controller;

import com.phiintegration.ws.model.QuestionAnswer;

public interface FAQInterface {

	int newQuestionAnswer(QuestionAnswer qa);

	boolean updateQuestionAnswer(QuestionAnswer qa);

	boolean deleteQuestionAnswer(QuestionAnswer qa);

}