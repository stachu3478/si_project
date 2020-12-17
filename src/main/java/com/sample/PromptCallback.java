package com.sample;

import javax.swing.JFrame;
import javax.swing.JTextArea;

import java.util.List;

import org.kie.api.KieServices;
import org.kie.api.logger.KieRuntimeLogger;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import com.sample.BottleOfWineApp.Prompt;

public class PromptCallback {
	KieContainer kContainer;
	JTextArea output;
	KieSession kSession;
	KieRuntimeLogger kLogger;
	
	public PromptCallback(KieContainer kc) {
		kContainer = kc;
		kSession = kContainer.newKieSession("ksession-rules");
		KieServices ks = KieServices.Factory.get();
		kLogger = ks.getLoggers().newFileLogger(kSession, "wine");
	}
	
	public void run(JFrame frame, List<Question> knowledge) {
		Prompt prompt = new Prompt();
		
		for (Question q : knowledge) {
			kSession.insert(q);
		}
		
		kSession.insert(prompt);
		kSession.fireAllRules();
	}
	
	public void tearDown() {
		kLogger.close();
	}
	
	public void setOutput(JTextArea o) {
		output = o;
	}
}
