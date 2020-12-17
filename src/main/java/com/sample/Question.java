package com.sample;

import java.util.Vector;

public class Question {
	private String keyword;
	private String content;
	private Vector<Answer> answers;
	private static BottleOfWineUI ui;
	
	public Question(String k, String c) {
		keyword = k;
		content = c;
		answers = new Vector<>();
	}
	
	public void addAnswer(Answer a) {
		answers.add(a);
	}
	
	public Object[] getAnswers() {
		return answers.toArray();
	}
	
	public String toString() {
		return content;
	}
	
	public boolean equals(Question q) {
		return keyword == q.keyword;
	}
	
	public String getKeyword() {
		return keyword;
	}
	
	public static void setUI(BottleOfWineUI u) {
		ui = u;
	}
	
	public Info ask() {
		Object[] options = this.getAnswers();
		int result = ui.ask(content, options);
		return new Info(this, (Answer)options[result]);
	}
}
