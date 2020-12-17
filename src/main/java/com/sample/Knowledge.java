package com.sample;

import java.util.Vector;

public class Knowledge {
	private Vector<Question> questions;
	private Question lastQuestion;
	
	public Knowledge() {
		this.questions = new Vector<>();
		this.fetch();
	}
	
	public Vector<Question> getQuestions() {
		return questions;
	}
	
	private void fetch() {
		// Initial rules go here
    	// ...
		// http://winefolly.com/update/how-to-choose-wine/
		createQuestion("whoDrinks", "Who is drinking the wine?");
    	addAnswer("personalUse", "Myself");
    	addAnswer("someoneElse", "Someone else");
    	createQuestion("socialGathering", "Are you at a social gathering");
    	addAnswer("yes", "Yes");
    	addAnswer("no", "No. I want to make a gift");
    	createQuestion("whichSocialGathering", "At which social gathering are you at?");
    	addAnswer("getTogether", "Get together");
    	addAnswer("bachelorParty", "Bachelor (ETTE) party");
    	addAnswer("dinnerParty", "Dinner party");
    	addAnswer("beachBbq", "Beach BBQ");
    	addAnswer("artOpening", "Art opening");
    	createQuestion("knowPeople", "Do you really know people / person you want to meet?");
    	addYesNo();
    	createQuestion("doPeopleLoveWine", "Are they a wine lover / wine lovers?");
    	addYesNo();
    	createQuestion("peopleFavorite", "Are they your favorite people in the world?");
    	addYesNo();
    	createQuestion("whoIsCooking", "Who is cooking at the dinner party?");
    	addAnswer("me", "Me");
    	addAnswer("them", "Them");
    	createQuestion("atHome", "Are you at home?");
    	addYesNo();
    	createQuestion("alone", "Are you alone at home?");
    	addYesNo();
    	createQuestion("recoveringFromWork", "Are you recovering from work?");
    	addYesNo();
    	createQuestion("gettingDrunk", "Are you going to drunk?");
    	addYesNo();
    	createQuestion("feelingFancy", "Are you feeling fancy?");
    	addAnswer("yes", "Oui.");
    	addAnswer("no", "No");
    	createQuestion("dailyDrinking", "Do you drink wine daily?");
    	addAnswer("yes", "Yes");
    	addAnswer("no", "No, it is for my wine collection");
    	createQuestion("koolAidMan", "Kool-Aid man?");
    	addYesNo();
    	createQuestion("eatDirtAsAChild", "Were you eat dirt as a child?");
    	addAnswer("yes", "Yum");
    	addAnswer("no", "No");
    	createQuestion("sprayButter", "Do you spray butter in your mouth?");
    	addAnswer("yes", "Yep");
    	addAnswer("no", "No!");
    	createQuestion("newOrOld", "Do you prefer new or old world?");
    	addAnswer("old", "Old");
    	addAnswer("new", "New");
    	addAnswer("dunno", "What?");
    	createQuestion("cults", "Are you into cults?");
    	addYesNo();
    	createQuestion("where", "Where are you on the go?");
    	addAnswer("dinner", "Dinner");
    	addAnswer("restaurant", "Restaurant");
    	addAnswer("camping", "Camping");
    	addAnswer("drinkingInPublic", "Drinking in public");
    	addAnswer("special", "It is a special occasion");
    	createQuestion("wineIsMainCourse", "Is the wine main course?");
    	addYesNo();
    	createQuestion("fromMicrowave", "Is the dinner from microwave?");
    	addYesNo();
    	createQuestion("cookWithWine", "Are you cooking with your wine?");
    	addYesNo();
    	createQuestion("orderFromWindow", "Is the order from a window?");
    	addAnswer("yes", "Yes..?");
    	addAnswer("no", "No");
    	createQuestion("pronounce", "Can you pronounce the menu?");
    	addYesNo();
    	createQuestion("special", "What is the special occassion?");
    	addAnswer("anniversary", "Anniversary");
    	addAnswer("eloping", "Eloping");
    	addAnswer("blindDate", "Blind date");
    	addAnswer("birthday", "Birthday");
    	addAnswer("newYear", "New Year");
    	createQuestion("old", "Do you feel old?");
    	addYesNo();
    	createQuestion("firstAnniversary", "Is it the first anniversary?");
    	addYesNo();
	}
	
	private void createQuestion(String key, String content) {
		lastQuestion = new Question(key, content);
		questions.add(lastQuestion);
	}
	
	private void addAnswer(String key, String content) {
		lastQuestion.addAnswer(new Answer(key, content));
	}
	
	
	private void addYesNo() {
		addAnswer("yes", "Yes");
    	addAnswer("no", "No");
	}
}
