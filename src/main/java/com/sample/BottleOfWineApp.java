package com.sample;

import java.util.ArrayList;
import java.util.List;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;

/**
 * This is a sample class to launch a rule.
 */
public class BottleOfWineApp {

	public static final void main(String[] args) {
		try {
			// load up the knowledge base
			KieServices ks = KieServices.Factory.get();
			KieContainer kContainer = ks.getKieClasspathContainer();

			// go !
			BottleOfWineApp app = new BottleOfWineApp();
			app.init(kContainer);
		} catch (Throwable t) {
			t.printStackTrace();
		}
	}

	public BottleOfWineApp() {

	}

	public void init(KieContainer kc) {
		BottleOfWineUI ui = new BottleOfWineUI(new Knowledge().getQuestions(), new Knowledge().getResponse_s(),
				new PromptCallback(kc));// zmiana
		Question.setUI(ui);
		ui.createAndShow();
	}

	public static class Prompt {
		// private String result;
		public List<Info> infos;
		public boolean isNew = true;

		public Prompt() {
			infos = new ArrayList<Info>();
		}

		public void addInfo(Info info) {
			infos.add(info);
		}

		public boolean hasInfo(String str, String ans) {
			for (Info info : infos) {
				if (info.getQuestion() == str)
					return ans == null || ans == info.toString();
			}
			return false;
		}

		public boolean hasInfo(String str) {
			for (Info info : infos) {
				if (info.getQuestion() == str)
					return true;
			}
			return false;
		}

		public boolean hasAnswer(String str) {
			for (Info info : infos) {
				if (info.toString() == str)
					return true;
			}
			return false;
		}
	}
}
