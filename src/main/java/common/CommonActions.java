package common;

import java.util.NoSuchElementException;

import org.openqa.selenium.WebElement;

import reports.Loggers;

public class CommonActions {
	// common method for click ()
	public static void clickElement(WebElement element) {
		try {
			element.click();
			Loggers.logTheTest(element + "<---------> has been clicked");
		} catch (NoSuchElementException | NullPointerException e) {
			// e.printStackTrace();
			System.out.println("Exception is: " + e);
			Loggers.logTheTest(element + "<----------> has not been found\n" + e.getMessage()); 
			// getMessage() Returns the detail message string of this throwable.
		}
	}
	
	// common method for sendKeys()
	public static void inputText(WebElement element, String input) {
		try {
			element.sendKeys(input);
			Loggers.logTheTest(input + " <-----> has been put into <-----> " + element);
		} catch (NoSuchElementException | NullPointerException e) {
			e.printStackTrace();
			Loggers.logTheTest(element + "<----------> has not been found\n" + e.getMessage() );
		}		
	}
	
	// common method for sleep()
	public static void pause(long sec) {
		try {
			Thread.sleep(sec * 1000);
			Loggers.logTheTest("Sleeping ... zZz " + sec);
		}catch (InterruptedException e) {
			e.printStackTrace();	
			Loggers.logTheTest("Sleep interrupted");
		}
	}
	
	public static void elementDisplayed (WebElement element){
		try {
			boolean flag = element.isDisplayed();
			Loggers.logTheTest(element + "<---------> is Displayed, " + flag);
		} catch (NoSuchElementException | NullPointerException e) {
			e.printStackTrace();
			Loggers.logTheTest(element + "<----------> is not Displayed\n" + e.getMessage() );
		}
	}
	
	
	public static void elementEnabled(WebElement element) {
		try {
			boolean flag = element.isEnabled();
			Loggers.logTheTest(element + "<---------> is Enabled, " + flag);
		} catch (NoSuchElementException | NullPointerException e) {
			e.printStackTrace();
			Loggers.logTheTest(element + "<----------> is not Displayed\n" + e.getMessage() );
		}
	}
	
	public static void elementSelected (WebElement element){
		try {
			boolean flag = element.isSelected();
			Loggers.logTheTest(element + "<---------> is Selected, " + flag);
		} catch (NoSuchElementException | NullPointerException e) {
			e.printStackTrace();
			Loggers.logTheTest(element + "<----------> is not Displayed\n" + e.getMessage() );
		}
	}
	
	

}
