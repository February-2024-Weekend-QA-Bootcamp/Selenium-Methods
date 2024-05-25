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
	
	@FindBy(linkText = "User ID")
	WebElement forgotUserId;
	
	@FindBy(partialLinkText = "Passwo")
	WebElement forgotPassword;
	
	@FindBy(partialLinkText = "Terms & Con")
	WebElement termsAndConditions;
	
	// use of contains() in xpath
	@FindBy(xpath = "//a[contains(text(), 'New')]")
	WebElement newUserRegistration2;
	
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
	
	// Alternate of above method
	// We can use a web element directly in the method, that is also common, but different people like different way
	public void useOfByClassInLogin() {
		driver.findElement(By.name("user-d")).sendKeys("February 2024 QA Bootcamp");
		pause(3);
		driver.findElement(By.xpath("//input[@id='cms-login-password']")).sendKeys("Abc@123a");
		pause(3);
		driver.findElement(By.id("cms-label-tc")).click();
		pause(3);
		driver.findElement(By.id("cms-login-submit")).click();
		pause(3);
	}
	
	// Important: Use of linkText as locator
	// Web Element: forgot password
	public void use_of_linkText_as_locator_in_forgot_userId_hyperlink() {
		pause(3);
		clickElement(forgotUserId);
		pause(3);
	}
	
	// Important: Use of partial linkText as locator
	// Web Element: forgot password
	public void use_of_partialLinkText_as_locator_in_forgot_passowrd_hyperlink() {
		pause(3);
		clickElement(forgotPassword);
		pause(3);
	}
	
	// Web Element: Logo
	// logo: class attribute value:  cms-icon cms-sprite-loggedout ms-3
	// Exception 'InvalidSelectorException': 'Compound class names not permitted',
	// so even if you see class value is unique but separated by space, avoid this as class name locator
	// This scenario will show error and will failed everywhere
	public void why_we_use_cssSelector_as_locator_in_logo () {
		driver.findElement(By.className("cms-icon cms-sprite-loggedout ms-3")).click();
	}
	
	// Web Element: New User Registration Button
	// Important: Use of cssSelector as locator
	// cssSelector is very important for interview
	// cssSelector by class --> inside the string, first put html tag, then dot, then write value of the class attribute 
	public void role1_use_of_cssSelector_by_class_name_value () {
		driver.findElement(By.cssSelector("a.cms-newuser-reg")).click();
		pause(3);
	}
	
	// Important: Use of cssSelector as locator
	// Web Element: login Button
	// if you wanna create cssSelector by id 
	// first html tag, then # (hash), then write the value of id attribute inside the string
	public void role2_use_of_cssSelector_by_id_value() {
		driver.findElement(By.cssSelector("button#cms-login-submit")).click();
		pause(3);
	}
	
	// Web Element: logo
	// Important: Use of cssSelector as locator
	// if the class (compound class) contain separate words [cms-icon cms-sprite-loggedout ms-3], 
	// they are actually different class, then
	// we have to close the gap between classes by putting the dot/period
	// cssSelector by class --> htmltag.class name value 
	// remove the space between words in class value, and replace with dot/period
	public void role3_use_of_cssSelector_by_compund_class_name_value () {
		driver.findElement(By.cssSelector("em.cms-icon.cms-sprite-loggedout.ms-3")).click();
		pause(3);
	}
	
	// Above 3 is mostly used, 99% cases of css selector, also very common interview question
	// below 3 high level, no need to see if you feel they are tough
	
	// Use of cssSelector as locator
	// Web Element: login Button
	// high level, you can ignore
	// cssSelector by another attribute
	// --> htmltag[id/class/name attribute = 'value of the attribute' ] , in xpath - you use // and @, which is absent here 
	// and you can use any other attribute name except id and class
	public void role4_use_of_cssSelector_by_attribute_and_its_value () {
		driver.findElement(By.cssSelector("button[name='Submit Login']")).click();
		pause(3);
	}
	
	// Web Element: NUR Button
	// Not important, can ignore
	// cssSelector by another attribute
	// --> htmltag.value of class[id/class/name attribute = 'value of the attribute'] , in xpath you use // and @, which is absent here and you can use attribute except id and class
	// That's why we use title
	public void role5_use_of_cssSelector_by_class_name_value_and_attribute_and_its_value() {
		driver.findElement(By.cssSelector("a.cms-newuser-reg[title='New User Registration']")).click();
		pause(3);
	}
	
	// Important: Use of cssSelector as locator
	// Web Element: login Button
	// Not important, can ignore
	// cssSelector by another attribute
	// --> htmltag#value of ID[attribute name='value'] , in xpath you use // and @, which is absent here and you can use attribute except id and class	
	public void role6_use_of_cssSelector_by_id_value_and_attribute_and_its_value() {
		driver.findElement(By.cssSelector("button#cms-login-submit[title='Login']")).click();
		pause(3);
	}
	
	// Important: Use of tagName as locator
	// tag name: we have to go to Amazon and find "table" tag
	
	// in cms portal not a single tag except header
	public void use_of_tagName_as_locator() {
		driver.findElement(By.tagName("header")).click();
	}
	
	// Web Element: logo
	// isDisplayed() is an alternate of click() method which is boolean type
	// isDisplayed() is the method used to verify the presence of a web element within the web page.
	// Use of isDisplayed() available in --> image, link, button, text field, check box etc.
	public void use_of_isDisplayed() {
		boolean elementDisplayed = driver.findElement(By.cssSelector("em.cms-icon.cms-sprite-loggedout.ms-3")).isDisplayed();
		System.out.println("Is the Logo displayed? Ans: " + elementDisplayed);
	}
	// This is raw, used without common method
	

	// use of isDisplayed method inside elementDisplayed()
	public void use_of_isDisplayed_in_login() {
		elementDisplayed(userId);
		inputText(userId, "February 2024 QA Bootcamp");
		pause(3);
		elementDisplayed(password);
		inputText(password, "Abc@123a");
		pause(3);
		elementDisplayed(checkBox);
		clickElement(checkBox);
		pause(3);
		clickElement(loginButton);
		pause(3);
	}
	
	// Web Element: login Button
	// isEnabled() is the method used to verify if the web element is enabled or
	// disabled within the web page. isEnabled() is primarily used with buttons.
	// Use of isEnabled(), a boolean type method
	
	// use of isEnabled method inside elementEnabled()
	public void use_of_isEnabled_in_login() {
		elementDisplayed(userId);
		inputText(userId, "February 2024 QA Bootcamp");
		pause(3);
		elementDisplayed(password);
		inputText(password, "Abc@123a");
		pause(3);
		elementDisplayed(checkBox);
		clickElement(checkBox);
		pause(3);
		elementEnabled(loginButton); // used here
		clickElement(loginButton);
		pause(3);
	}
	
	// Web Element: checkbox
	// Used with radio buttons, dropdowns and checkboxes.
	// use of isSelected() method inside
	
	public void use_of_isSelected_in_login() {
		elementDisplayed(userId);
		inputText(userId, "February 2024 QA Bootcamp");
		pause(3);
		elementDisplayed(password);
		inputText(password, "Abc@123a");
		pause(3);
		elementSelected(checkBox);
		clickElement(checkBox);
		pause(3);
		elementEnabled(loginButton); // used here
		clickElement(loginButton);
		pause(3);
	}
	
	


	
	
	
	
	
 
}
