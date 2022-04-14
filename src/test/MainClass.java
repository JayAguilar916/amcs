package test;


import common.ObjFunctions;
import pages.HomePage;

public class MainClass {
	static HomePage home = new HomePage();
	static ObjFunctions obj = new ObjFunctions();

	public static void main(String[] args) throws Exception {
			
	obj.printOut("***** START OF TESTING *****");
	
// TASK A
	obj.printOut("[TASK A] Start of Testing");
		home.AMCS();
		home.accessPredefinedLanguage();
		home.verifyOptions();
		home.closeBrowser();
	obj.printOut("[TASK A] End of Testing");
		
// TASK B
	obj.printOut("[TASK B] Start of Testing");
		home.AMCS();
		home.accessPredefinedLanguage();
		home.verifyNONOptions();
		home.closeBrowser();
	obj.printOut("[TASK B] End of Testing");
		
// TASK C
	obj.printOut("[TASK C] Start of Testing");
		home.AMCS();
		home.navigateToBottom();
		home.verifyCareers();
		home.closeBrowser();
	obj.printOut("[TASK C] End of Testing");
	
// TASK D
	obj.printOut("[TASK D] Start of Testing");
		home.AMCS();
		home.navigateToBottom();
		home.verifyFiltersCountries();
		home.closeBrowser();
	obj.printOut("[TASK D] End of Testing");
	
// TASK E
	obj.printOut("[TASK E] Start of Testing");
		home.AMCS();
		home.navigateToBottom();
		home.verifyFiltersCategories();
		home.closeBrowser();
	obj.printOut("[TASK E] End of Testing");
	
// TASK F
	obj.printOut("[TASK F] Start of Testing");
		home.AMCS();
		home.navigateToBottom();
		home.filtersCountriesIreland();
		home.verifyURLIreland();
		home.closeBrowser();
	obj.printOut("[TASK F] End of Testing");
	
	obj.printOut("***** TESTING IS COMPLETE *****");
	
	}
	
}
