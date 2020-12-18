package com.sample;

public class Response {
	public String keyword;
	public String content;
	public static BottleOfWineUI ui;

	public Response(String keyword1, String content1) {
		keyword = keyword1;
		content = content1;
	}

	public void reply() {
		ui.reply_final(this);
	}
}
