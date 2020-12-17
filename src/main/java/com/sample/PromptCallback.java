package com.sample;

import javax.swing.JFrame;
import javax.swing.JTextArea;

import java.util.List;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import com.sample.BottleOfWineApp.Prompt;
import com.sample.BottleOfWineApp.Question;

public class PromptCallback {
	KieContainer kContainer;
	JTextArea output;
	
	public PromptCallback(KieContainer kc) {
		kContainer = kc;
	}
	
	public void run(JFrame frame, List<Question> knowledge) {
		Prompt prompt = new Prompt();
		
		KieSession kSession = kContainer.newKieSession("ksession-rules");
		
		for (Question q : knowledge) {
			kSession.insert(q);
		}
		
		kSession.insert(prompt);
		kSession.fireAllRules();
	}
	
	public void setOutput(JTextArea o) {
		output = o;
	}
}
