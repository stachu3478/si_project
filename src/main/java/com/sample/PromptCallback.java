package com.sample;

import java.util.List;

import javax.swing.JFrame;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import com.sample.BottleOfWineApp.Prompt;

public class PromptCallback {
	private KieContainer kContainer;
	private KieSession kSession;

	public PromptCallback(KieContainer kc) {
		kContainer = kc;
		kSession = kContainer.newKieSession("ksession-rules");
		KieServices ks = KieServices.Factory.get();
		ks.getLoggers().newFileLogger(kSession, "wine");
	}

	public void loadKnowledge(List<Question> knowledge) {
		for (Question q : knowledge) {
			kSession.insert(q);
		}
	}

	public void run(JFrame frame) {
		Prompt prompt = new Prompt();

		kSession.insert(prompt);
		kSession.fireAllRules();
	}
}
