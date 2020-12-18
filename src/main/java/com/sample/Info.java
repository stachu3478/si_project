package com.sample;

import javax.swing.JTextArea;

public class Info {
	private Question question;
	private Answer answer;
	private static JTextArea output;

	public Info(Question q, Answer a) {
		question = q;
		answer = a;
		output.append(q.toString() + "\n");
		output.append(a.toString() + "\n");
	}

	public String getQuestion() {
		return question.getKeyword();
	}

	public String toString() {
		return answer.getKeyword();
	}

	public static void setOutput(JTextArea o) {
		output = o;
	}
}
