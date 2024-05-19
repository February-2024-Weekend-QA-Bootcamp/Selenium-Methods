package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

// new, you have to manually write it to get access of common method
// this is possible when they are static in nature, * means all
// This is called static import
import static common.CommonActions.*;

public class HomePage {
	public WebDriver driver;
	
	// parameterized constructor initialized when class in instantiated [object created]
	public HomePage(WebDriver driver) {
		this.driver = driver;
		// PageFactory class help to instantiate WebElements
		// Important interview question
		PageFactory.initElements(driver, this);
	}

	// 1st way: Most common way to write the WebElement (@FindBy), you must know how to do that
	// Use of unique 'Id' attribute as locator
	@FindBy (id = "cms-login-submit") 
	WebElement loginButton;
	
	// Use of unique 'name' attribute as locator
	@FindBy(name = "user-d")
	WebElement userId;
	
	// 2nd way to write the WebElement: not common, here I used for the 'password'
	// Just to make you guys familiar, if you see in your job
	// Use of unique 'name' attribute as locator
	@FindBy(how = How.NAME, using = "pass-d")
	WebElement password;
	
	// Use of unique  'class' attribute as locator
	// FYI: Never take a class value as unique if they have white space between words. 
	// Example: class value of user id, this is unique, but a compound class --> "cms-login-field ng-dirty ng-touched ng-invalid"
	@FindBy(className = "cms-newuser-reg")
	WebElement newUserRegistration;
	
	@FindBy(xpath = "//em[@id='cms-homepage-header-logo-unauth' and @class='cms-icon cms-sprite-loggedout ms-3']")
	WebElement logo;
	
	// How to test implicitlyWait()? or
	// Used it to show the common action method exception: NoSuchElementException
	@FindBy (className = "-newuser-reg")
	WebElement wrongNewUserRegistration;
	
	// 3rd way to write the WebElement with "By" Class: Not common, here I used unlock web element from the home page
	// instead of xpath, we can use id, name, class etc as locator.
	// By unlock = By.id("cms-unlock-account");	 	// or	
	By unlock = By.xpath("//a[text()='unlock']");
	

	@FindBy(xpath = "//label[@id='cms-label-tc']")
	WebElement checkBox;
	
	public void clickLoginButton() throws InterruptedException {
		Thread.sleep(4000); // no need literally, just put to see the click
		loginButton.click(); // common method is not used here
		Thread.sleep(4000);
	}
	
	public void clickUserId() {
		clickElement(userId); // common method is used from here
	}
	
	public void clickPassword() {
		clickElement(password);
	}
	
	public void clickNewUserRegistration() {
		clickElement(newUserRegistration);
		try {
			Thread.sleep(4000);
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void clickLogo() {
		clickElement(logo);
	}
	
	// How to test implicitlyWait()? 
	public void clickWrongNewUserRegistration() {
		clickElement(wrongNewUserRegistration);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	// Not common, just for your reference
	public void clickUnlock() throws InterruptedException {
		Thread.sleep(5000);
		// This is the new way to call the web element
		driver.findElement(unlock).click();
		Thread.sleep(5000);		
	}
	
	// We are using sendKeys() method to input the text in any field
	public void inputTextInUserIdField () {
		userId.sendKeys("February 2024 Weekend Batch"); // common method is not used here
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	// We are using 3 common actions here
	public void inputTextInUserIdAndPasswordFieldThenIAgreeThenClickLoginButton() {
		inputText(userId, "February 2024 QA Bootcamp");
		pause(3);
		inputText(password, "Abc@123a");
		pause(3);
		clickElement(checkBox);
		pause(3);
		clickElement(loginButton);
		pause(3);
	}
		
		
	
	
	
	
	
	
	
 
}
