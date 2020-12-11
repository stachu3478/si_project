package com.sample;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

/**
 * This is a sample class to launch a rule.
 */
public class BottleOfWineApp {

    public static final void main(String[] args) {
        try {
            // load up the knowledge base
	        KieServices ks = KieServices.Factory.get();
    	    KieContainer kContainer = ks.getKieClasspathContainer();
        	KieSession kSession = kContainer.newKieSession("ksession-rules");

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
    	// Initial rules go here
    	// ...
    	Vector<Question> knowledge = new Vector<>();
    	Question q = new Question("whoDrinks", "Who is drinking the wine?");
    	q.addAnswer(new Answer("personalUse", "Myself"));
    	q.addAnswer(new Answer("someoneElse", "Someone else"));
    	knowledge.add(q);
    	
    	BottleOfWineUI ui = new BottleOfWineUI(knowledge, new PromptCallback(kc));
    	ui.createAndShow();
    }
    
    

    public static class Prompt {
        private String result;
        public List<Info> infos;
        public boolean isNew = true;
        
        public Prompt() {
        	infos = new ArrayList<Info>();
        }
        
        public void addInfo(Info info) {
        	infos.add(info);
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
    
    public static class Info {
    	private Question question;
    	private Answer answer;
    	
    	public Info(Question q, Answer a) {
    		question = q;
    		answer = a;
    	}
    	
    	public String getQuestion() {
    		return question.getKeyword();
    	}
    
    	public String toString() {
    		return answer.getKeyword();
    	}
    }
    
    public static class Question {
    	private String keyword;
    	private String content;
    	private Vector<Answer> answers;
    	
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
    }
    
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
}
