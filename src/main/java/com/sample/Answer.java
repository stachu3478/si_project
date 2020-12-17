package com.sample;

public class Answer {
	private String keyword;
	private String content;
	
	public Answer(String k, String c) {
		keyword = k;
		content = c;
	}
	
	public String toString() {
		return content;
	}
	
	public boolean equals(Answer a) {
		return keyword == a.keyword;
	}
	
	public String getKeyword() {
		return keyword;
	}
}
