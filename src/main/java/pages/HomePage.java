package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

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
	WebElement newUserRegidtration;
	
	@FindBy(xpath = "//em[@id='cms-homepage-header-logo-unauth' and @class='cms-icon cms-sprite-loggedout ms-3']")
	WebElement logo;
	
	public void clickLoginButton() throws InterruptedException {
		Thread.sleep(4000); // no need literally, just put to see the click
		loginButton.click();
		Thread.sleep(4000);
	}
	
	public void clickUserId() {
		userId.click();
	}
	
	public void clickPassword() {
		password.click();
	}
	
	public void clickNewUserRegistration() {
		newUserRegidtration.click();
		try {
			Thread.sleep(4000);
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void clickLogo() {
		logo.click();
	}
	
	
	
	
	
	
	
	
 
}
