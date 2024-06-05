package common;

import java.util.NoSuchElementException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.github.dockerjava.api.model.Driver;

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
	
	// I will think to change it
	public static void verifyTitle(WebDriver driver, String expectedTitle) {
		try {
			String actualTitle = driver.getTitle();
			Loggers.logTheTest("Actual Title is : " + actualTitle + " ---> And Expected Title is :" + expectedTitle);
			Assert.assertEquals(actualTitle, expectedTitle);
		} catch (NullPointerException e) {
			e.printStackTrace();
			Loggers.logTheTest("Driver is not initiated properly Or Home Page Title doesn't match");
			Assert.fail();
		}
	}

	public static void verifyTextOfTheWebElement(WebElement element, String expected) {
		String actual = element.getText();
		Loggers.logTheTest(element + " ---> Actual text : " + actual + ". Expected text : " + expected);
		Assert.assertEquals(actual, expected, "Text In the WebElement doesn't match");
	}
	
	public static void verifyCurrentUrl(WebDriver driver, String expectedURL) {
		String currentURL = driver.getCurrentUrl();
		Loggers.logTheTest("Current URL : " + currentURL + ", Expected URL : " + expectedURL);
		Assert.assertEquals(currentURL, expectedURL, "Current URL is not correct");		
	}
	
	public static void clearTextFromTheField(WebElement element) {
		try {
			element.clear();
			Loggers.logTheTest("The Text from the " + element + " ---> is cleared");
		} catch (NoSuchElementException | NullPointerException e) {
			e.printStackTrace();
			Loggers.logTheTest(element + "<----------> has not been found\n" + e.getMessage());
			Assert.fail();
		}
	}
	
	public static void inputTextThenClickEnter(WebElement element, String input) {
		try {
			element.sendKeys(input, Keys.ENTER);
			Loggers.logTheTest(input + " <-----> has been put into <-----> " + element + " and then clicked by Enter Key");
		} catch (NoSuchElementException | NullPointerException e) {
			e.printStackTrace();
			Loggers.logTheTest(element + "<----------> has not been found\n" + e.getMessage() );
			Assert.fail();
		}
	}
	
	public static void inputTextThenClickReturn(WebElement element, String input) {
		try {
			element.sendKeys(input, Keys.RETURN);
			Loggers.logTheTest(input + " <-----> has been put into <-----> " + element + " and then clicked by Enter Key");
		} catch (NoSuchElementException | NullPointerException e) {
			e.printStackTrace();
			Loggers.logTheTest(element + "<----------> has not been found\n" + e.getMessage() );
			Assert.fail();
		}
	}
	
	public static void inputTextThenClickTab(WebElement element, String input) {
		try {
			element.sendKeys(input, Keys.TAB);
			Loggers.logTheTest(input + " <-----> has been put into <-----> " + element + " and then clicked by Enter Key");
		} catch (NoSuchElementException | NullPointerException e) {
			e.printStackTrace();
			Loggers.logTheTest(element + "<----------> has not been found\n" + e.getMessage() );
			Assert.fail();
		}
	}
	
	
	
	

}
