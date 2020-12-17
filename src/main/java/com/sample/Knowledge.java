package com.sample;

import java.util.Vector;

public class Knowledge {
	private Vector<Question> questions;
	private Question lastQuestion;
	
	public Knowledge() {
		this.questions = new Vector<>();
		this.fetch();
	}
	
	public Vector<Question> getQuestions() {
		return questions;
	}
	
	private void fetch() {
		// Initial rules go here
    	// ...
		createQuestion("whoDrinks", "Who is drinking the wine?");
    	addAnswer("personalUse", "Myself");
    	addAnswer("someoneElse", "Someone else");
    	
	}
	
	private void createQuestion(String key, String content) {
		lastQuestion = new Question(key, content);
		questions.add(lastQuestion);
	}
	
	private void addAnswer(String key, String content) {
		lastQuestion.addAnswer(new Answer(key, content));
	}
}
