package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.SkipException;

import com.github.dockerjava.api.model.Driver;

// new, you have to manually write it to get access of common method
// this is possible when they are static in nature, * means all
// This is called static import
import static common.CommonActions.*;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.List;
import java.util.Set;

public class HomePage {
	public WebDriver driver;
	public WebDriverWait wait;
	JavascriptExecutor js;
	Actions actions;
	org.openqa.selenium.Dimension dimension;
	
	// parameterized constructor initialized when class in instantiated [object created]
	public HomePage(WebDriver driver) {
		this.driver = driver;
		// PageFactory class help to instantiate WebElements
		// Important interview question
		PageFactory.initElements(driver, this);
		actions = new Actions(driver);
		js = (JavascriptExecutor)driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
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
	}
	
	// Learning Assertion
	public void logoDisplayed01() {
		elementDisplayed(logo); // Actual outcome from selenium method
		Assert.assertTrue(true); // Expected outcome
	}
	
	public void logoDisplayed02() {
		elementDisplayed(logo); // Actual Result or outcome which doesn't match with your below expectation
		Assert.assertTrue(false); // Expected Result // java.lang.AssertionError: expected [true] but found [false]
		// Although the outcome is true, but because of difference between expected vs actual is not same, the test case failed
	}
	
	public void logoDisplayed03() {
		elementDisplayed(logo); // Actual outcome from selenium method
		// Assert.assertTrue(false, "Expected vs actual doesn't match"); // Expected outcome
		// Assert.assertTrue(true, "Application Logo is not displayed"); // This error message will appear if failed
		Assert.assertFalse(false, "Application Logo is not displayed"); // false false means true		
	}
	
	public void logoDisplayed04() {
		elementDisplayed(logo); // Actual outcome from selenium method
		Assert.assertFalse(true, "Expected vs actual doesn't match"); // false false means true, False true means false, so failed		
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
	
	// findElements need to do before that
	// dropdown feature is showed in forgot User id page
	
	public void set_a_specific_size_for_window() {
		pause(3);
		// Will get the size of cms window
		System.out.println("The size of the CMS screen is: "+ driver.manage().window().getSize());
		dimension = new org.openqa.selenium.Dimension(1000, 700);
		driver.manage().window().setSize(dimension);
		pause(3);
		System.out.println("The size of the set CMS screen is: "+ driver.manage().window().getSize());
		
		// Extra not related to this method, although you can skip
		pause(3);
		driver.navigate().to("https://www.cvs.com");
		pause(3);
		System.out.println("The size of the set CVS screen is: "+ driver.manage().window().getSize());
		driver.manage().window().maximize();
		pause(3);
		System.out.println("The size of the CVS maximize screen is: "+ driver.manage().window().getSize());
		pause(3);
		driver.manage().window().setSize(dimension); // just to show again the set size
		pause(3);
		System.out.println("The size of the set CVS screen is: "+ driver.manage().window().getSize());
		pause(3);;
		driver.manage().window().fullscreen();
		pause(3);
		System.out.println("The size of the CVS full screen is: "+ driver.manage().window().getSize());	
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
		// Actions actions = new Actions(driver);
		actions.moveToElement(ourLocations).build().perform();
		pause(3);
	}
	
	// Use of findElements()
	// Tough, try your best
	public void mouseHoverActionOnAboutUs() {
		pause(3);
		driver.navigate().to("https://www.mountsinai.org/");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20)); 
		// WebElement aboutUs = driver.findElement(By.xpath("(//a[normalize-space(text())='About Us'])[1]")); // a nex xpath is used
		WebElement aboutUs = driver.findElement(By.xpath("//a[normalize-space(text()) = 'About Us']//preceding-sibling::i")); // a nex xpath is used
		pause(3);
		actions.moveToElement(aboutUs).build().perform(); // used for mouse hover action
		pause(3); // Until here, we did it before
		
