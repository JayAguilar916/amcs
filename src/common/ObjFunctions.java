package common;

import java.io.IOException;
import java.time.Duration;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ObjFunctions {
	
	// XPaths
//	protected String PredefinedLanguage = "//a[@class='language-selector']";
	protected String PredefinedLanguage = "language-selector";
	protected String HomePageVerify = "//h3[contains(text(),'Featured Article:')]";
	protected String Careers= "//a[@href='/careers/#']";
	protected String CareersPageVerify= "//h1[contains(text(),'Careers')]";
	
	//Language XPaths
	protected String Nederlands = "//a[contains(text(),'Nederlands')]";
	protected String Deutsch = "//a[contains(text(),'Deutsch')]";
	protected String Español = "//a[contains(text(),'Español')]";
	protected String Dansk = "//a[contains(text(),'Dansk')]";
	protected String Français = "//a[contains(text(),'Français')]";
	protected String EnglishUK= "//a[contains(text(),'English (United Kingdom)')]";
	protected String Slovak = "//a[contains(text(),'Slovak')]";
	protected String Irish = "//a[contains(text(),'Irish')]";
	protected String undefined= "//a[contains(text(),'undefined')]";
	
	//Filters XPath
	protected String US= "//span[contains(text(),'United States')]";
	protected String GB= "//span[contains(text(),'United Kingdom')]";
	protected String AU= "//span[contains(text(),'Australia')]";
	protected String IE= "//span[contains(text(),'Ireland')]";
	protected String SK= "//span[contains(text(),'Slovakia')]";
	protected String PL= "//span[contains(text(),'Poland')]";
	protected String PG= "//span[contains(text(),'Papua New Guinea')]";
	protected String SalesMarketing= "//input[@value='sales&marketing']/following-sibling::span";
	protected String ProfessionalServices= "//input[@value='professionalservices']/following-sibling::span";
	protected String Fishing= "//span[contains(text(),'Fishing')]";
	protected String Hunting= "//span[contains(text(),'Hunting')]";
	protected String Driving= "//span[contains(text(),'Driving')]";
	
	protected WebDriver driver;
	public WebDriverWait wait_element;
	
	
	//Open Chrome
	public void openChrome() throws InterruptedException{
		System.setProperty("webdriver.chrome.driver", "C:\\Prog\\Workspace\\AMCS\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
//	 Navigate to a web page
	public void navigatePage(String url){
		//driver.navigate().to(url);
		driver.get(url);
	}
	
	
	// Prints a line
	public void printOut(String text) {
		System.out.println(text);
	}
	
	
	// Waits (in seconds)
	public void wait(int sec) throws InterruptedException {
		int sec1 = sec * 1000;
		Thread.sleep(sec1);
	}
	
	
	// Clicks an element
	public void obj_click(String type, String locator) throws Exception {
		WebElement element = findElement(type, locator);
		boolean tryAgain = false;
		
		try{
			if(element != null){
				element.click();
				printOut("[ACTION]	The element has been clicked. xPath [ "+locator+" ]");
			}
		}catch(Exception e){
			
			// Pop up options
			JFrame frmOpt = new JFrame();
		    frmOpt.setVisible(true);
		    frmOpt.setLocation(100, 100);
		    frmOpt.setAlwaysOnTop(true);
			
			Object[] options1 = { "Retry", "Skip", "Stop" };				
			
			int userInput = JOptionPane.showOptionDialog(frmOpt,
		    "Object not found. Object Info [ "+locator +" ]",
		    "findElement Function",
		    JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, options1, null);
			
			frmOpt.setVisible(false);
			if (userInput == JOptionPane.YES_OPTION) {
				tryAgain = true;
				printOut("[ACTION]	'Retry' is clicked");
			} 
			else if(userInput == JOptionPane.NO_OPTION){
				tryAgain = false;
				printOut("[ACTION]	'Skip' is clicked");
				}
			else{
				tryAgain = false;
				printOut("[ACTION]	'Stop' is clicked");
				
				printOut("Selenium RunTime is stopped by user");
			}
			}
		
		if(tryAgain){
			obj_click(type, locator);
		}
		
	}
	
	// if obj_click() fails
	public void obj_click2(String type, String locator) throws Exception{
		WebElement element = findElement(type, locator);
		if(element != null){
			Actions builder = new Actions (driver);			
			builder.moveToElement(element).click().build().perform();
			printOut("[ACTION]	The element has been clicked. Object Name [ "+locator+" ]");
		}
	}
	
	
	// Returns True if Object is Visible. Waits up to 5 seconds
	public boolean obj_isVisible(String locator) throws Exception {
		
		try {
			
//			isDisplayed() method returns boolean value either True or False
			boolean element = driver.findElement(By.xpath(locator)).isDisplayed();
			
			if(element) {
				printOut("		Element is Visible");
			}else {
				printOut("		Element is NOT Visible");
			}
			
			return true;
		} catch (Exception e) {
			printOut("		Element is NOT Visible");
			return false;
		}

	}
	
	
	// This function verifies if the object is visible using obj_isVisible()
	public void obj_isVisible2(String locator) throws Exception {
			boolean tryAgain = false;
			if (obj_isVisible(locator) == true) {
				printOut("[ACTION]	The object is visible. Xpath ["+ locator +"]");
			}

			else {
				printOut("[ACTION]	The object is not visible. Waited for 5secs. Xpath ["+ locator +"]");
				
				JFrame frmOpt = new JFrame();
			    frmOpt.setVisible(true);
			    frmOpt.setLocation(100, 100);
			    frmOpt.setAlwaysOnTop(true);
				
				Object[] options1 = { "Retry", "Skip", "Stop" };				
				
				int userInput = JOptionPane.showOptionDialog(frmOpt,
			    "Object not found. Object Info [ "+locator +" ]",
			    "findElement Function",
			    JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, options1, null);
				
				frmOpt.setVisible(false);
				if (userInput == JOptionPane.YES_OPTION) {
					tryAgain = true;
					printOut("[ACTION]	'Retry' is clicked");
				} 
				else if(userInput == JOptionPane.NO_OPTION){
					tryAgain = false;
					printOut("[ACTION]	'Skip' is clicked");
					}
				else{
					tryAgain = false;
					printOut("[ACTION]	'Stop' is clicked");
					printOut("Selenium RunTime is stopped by user");
					}
				if (tryAgain) {
					obj_isVisible2(locator);
				}

			}
		}
	
	
	//Locating an element
	public void moveToElement(String locator) throws IOException {
		
			WebElement element;
//			WebDriverWait wait = new WebDriverWait(driver, 10);
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120, 1));

			try {
				element = driver.findElement(By.xpath(locator));

				wait.ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(element));
				Actions action = new Actions(driver);
				action.moveToElement(element);
//				action.doubleClick();
				action.perform();
				printOut("[ACTION]	Element located");
			} catch (Exception e) {
				printOut("[ACTION]	Element NOT located");
			}

		}
		
		
	//Get text from an element
	public String obj_getText(String locator) throws Exception {
		WebElement element = driver.findElement(By.xpath(locator));
		String str = "NO VALUE";
		if (element != null) {
			str = element.getText();
			printOut("[ACTION]	[" + str + "] has been retrieved from object. Object Name [ " + locator + " ]");
		}
		return str;
	}
	
	
	public WebElement findElement(String type, String locator) throws Exception{
			
		WebElement element = null;
		boolean tryAgain = false;
			try {
	        	switch(type){
	    		case "id": 				element = driver.findElement(By.id(locator)); break;
	    		case "name": 			element = driver.findElement(By.name(locator)); break;
	    		case "linktext": 		element = driver.findElement(By.linkText(locator)); break;
	    		case "css": 			element = driver.findElement(By.cssSelector(locator)); break;
	    		case "class": 			element = driver.findElement(By.className(locator)); break;
	    		case "xpath" : 			element = driver.findElement(By.xpath(locator)); break;
	    		case "partiallinktext": element = driver.findElement(By.partialLinkText(locator)); break;
    		}	        	
	        	
			} catch (Exception e) {
				
				// Pop up options
				JFrame frmOpt = new JFrame();
			    frmOpt.setVisible(true);
			    frmOpt.setLocation(100, 100);
			    frmOpt.setAlwaysOnTop(true);
				
				Object[] options1 = { "Retry", "Skip", "Stop" };				
				
				int userInput = JOptionPane.showOptionDialog(frmOpt,
			    "Object not found. Object Info [ "+locator +" ]",
			    "findElement Function",
			    JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, options1, null);
				
				frmOpt.setVisible(false);
				if (userInput == JOptionPane.YES_OPTION) {
					tryAgain = true;
					printOut("[ACTION]	'Retry' is clicked");
				} 
				else if(userInput == JOptionPane.NO_OPTION){
					tryAgain = false;
					printOut("[ACTION]	'Skip' is clicked");
					}
				else{
					tryAgain = false;
					printOut("[ACTION]	'Stop' is clicked");
					
					printOut("Selenium RunTime is stopped by user");
				
			}
			
			
		if(tryAgain){
			element = findElement(type, locator);
		}
		//} while (tryAgain);
	}
			return element;
	}
	
	// Closes the browser
	public void closeBrowser() {
		driver.close();
		driver.quit();
	}

}
