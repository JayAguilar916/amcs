package pages;

import common.ObjFunctions;

public class HomePage extends ObjFunctions {
	
	
	// Navigate to AMCS home page
	public void AMCS() throws Exception {
		openChrome();
		navigatePage("https://www.amcsgroup.com/");
		
		//Verification of the home page
		printOut("[ACTION]	Verifying element: Homepage");
		obj_isVisible(HomePageVerify);
	}
	
	//Click on English (or any predefined language)
	public void accessPredefinedLanguage() throws Exception {
//		obj_click("xpath", PredefinedLanguage);
		
		obj_click("class", PredefinedLanguage);
		wait(2);
	}
	
	//Verify that in drop down are options:Netherlands, Deutch, Espanol, Dansk, Francais, English (United Kingdom)
		public void verifyOptions() throws Exception {
			printOut("[ACTION]	Verifying Option element: Nederlands");
			boolean booleanNederlands = obj_isVisible(Nederlands);
			
			printOut("[ACTION]	Verifying Option element: Deutsch");
			boolean booleanDeutsch = obj_isVisible(Deutsch);
			
			printOut("[ACTION]	Verifying Option element: Español");
			boolean booleanEspañol = obj_isVisible(Español);
			
			printOut("[ACTION]	Verifying Option element: Dansk");
			boolean booleanDansk = obj_isVisible(Dansk);
			
			printOut("[ACTION]	Verifying Option element: Français");
			boolean booleanFrançais = obj_isVisible(Français);
			
			printOut("[ACTION]	Verifying Option element: EnglishUK");
			boolean booleanEnglishUK = obj_isVisible(EnglishUK);
			
			if(booleanNederlands&&booleanDeutsch&&booleanEspañol&&booleanDansk&&booleanFrançais&&booleanEnglishUK) {
				printOut("[CONFIRMED]	Filters contain the following languages: Netherlands, Deutch, Espanol, Dansk, Francais, English (United Kingdom)");
			}else {
				printOut("[FAILED]	Some language/s is/are missing, please check.");
			}
			
		}
		
	//Verify that in drop down are not options: Slovak, Irish, undefined
		public void verifyNONOptions() throws Exception {
			
			printOut("[ACTION]	Verifying Option element: Slovak");
			boolean booleanSL = obj_isVisible(Slovak);
			
			printOut("[ACTION]	Verifying Option element: Irish");
			boolean booleanIE = obj_isVisible(Irish);
			
			printOut("[ACTION]	Verifying Option element: undefined");
			boolean booleanUndefined = obj_isVisible(undefined);
			
			if(!booleanSL&&!booleanIE&&!booleanUndefined) {
				printOut("[CONFIRMED]	Filters doesn't contain the following languages: Slovakia, Poland and Papua New Guinea");
			}else {
				printOut("[FAILED]	Some/all language/s is/are visible. Please check.");
			}
			
		}
		
	//Navigate to the bottom of the page or simple click on the option Careers on the bottom of the page
		public void navigateToBottom() throws Exception {
			printOut("[ACTION]	Locating Element: Career");
			moveToElement(Careers);
			obj_click("xpath", Careers);
		}
		
	//Verify that you are redirected to https://www.amcsgroup.com/careers/#
		public void verifyCareers() throws Exception {
			printOut("[ACTION]	Verifying element: Career Page");
			String ExpectedURL = "https://www.amcsgroup.com/careers/#";
			String ActualURL = driver.getCurrentUrl();
			boolean areEqual = ActualURL.equals(ExpectedURL);
			
			if(areEqual) {
				printOut("[ACTION]	SUCCESSFULLY redirected to ["+ExpectedURL+"]");
			}else {
				printOut("[FAILED]	Did NOT redirected to ["+ExpectedURL+"]");
				printOut("[VERIFY]	Expected URL: "+ExpectedURL+"...");
				printOut("[VERIFY]	zzActual URL: "+ActualURL+"...");
			}
		}
		
