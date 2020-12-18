package com.sample;

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
}
