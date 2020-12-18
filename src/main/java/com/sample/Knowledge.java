package com.sample;

import java.util.Vector;

public class Knowledge {
	private Vector<Question> questions;
	private Vector<Response> response_s;
	private Question lastQuestion;

	public Knowledge() {
		this.questions = new Vector<>();
		this.response_s = new Vector<>();
		this.fetch();
	}

	public Vector<Question> getQuestions() {
		return questions;
	}

	public Vector<Response> getResponse_s() {
		return response_s;
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
		addYesNo();
		createQuestion("old", "Do you feel old?");
		addYesNo();
		createQuestion("firstAnniversary", "Is it the first anniversary?");
		addYesNo();
		addfinalresponse("WhiskyVodka", "leawe your wine at home bring Whisky or Vodka");
		addfinalresponse("BiggestRed", "By the biggest bottle with the words `red` blend on it");
		addfinalresponse("NoGlass", "`Bought a nice Bottle but it got confiscated` - no glass on the beach");
		addfinalresponse("NoTasteArt", "They barelly got a sense of taste 2 buck chuck");
		addfinalresponse("NoOpen", "Bring a Bring Bottle and hope no one opens it");
		addfinalresponse("PinotNoir", "Sniff your glass of Pinot Noir ");
		addfinalresponse("CaliPinotNoir", "Hedonistic joy ride California Pinot Noir");
		addfinalresponse("Merlot", "complacency is a bitch Merlot");
		addfinalresponse("RiesChenin", "Something Sweet- Riesling or Chenin Blanc");
		addfinalresponse("HighOctane", "Go for high Octane - Zindfel or Shiraz");
		addfinalresponse("Exotic", "Go for something exotic - Sangiovese or Grenache");
		addfinalresponse("SpanishCava", "cheap bubbly- Spanish Cava");
		addfinalresponse("ArgMalblec", "Fruit forward wine- Argentinian Malblec");
		addfinalresponse("SmallBoxWine", "No cork screw required- Single serve box wine");
		addfinalresponse("BigBoxWine", "Go budget go bulk - 3 liter Box wine");
		addfinalresponse("CotesRhone", "Ask for - Cotes du Rhone");
		addfinalresponse("SauvignioneBlanc", "white and less than 9 dollars such as: Suvignione Blanc");
		addfinalresponse("SQN_Cayuse", "Cult Classic- Sine Qua non or Cayuse");
		addfinalresponse("Chinon_Bourgeil", "Something earthy: Chinon or  Bourgueil");
		addfinalresponse("ButteryChardonay", "Please bring me Buttery Chardonnay");
		addfinalresponse("GetOut1", "thx for playing now get out of flowchart");
		addfinalresponse("GetOut2", "they dont deserve a wine get out of my flowchart");
		addfinalresponse("Bordoux_Burgundy", "Why buy anything but Bordoux or Burgundy");
		addfinalresponse("CaliCabernet", "drink a bottle of sun- California Cabernet");
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

	private void addfinalresponse(String key, String content) {
		response_s.add(new Response(key, content));
	}
}