	//Verify that filters contain Countries United States, United Kingdom, Australia and Ireland but not Slovakia, Poland and Papua New Guinea
		public void verifyFiltersCountries() throws Exception {
			
			//True
			printOut("[ACTION]	Verifying Filter element: United States");
			boolean booleanUS = obj_isVisible(US);
			printOut("[ACTION]	Verifying Filter element: United Kingdom");
			boolean booleanUK = obj_isVisible(GB);
			printOut("[ACTION]	Verifying Filter element: Australia");
			boolean booleanAU = obj_isVisible(AU);
			printOut("[ACTION]	Verifying Filter element: Ireland");
			boolean booleanIR = obj_isVisible(IE);
			
			//False
			printOut("[ACTION]	Verifying Filter element: Slovakia");
			boolean booleanSL = obj_isVisible(SK);
			printOut("[ACTION]	Verifying Filter element: Poland");
			boolean booleanPO = obj_isVisible(PL);
			printOut("[ACTION]	Verifying Filter element: Papua New Guinea");
			boolean booleanPNG = obj_isVisible(PG);
			
			if(booleanUS&&booleanUK&&booleanAU&&booleanIR) {
				printOut("[CONFIRMED]	Filters contain the following Countries: United States, United Kingdom, Australia and Ireland");
			}else {
				printOut("[FAILED]	Missing country/s: US, GB, AU, IE");
			}
			
			if(!booleanSL&&!booleanPO&&!booleanPNG) {
				printOut("[CONFIRMED]	Filters doesn't contain the following countries: Slovakia, Poland and Papua New Guinea");
			}else {
				printOut("[FAILED]	Some/all country/s is/are visible. Please check.");
			}
		}
		
	//Verify that filters categories contain Professional Services and Sales Marketing but does not contain Fishing, Hunting and Driving
		public void verifyFiltersCategories() throws Exception {
			
			//True
			printOut("[ACTION]	Verifying Filter element: Professional Services");
			boolean booleanProfessionalServices = obj_isVisible(ProfessionalServices);
			printOut("[ACTION]	Verifying Filter element: Sales Marketing");
			boolean booleanSalesMarketing = obj_isVisible(SalesMarketing);
			
			//False
			printOut("[ACTION]	Verifying Filter element: Fishing");
			boolean booleanFishing = obj_isVisible(Fishing);
			printOut("[ACTION]	Verifying Filter element: Hunting");
			boolean booleanHunting = obj_isVisible(Hunting);
			printOut("[ACTION]	Verifying Filter element: Hunting");
			boolean booleanDriving = obj_isVisible(Driving);
			
			if(booleanProfessionalServices&&booleanSalesMarketing) {
				printOut("[CONFIRMED]	Filters contain the following Categories: Professional Services and Sales Marketing");
			}else {
				printOut("[FAILED]	Missing Category/s, please check.");
			}
			
			if(!booleanFishing&&!booleanHunting&&!booleanDriving) {
				printOut("[CONFIRMED]	Filters doesn't contain the following Categories: Fishing, Hunting and Driving");
			}else {
				printOut("[FAILED]	Some/all categories are visible. Please check.");
			}
		}
		
	//Click on Filters -> Countries ->Ireland
		public void filtersCountriesIreland() throws Exception {
			obj_click("xpath", IE);
		}
		
	//Verify that URL is changes to https://www.amcsgroup.com/careers/?countries=ireland
		public void verifyURLIreland() throws Exception {
			printOut("[ACTION]	Verifying page: Ireland Page");
			String ExpectedURL = "https://www.amcsgroup.com/careers/?countries=ireland";
			String ActualURL = driver.getCurrentUrl();
			boolean areEqual = ActualURL.equals(ExpectedURL);
			
			if(areEqual) {
				printOut("[ACTION]	SUCCESSFULLY redirected to ["+ExpectedURL+"]");
			}else {
				printOut("[FAILED]	Did NOT redirected to ["+ExpectedURL+"]");
				printOut("[VERIFY]	Expected URL: "+ExpectedURL+"...");
				printOut("[VERIFY]	zzActual URL: "+ActualURL+"...");
			}
		}
		
	
}
