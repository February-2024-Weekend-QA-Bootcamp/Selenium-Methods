package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

// new, you have to manually write it to get access of common method
// this is possible when they are static in nature, * means all
// This is called static import
import static common.CommonActions.*;

import java.time.Duration;

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
	
	// In real time scenario we do below test at the beginning of a page
	public void getMethodsOfThePage() {
		String actual = driver.getTitle();
		System.out.println("Title name: "+ actual);
		String expected = "CMS Enterprise Portal";
		Assert.assertEquals(actual, expected, "Title doesn't match!");
		
		String currentURL = driver.getCurrentUrl(); 
		System.out.println("Current URL: " + currentURL);
		String expectedURL= "https://portal.cms.gov/portal/";
		Assert.assertEquals(currentURL, expectedURL, "The driver failed to direct at right URL");
		
		// use of getText() in "login button"
		String nameOfTheWebElement = driver.findElement(By.name("Submit Login")).getText();
		System.out.println("Text Present: "+nameOfTheWebElement);
		String expectedText = "Login";
		Assert.assertEquals(nameOfTheWebElement, expectedText, "The text of the WebElement doesn't match");
	}
	
	// This is the first method used in a class
	// what is title?
	// what is the url?
	// is logo displayed?
	// method coming from common action
	public void newUserRegistrationPageValidation() {
		pause(3);
		elementDisplayed(logo);
		verifyTitle(driver, "CMS Enterprise Portal");
		verifyCurrentUrl(driver, "https://portal.cms.gov/portal/");
		elementDisplayed(newUserRegistration);
		verifyTextOfTheWebElement(newUserRegistration, "New User Registration");
		clickElement(newUserRegistration);
		pause(3);
		verifyTitle(driver, "CMS Enterprise Portal - New User Registration");
		verifyCurrentUrl(driver, "https://portal.cms.gov/portal/newuserregistration");
	}

	// Here We used User ID field
	// getAttribute() actually give the value of the Attribute, not common
	// raw use, in next method we will use from common action
	public void use_of_getAttribute_method () {
		elementDisplayed(userId);
		pause(4);
		// 1 example is enough
		String ml = driver.findElement(By.xpath("//input[contains(@id, 'cms-login-u')]")).getAttribute("maxlength");
		String ph = driver.findElement(By.xpath("//input[@id='cms-login-userId']")).getAttribute("placeholder");
		System.out.println("The value of the maxlength attribute is: " + ml);
		System.out.println("The value of the placeholder attribute is: " + ph);
		
		// attribute er common action in next class
		// Assert in details
	
	}
	
	// use of clear()
	public void use_of_clear_in_login() {
		elementDisplayed(userId);
		inputText(userId, "February 2024 QA Bootcamp");
		pause(3);
		clearTextFromTheField(userId);
		pause(3);
		inputText(userId, "February 2024 QA Evening Bootcamp");
		pause(3);
		elementDisplayed(password);
		inputText(password, "Abc@123a");
		pause(3);
		clearTextFromTheField(password);
		inputText(password, "Abc@123abcd");
		pause(3);
		elementSelected(checkBox);
		clickElement(checkBox);
		pause(3);
		elementEnabled(loginButton); // used here
		clickElement(loginButton);
		pause(3);
	}
	
	// use of Keys.ENTER, most common then [raw code]
	public void use_of_sendKeys_method_then_click_by_enter_key_of_the_laptop_01 () {
		pause(3);
		driver.findElement(By.name("user-d")).sendKeys("Tofael", Keys.ENTER);
		pause(3);
	}
	
	// use of Keys.ENTER, common method used
	public void use_of_sendKeys_method_then_click_by_enter_key_of_the_laptop_02 () {
		elementDisplayed(userId);
		inputTextThenClickEnter(userId, "February 2024 QA Bootcamp"); // here used
		pause(3);
	}
	
	// use of Keys.RETURN , common method used
	public void use_of_sendKeys_method_then_click_by_return_key_of_the_laptop () {
		elementDisplayed(userId);
		inputTextThenClickEnter(userId, "February 2024 QA Bootcamp");
		pause(3);
		elementDisplayed(password);
		inputTextThenClickReturn(password, "Abc@1234"); // here used
		pause(3);
		// below line is comment out becuase Return button showing normal flow the application
//		elementSelected(checkBox);
//		clickElement(checkBox);
//		pause(3);
//		elementEnabled(loginButton); // used here
//		clickElement(loginButton);
//		pause(3);
	}
	
	// use of Keys.TAB, common method used
	public void use_of_sendKeys_method_then_click_by_tab_key_of_the_laptop () {
		elementDisplayed(userId);
		inputTextThenClickTab(userId, "Morning Batch"); // the focus will go to next input
		pause(3);

	}
	
	// use of navigate()
	// mostly interview question, never used in framework or in real time environment
	public void use_of_navigate_method () {
		pause(3);
		driver.navigate().to("https://www.ebay.com");
		pause(3);
		driver.navigate().back();
		pause(3);
		driver.navigate().forward();
		pause(3);
		driver.navigate().refresh();
		pause(3);
		
	}
	
	// Very very important for use in framework and also a interview question
	public void use_of_mouse_hoverAction_on_ourLocations () {
		pause(3);
		// below process we don't use in framework
		driver.navigate().to("https://www.mountsinai.org/");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20)); 
		// use of normalize-space(text()) as an xpath is new here, please have a look
		WebElement ourLocations = driver.findElement(By.xpath("//a[normalize-space(text()) = 'Our Locations' and @class='hidden-xs dropdown']"));
		Actions actions = new Actions(driver);
		actions.moveToElement(ourLocations).build().perform();
		pause(3);
	}
		
	// alternate of click()
	// very very  Important interview question + they ask you to write the code in MS word
	// JavaScriptExecutor is an Interface that helps to execute JavaScript through Selenium Webdriver. 
	// so, practice it by paper pen, then in ms word
	// login button used
	public void alternate_of_click_method() {
		WebElement loginButton = driver.findElement(By.id("cms-login-submit")); 
		// above line, we can also use it at the beginning, no need to show it here
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", loginButton); // memorize the content
		// arguments[0] means, find the web element of index 0, means first occurrence
		pause(3);
	}
	
	// how to input text inside a field by JavascriptExecutor, alternate of sendKeys()
	// user id field is used to input text
	public void alternate_of_send_keys_method() {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].value = 'Mohammad Sharkar'", userId);
		pause(3);
	}
	
	// login process by JavascriptExecutor
	// alternative of click(), sendKeys() is used
	public void login_process_by_JavascriptExecutor(){
		JavascriptExecutor js = (JavascriptExecutor) driver;
		elementDisplayed(userId);		
		js.executeScript("arguments[0].value = 'February 2024 QA' ", userId);
		pause(3);
		elementDisplayed(password);
		js.executeScript("arguments[0].value = 'OnthrallTest@1234' ", password);
		pause(3);
		elementSelected(checkBox);
		js.executeScript("arguments[0].click()", checkBox);
		pause(3);
		elementEnabled(loginButton);
		verifyTextOfTheWebElement(loginButton, "Login");
		js.executeScript("arguments[0].click()", loginButton);
		pause(3);
	}
	
	// it will fail, because selenium can't handle hidden element
	public void how_to_handle_hidden_element_by_regular_selenium_method() {
		pause(3);
		driver.navigate().to("https://www.letskodeit.com/practice");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		pause(3);
		// identify the 'Hide' element and click on it [line 548]
		// The search field will be disappeared, but we can pass value on it, as we got the info before
		driver.findElement(By.id("hide-textbox")).click();
		pause(3);
		// identify element and set/input text or value (line 551) by selenium
		driver.findElement(By.xpath("//input[@id='displayed-text']")).sendKeys("August 2023");
		// it will fail by below error message
		// org.openqa.selenium.ElementNotInteractableException: element not interactable
		// whenever you find element not interactable in console, that is for sure a hidden element		
	}
	
	// it will pass
	public void how_to_handle_hidden_element_by_javascriptExecutor() {
		pause(3);
		driver.navigate().to("https://www.letskodeit.com/practice");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		pause(3);
		// identify the 'Hide' element and click on it [line 548]
		// The search field will be disappeared, but we can pass value on it, as we got the info before
		// we can click by regular selenium method like 520
		WebElement hide = driver.findElement(By.id("hide-textbox"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", hide); 
		pause(3);
		// identify element and set/input text or value (line 551) by selenium
		// identify element and set/input text or value by JavascriptExecutor
		WebElement searchField = driver.findElement(By.xpath("//input[@id='displayed-text']"));
		js.executeScript("arguments[0].value = 'February 2024' ", searchField);	
		
		
		// You can really know what was the text written by the JavascriptExecutor		
		// Not important and not related
		// Extra code, alternative of  getText() 
		// Extra not related to hidden elements and not important
		// To find out what you send as text, not necessary for this scenario
		// Just save the below code for future reference
		String s = (String) js.executeScript("return document.getElementById('displayed-text').value");
		System.out.print("Value entered in hidden field: " + s + "\n");
		
		// Not important
		// How to get title of the page by JavaScript
		// How to read a JavaScript variable in Selenium WebDriver?
		// How to getTitle by Javascript, 
		String sText = js.executeScript("return document.title;").toString(); // fetching page title by javascript
		System.out.println("The title of the Page is: "+sText);	
		
		// Not related with this test
		// How to refresh by Javascript, 
		js.executeScript("history.go(0)"); // To do refresh by Javascript
		
	}
	
		


	
	
	
	
	
 
}