		// Use of findElements()
		List<WebElement>listOfAboutUs = driver.findElements(By.xpath("(//a[normalize-space(text())='About Us'])[1]//following-sibling::div//child::div//child::div"));
		for(int i = 0; i<listOfAboutUs.size(); i++) {
			System.out.println(listOfAboutUs.get(i).getText());
		}
		
		
		
		
	}
		
	// alternate of click()
	// very very  Important interview question + they ask you to write the code in MS word
	// JavaScriptExecutor is an Interface that helps to execute JavaScript through Selenium Webdriver. 
	// so, practice it by paper pen, then in ms word
	// login button used
	public void alternate_of_click_method() {
		WebElement loginButton = driver.findElement(By.id("cms-login-submit")); 
		// above line, we can also use it at the beginning, no need to show it here
		// JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", loginButton); // memorize the content
		// arguments[0] means, find the web element of index 0, means first occurrence
		pause(3);
	}
	
	// how to input text inside a field by JavascriptExecutor, alternate of sendKeys()
	// user id field is used to input text
	public void alternate_of_send_keys_method() {
		// JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].value = 'Mohammad Sharkar'", userId);
		pause(3);
	}
	
	// login process by JavascriptExecutor
	// alternative of click(), sendKeys() is used
	public void login_process_by_JavascriptExecutor(){
		// JavascriptExecutor js = (JavascriptExecutor) driver;
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
		// JavascriptExecutor js = (JavascriptExecutor) driver;
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
	
	// very very important
	// when the web element always failed in test, use explicitly wait, 
	// in this web site doesn't have that complex scenario
	// "unlock" web element 
	// using visibilityOfElementLocated() method , Number one
	// This is a very common scenario in industry to use explicitly wait
	public void use_of_explicitly_wait_01() {
		pause(3);
		wait.until(ExpectedConditions.visibilityOfElementLocated(unlock)).click();
		pause(4);
	}
	
	// unlock webElement
	// using elementToBeClickable() method, number two
	// Please see line 596, how to write by By class
	public void use_of_explicitly_wait_02(){
		pause(3);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(), 'Password')]"))).click();
		pause(4);
	}
	
	// userId webElement
	// using visibilityOf() method, number three
	public void use_of_explicitly_wait_03(){
		pause(3);
		wait.until(ExpectedConditions.visibilityOf(userId)).isDisplayed(); // here userId is webElement type
		pause(4);
	}
	
	// Try to remember this above 3 conditions name for interview, most time they asked it
	
	// Not important, you can use it to practice
	// "unlock" web element 
	// using presenceOfElementLocated() method
	public void use_of_explicitly_wait_04(){
		pause(3);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(text(), 'Password')]"))).click();
		pause(4);
	}
	
	// Not important, you can use it to practice
	// "Login Button" web element
	// using textToBePresentInElement() method
	// this is not a clickable method, just to recognize the web element
	public void use_of_explicitly_wait_05(){
		pause(3);
		boolean outcome = wait.until(ExpectedConditions.textToBePresentInElement(loginButton, "Login"));
		System.out.println(outcome);
		pause(4);
	}
	
	// important interview question
	// 1st way: Scroll by Actions class
	// scroll bottom and then top
	public void use_of_scroll_down_and_up_by_actions_class () {
		pause(5);
		// for Scroll Down using Actions class, to go at the bottom of the page
		actions.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
		pause(3);
		// for Scroll Up using Actions class at the top of the page
		actions.keyDown(Keys.CONTROL).sendKeys(Keys.HOME).perform();
		pause(3);
		// instead of END and HOME, we can use Keys.UP or Keys.Down
		// But it doesn't change much but the test case passes, we will not use them
	}
	
	// important interview question
	// 2nd way: Scroll by javascriptExecutor
	// scroll in a certain position (not at the bottom or up)
	public void use_of_scroll_down_and_up_In_A_Certain_Pixel_by_javascriptExecutor () {
		pause(6);
		// This will scroll down the page by 1000 pixel vertically
		// here 0 is x axis, 1000 y axis
		// you choose your pixel accordingly to reach to that web element
		js.executeScript("window.scrollBy(0, 1000)", "");
		// You can change the value to any pixel, and put your own to see the web element you wanna test
		pause(6);
		js.executeScript("window.scrollBy(0, -1000)", ""); // scroll up till 1000px, but not necessary based on your test
		// minus when it goes opposite of down
		pause(6);
	}
	
	// not important, just to know
	public void use_of_scroll_down_and_scroll_up_by_robot_class () throws InterruptedException, AWTException {
		// For some reason, they are not going completely Up or Down
		Robot robot = new Robot();
		// Scroll Down using Robot class
		robot.keyPress(KeyEvent.VK_PAGE_DOWN); // Constant for the PAGE_DOWN virtual key.
		robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
		pause(3);
		// Scroll Up using Robot class
        robot.keyPress(KeyEvent.VK_PAGE_UP); // Constant for the PAGE_UP virtual key. 
        robot.keyRelease(KeyEvent.VK_PAGE_UP);
        pause(3);		
	}
	
	// scroll Into View The Element
	// This is very very important, standard interview question
	// This is better to use
	public void scroll_into_view_the_element_01() {
		pause(3);
		WebElement element = driver.findElement(By.linkText("Learn more about Enterprise Portal")); 
		js.executeScript("arguments[0].scrollIntoView(true)", element);
		pause(4);
		js.executeScript("arguments[0].click()", element);
		pause(5);
	}

	// Scroll till the 'Enterprise Portal' header
	// because the scroll going more down for above
	public void scroll_into_view_the_element_02() {
		pause(3);
		WebElement enterprisePortal = driver.findElement(By.xpath("//h1[text()='Enterprise Portal']")); 
		WebElement element = driver.findElement(By.linkText("Learn more about Enterprise Portal")); 
		js.executeScript("arguments[0].scrollIntoView(true)", enterprisePortal);
		pause(4);
		js.executeScript("arguments[0].click()", element);
		pause(5);
	}
	
	// very very important for interview
	public void web_based_alert_accept () {
		pause(4);
		driver.get("http://softwaretestingplace.blogspot.com/2017/03/javascript-alert-test-page.html");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("//button[contains(text(), 'Try it')]")).click();
		pause(4);
		Alert alert = driver.switchTo().alert();
		pause(3);
		System.out.println("The text present in the alert is: " + alert.getText());
		alert.accept(); // will click on OK button
		pause(3);
		// line 717, not part of the accept function, 
		// we just added to know about, the text is present in the alert or not,
		// also if you use it after 718, it might not retrieve the text							
	}
	
	public void web_based_alert_dismiss () {
		pause(4);
		driver.get("http://softwaretestingplace.blogspot.com/2017/03/javascript-alert-test-page.html");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("//button[contains(text(), 'Try it')]")).click();
		pause(4);
		Alert alert = driver.switchTo().alert();
		pause(3);
		System.out.println("The text present in the alert is: " + alert.getText());
		alert.dismiss(); // will click on Cancel button
		pause(3);						
	}
	
	// Only important for interview
	public void authentication_pop_up (){
		pause(3);	
		String userName = "admin";
		String password = "admin";
		// original one is: "https://the-internet.herokuapp.com/basic_auth";
		// Updated one is: "https://admin:admin@the-internet.herokuapp.com/basic_auth";
		String url = "https://" + userName + ":" + password + "@" + "the-internet.herokuapp.com/basic_auth";
		driver.get(url);
		pause(3);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		pause(3);
		
		// The below part is not part of this test
		// identify and get text after authentication of pop up
		String t = driver.findElement(By.tagName("p")).getText(); // we use tag name as a locator in our course
		System.out.println("The Text is: " + t);
		Assert.assertEquals(t, "Congratulations! You must have the proper credentials.");
	}
		
	
	// only important for interview
	public void use_of_right_click_action() {
		pause(3);
		driver.get("https://demo.guru99.com/test/simple_context_menu.html");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		WebElement rcButton = driver.findElement(By.xpath("//span[contains(text(), 'right click me')]"));
		actions.moveToElement(rcButton).contextClick().build().perform(); // right click action
		pause(3);
		
		// From Line 775, not part of testing, just completed the scenario
		// Just keep below code, Can't find the web element for Edit at present, the line 775 is from my collection.
		// Below 2 is not relevant to right click, just doing some extra, which we know already
		// Next: I want to click on Edit link on the displayed menu options
		WebElement edit = driver.findElement(By.xpath("//span[text()='Edit']"));
		pause(3);
		edit.click(); // a regular click, not a right click
		pause(3);
		// Switch to the alert box and click on OK button
		Alert alert = driver.switchTo().alert();
		System.out.println("\nAlert Text:" + alert.getText());
		alert.accept();
		pause(3);	
		
	}
	
	// only important for interview
	public void use_of_double_click_action() {
		pause(3);
		driver.get("https://demo.guru99.com/test/simple_context_menu.html");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		pause(3);
		WebElement dcButton = driver.findElement(By.xpath("//button[text()='Double-Click Me To See Alert']"));
		actions.doubleClick(dcButton).build().perform();
		pause(3);
		// Not part of the double click action
		// Switch to the alert box and click on OK button
		Alert alert = driver.switchTo().alert();
		System.out.println("\nAlert Text:" + alert.getText());
		alert.accept();
		pause(3);		
	}
	
	// not important
	public void use_of_drag_and_drop_action () {
		pause(3);
		driver.get("https://demo.guru99.com/test/drag_drop.html");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// Element which needs to drag (Bank)
		WebElement sourceLocator = driver.findElement(By.xpath("//a[text()=' BANK ']")); // Web element of the Bank button, it will be dragged
		// Element where need to be dropped.(In 'Account' field of debit side)
		WebElement targetLocator = driver.findElement(By.xpath("//ol[@id='bank']")); // and it will be dropped here
		// We Use Actions class for drag and drop.
		actions.dragAndDrop(sourceLocator, targetLocator).build().perform();
		pause(3);
	}
	
	// not important
	public void use_of_slider_action () {
		pause(3);	
		driver.get("https://demoqa.com/slider/");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// Retrieve WebElemnt 'slider' to perform mouse hover
		// This is the field where volume is increased
		WebElement slider = driver.findElement(By.cssSelector("input.range-slider.range-slider--primary"));
		// Move mouse to x offset 50 i.e. in horizontal direction
		pause(3);
		// to test the slider is working or not
		// dragAndDropBy (element, int xoffset, int yoffset)
		actions.dragAndDropBy(slider, 50, 0).build().perform(); 
		// learn from here, 50 is in pixel which might not match with real volume change, real volume 60
		pause(3);
		// slider.click();
		System.out.println("Moved slider in horizontal directions");
	}
	
	// not important (alternate), also tough
	public void use_of_slider_action_alternate () {
		pause(3);
		driver.get("https://demoqa.com/slider/");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// Retrieve WebElemnt 'slider' to perform mouse hover
		// This is the field where volume is increased
		WebElement slider = driver.findElement(By.cssSelector("input.range-slider.range-slider--primary")); 
		// Move mouse to x offset 65 i.e. in horizontal direction
		pause(3);
		// More tough than above
		actions.clickAndHold(slider);
		pause(3);
		actions.moveByOffset(65, 0).build().perform(); // pixel 65, real volume 63
		pause(3);
		System.out.println("Moved slider in horizontal directions");
	}
	
	// How to read the content of a Table 
	public void read_table () {
		pause(5);	
		driver.get("https://www.amazon.com/");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		pause(5);	
		// Scrolled to the end of page
		actions.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
		pause(5);	
		// WebElement table = driver.findElement(By.tagName("table")); // tag as a locator
		WebElement table = driver.findElement(By.cssSelector("table.navFooterMoreOnAmazon"));
		System.out.println(table.getText());
		pause(5);		
	}
	
	// How to read the row of a Table 
	public void read_any_row_of_the_table () {
		pause(5);	
		driver.get("https://www.amazon.com");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		pause(5);	
		actions = new Actions(driver); 
		actions.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
		pause(5);	
		WebElement row = driver.findElement(By.cssSelector("table.navFooterMoreOnAmazon tr:nth-child(1)"));
		System.err.println(row.getText());
		pause(5);
	}
	
	// How to read any cell of a row of the Table 
	public void read_any_cell_of_a_row_of_the_table () {
		pause(5);	
		driver.get("https://www.amazon.com");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		pause(5);	
		//actions = new Actions(driver); 
		actions.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
		pause(5);
		WebElement cell = driver.findElement(By.cssSelector("table.navFooterMoreOnAmazon tr:nth-child(1) td:nth-child(7)"));
		// WebElement cell = driver.findElement(By.tagName("table tr:nth-child(1) td:nth-child(7)")); // Not working
		System.out.println(cell.getText());
		pause(3);
	}
	
	public void switch_between_window_01 () {
		pause(3);
		String parentWindow = driver.getWindowHandle();
		System.out.println("Parent Window ID: " + parentWindow + "\n");
		pause(3);
		WebElement enterprisePortal = driver.findElement(By.xpath("//h1[text()='Enterprise Portal']")); 
		WebElement element = driver.findElement(By.linkText("Learn more about Enterprise Portal")); 
		js.executeScript("arguments[0].scrollIntoView(true)", enterprisePortal);
		pause(4);
		js.executeScript("arguments[0].click()", element);
		pause(5);
		Set<String> allWindowHandles = driver.getWindowHandles();
		System.out.println("Total Windows Opened: " + allWindowHandles.size());
		// Extract Parent and child window from all window handles
		String parent = (String)allWindowHandles.toArray()[0];
		String child = (String)allWindowHandles.toArray()[1];
		System.out.println("Parent Window ID: " + parent + "\n");
		System.out.println("Child1 Window ID: " + child + "\n");
		// Then switch from one window to other window (parent to child) by below
		driver.switchTo().window(child);
		WebElement header = driver.findElement(By.xpath("//h1[contains(text(), 'CMS')]")); 
		WebElement subHeader = driver.findElement(By.xpath("//p[starts-with(text(), 'The Enterprise Portal is a')]")); // Here is a new xpath
		validationOfHeader(header, "CMS Enterprise Portal - Help Center");
		validationOfSubHeader(subHeader, "The Enterprise Portal is a gateway that provides access to over 50 different Centers for Medicare & Medicaid Services (CMS) healthcare-based applications. It provides the ability to request access to multiple Portal-integrated CMS applications and to launch/access those applications.");
		pause(3);		
	}
	
	// Extra lines deleted
	public void switch_between_window_02 () {
		pause(3);
		WebElement enterprisePortal = driver.findElement(By.xpath("//h1[text()='Enterprise Portal']")); 
		WebElement element = driver.findElement(By.linkText("Learn more about Enterprise Portal")); 
		js.executeScript("arguments[0].scrollIntoView(true)", enterprisePortal);
		pause(4);
		js.executeScript("arguments[0].click()", element);
		pause(5);
		Set<String> allWindowHandles = driver.getWindowHandles();
		// Extract Parent and child window from all window handles
		String parent = (String)allWindowHandles.toArray()[0];
		String child = (String)allWindowHandles.toArray()[1];
		// Then switch from one window to other window (parent to child) by below
		driver.switchTo().window(child);
		WebElement header = driver.findElement(By.xpath("//h1[contains(text(), 'CMS')]")); 
		WebElement subHeader = driver.findElement(By.xpath("//p[starts-with(text(), 'The Enterprise Portal is a')]")); // Here is a new xpath
		validationOfHeader(header, "CMS Enterprise Portal - Help Center");
		validationOfSubHeader(subHeader, "The Enterprise Portal is a gateway that provides access to over 50 different Centers for Medicare & Medicaid Services (CMS) healthcare-based applications. It provides the ability to request access to multiple Portal-integrated CMS applications and to launch/access those applications.");
		pause(3);	
	}
	
	// https://demoqa.com/browser-windows
	// https://enthrallit.com
	// https://www.amerihealth.com/
	// scroll down and find careers, then it will direct to a new page, then click "See current job openings"

	// different way for moving from child to window for different url, "Enthrall"
	public void switch_between_window_03 () {
		pause(3);	
		driver.get("https://enthrallit.com/selenium/");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		pause(3);
		
		String mainWindow = driver.getWindowHandle();
		
		// This will scroll up the page by 1000 pixel vertically
		// but we can use scrollIntoView()
		pause(3); // used to see the scroll
		js.executeScript("window.scrollBy(0,1000)", ""); // use scroll into view
		pause(3);
		
		// click on the Open Window button
		driver.findElement(By.xpath("(//button[text()='Open Window'])[1]")).click();
		pause(3);
		
		// interview question:  How you handle windows from parent to child? or how you can recognize the parent and child window
		
		// Get all window handles -- include parent + child
		// why we are using set? because we don't want duplicate, and set doesn't allow duplicate
		Set<String> allWindowHandles = driver.getWindowHandles();
		
		// for each loop, line 1284, get title and get current url is not related to this code
		for (String wh : allWindowHandles) {
			if (mainWindow.equals(wh)) {
				System.out.println("\t Parent: \t\t" + wh + "\n \t URL: \t \t" + driver.getCurrentUrl()
						+ "\n \t Title: \t \t" + driver.getTitle() + "\n");
			} else {
				driver.switchTo().window(wh);
				System.out.println("\t Child: \t\t" + wh + "\n \t URL: \t \t" + driver.getCurrentUrl()
						+ "\n \t Title: \t \t" + driver.getTitle());
			}
		}		
		
	}
		
	
	
	// regarding TestNG
	// use of groups
	public void getMethodsOfThePage03() {
		String actual = driver.getTitle();
		System.out.println("Title name: "+ actual);
		String expected = "CMS Enterprise Portal";
		Assert.assertEquals(actual, expected, "Home Page Title doesn't match ....... ");		
	}
	
	public void getMethodsOfThePage04() {
		String actual = driver.getTitle();
		System.out.println("Title name: "+ actual);
		String expected = "CMS Enterprise Portal";
		Assert.assertEquals(actual, expected, "Home Page Title doesn't match ....... ");		
	}
	
	public void getMethodsOfThePage05() {
		String actual = driver.getTitle();
		System.out.println("Title name: "+ actual);
		String expected = "CMS Enterprise Portal";
		Assert.assertEquals(actual, expected, "Home Page Title doesn't match ....... ");		
	}
	
	public void use_of_expectedExceptions01 () {
		System.out.println("We can verify whether a code throws the expected exception or not. Here it will fail");
		int i = 1/0;	
	}
	
	public void use_of_expectedExceptions02 () {
		System.out.println("We can verify whether a code throws the expected exception or not. Here it will Pass");
		int i = 1/0;	
	}
	
	public void use_of_expectedExceptions03 () {
		driver.findElement(By.id("xxs-login-submit")).click(); // cms login button
		pause(4);
	}
	
	// for test dependOnMethod()
	public void new_user_registration_button_enabled(){
		WebElement nur = driver.findElement(By.xpath("//a[contains(text(), 'New User Registration')]"));
		boolean buttonEnabled = nur.isEnabled();			
		System.out.println("Is the Button Enabled? Ans: "+ buttonEnabled);
		Assert.assertTrue(true, "The New User Registration Button is disable .....");	
	}
	
	public void newUserRegistrationButtonClick() {
		driver.findElement(By.xpath("//a[contains(text(), 'New User Registration')]")).click();
		pause(3);
		System.out.println(driver.getCurrentUrl());
	}
	
	// This test to explain the next one, it is not tested
	public void nonSkipHomePageTitleTest() {
		String expected = "CMS Enterprise Portal";
		String actual = driver.getTitle();
		System.out.println("home page title is: " + actual);
		Assert.assertEquals(actual, expected, "Home Page Title doesn't match...");	
		System.out.println("No need to skip the test");
	}	
	
	// how to handle Exception: try, catch, throw, throws, finally
	// below examples of where 'throw' is used
	// Que: How to skip a test? by throw new SkipException() method
	public void skipHomePageTitle01() {
		String expected = "CMS Enterprise Portal";
		if(expected.equals(driver.getTitle())) {
			throw new SkipException("Skipping -- as the title matches as expected");
			// if above condition is true, then no more below execution
		} else {
			System.out.println("Home Page Title doesn't match...");
		}
		System.out.println("I am out of the if else condition");
	}
	
	public void skipHomePageTitle02() {
		String expected = "      CMS Enterprise Portal"; // title will not match
		if(expected.equals(driver.getTitle())) {
			throw new SkipException("Skipping -- as the title matches as expected");
		} else {
			System.out.println("Home Page Title doesn't match...");
		}
		System.out.println("I am out of the if else condition");
	}
	
	public void getMethodsOfThePage06() {
		String actual = driver.getTitle();
		System.out.println("Title name: "+ actual);
		String expected = "CMS Enterprise Portal";
		Assert.assertEquals(actual, expected, "Home Page Title doesn't match ....... ");		
	}
	
	public void getMethodsOfThePage07() {
		String actual = driver.getTitle();
		System.out.println("Title name: "+ actual);
		String expected = "CMS Enterprise Portal";
		Assert.assertEquals(actual, expected, "Home Page Title doesn't match ....... ");	
		System.out.println("Thread: "+ Thread.currentThread().getName()); // to know which thread is running
	}
	
	

	



			
	
	
	
	
	
	
	
	
	
 
}
