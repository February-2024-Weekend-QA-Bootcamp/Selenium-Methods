package pages;

import java.awt.AWTException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import baseUtil.BaseClass;

public class HomePageTest extends BaseClass {
	
	// The test executed based on alphabetical order, if no priority given
	// (enabled = true) means The test case is not disable, it can run
	// (enabled = false) means The test case is disable, it is not running
	// priority = 1 means, this test case will run first, 2 means second .... ... so on
	
	@Test (enabled = false, priority = 3)
	public void clickLoginButtonTest() throws InterruptedException {
		homePage.clickLoginButton();
	}
	
	@Test (enabled = false, priority = 1)
	public void clickUserIdTest() {
		homePage.clickUserId();
	}
	
	@Test (enabled = false, priority = 2)
	public void clickPasswordTest() {
		homePage.clickPassword();
	}
	
	@Test (enabled = false)
	public void clickNewUserRegistrationTest() {
		homePage.clickNewUserRegistration();
	}
	
	@Test (enabled = false)
	public void clickLogoTest() {
		homePage.clickLogo();
	}
	
	// Test for implicitly wait and it shows No such element exception
	// org.openqa.selenium.NoSuchElementException: no such element: Unable to locate element
	@Test(enabled = false)
	public void clickWrongNewUserIdTest() {
		homePage.clickWrongNewUserRegistration();
	}
	
	// This test case will fail, when you remove Pagefactory class from code form HomePage to test this
	// When PageFactory class is absent, you will find NullPointerException
	// Exception is: java.lang.NullPointerException: Cannot invoke "org.openqa.selenium.WebElement.click()" 
	// because "element" is null	
	@Test (enabled = false)
	public void nullPointerExceptionTest() throws InterruptedException {
		homePage.clickNewUserRegistration();
	}
		
	@Test(enabled = false)
	public void clickUnlockTest() throws InterruptedException {
		homePage.clickUnlock();
	}
	
	@Test(enabled = false)
	public void inputTextInUserIdFieldTest() {
		homePage.inputTextInUserIdField();
	}
	
	@Test(enabled = false)
	public void inputTextInUserIdAndPasswordFieldThenIAgreeThenClickLoginButtonTest() throws InterruptedException {
		homePage.inputTextInUserIdAndPasswordFieldThenIAgreeThenClickLoginButton();
	}
	
	@Test(enabled = false)
	public void useOfByClassInLoginTest() {
		homePage.useOfByClassInLogin();
	}
	
	@Test(enabled = false)
	public void use_of_linkText_as_locator_in_forgot_userId_hyperlink_test() {
		homePage.use_of_linkText_as_locator_in_forgot_userId_hyperlink();
	}
	
	@Test(enabled = false)
	public void use_of_partialLinkText_as_locator_in_forgot_passowrd_hyperlink_test() {
		homePage.use_of_partialLinkText_as_locator_in_forgot_passowrd_hyperlink();
	}
	
	@Test(enabled = false)
	public void why_we_use_cssSelector_as_locator_in_logo_test () {
		homePage.why_we_use_cssSelector_as_locator_in_logo ();
	}
	
	@Test(enabled = false)
	public void role1_use_of_cssSelector_by_class_name_value_test() {
		homePage.role1_use_of_cssSelector_by_class_name_value();
	}
	
	@Test(enabled = false)
	public void role2_use_of_cssSelector_by_id_value_test() {
		homePage.role2_use_of_cssSelector_by_id_value();
	}
	
	@Test(enabled = false)
	public void role3_use_of_cssSelector_by_compund_class_name_value_test () {
		homePage.role3_use_of_cssSelector_by_compund_class_name_value ();
	}
	
	@Test(enabled = false)
	public void role4_use_of_cssSelector_by_attribute_and_its_value_test () {
		homePage.role4_use_of_cssSelector_by_attribute_and_its_value ();
	}
	
	@Test(enabled = false)
	public void role5_use_of_cssSelector_by_class_name_value_and_attribute_and_its_value_test() {
		homePage.role5_use_of_cssSelector_by_class_name_value_and_attribute_and_its_value();
	}
	
	@Test(enabled = false)
	public void role6_use_of_cssSelector_by_id_value_and_attribute_and_its_value_test() {
		homePage.role6_use_of_cssSelector_by_id_value_and_attribute_and_its_value();
	}
	
	@Test(enabled = false)
	public void use_of_tagName_as_locator_test() {
		homePage.use_of_tagName_as_locator();
	}
	
	@Test(enabled = false)
	public void use_of_isDisplayed_test() {
		homePage.use_of_isDisplayed();
	}
	
	@Test(enabled = false)
	public void use_of_isDisplayed_in_login_test() {
		homePage.use_of_isDisplayed_in_login();
	}
	
	@Test(enabled = false)
	public void use_of_isEnabled_in_login_test() {
		homePage.use_of_isEnabled_in_login();
	}
	
	@Test(enabled = false)
	public void use_of_isSelected_in_login() {
		homePage.use_of_isSelected_in_login();
	}
	
	@Test(enabled = false)
	public void logoDisplayed01Test() {
		homePage.logoDisplayed01();
	}
	
	@Test(enabled = false)
	public void logoDisplayed02Test() {
		homePage.logoDisplayed02();
	}

	@Test(enabled = false)
	public void logoDisplayed03Test() {
		homePage.logoDisplayed03();
	}
	
	@Test(enabled = false)
	public void logoDisplayed04Test() {
		homePage.logoDisplayed04();
	}
	
	
	
	@Test(enabled = false)
	public void getMethodsOfThePageTest() {
		homePage.getMethodsOfThePage();
	}
	
	@Test(enabled = false)
	public void newUserRegistrationPageValidationTest() {
		homePage.newUserRegistrationPageValidation();
	}
	
	@Test(enabled = false)
	public void use_of_getAttribute_method_Test () {
		homePage.use_of_getAttribute_method();
	}
	
	@Test(enabled = false)
	public void use_of_clear_in_login_test() {
		homePage.use_of_clear_in_login();
	}
	
	@Test(enabled = false)
	public void use_of_sendKeys_method_then_click_by_enter_key_of_the_laptop_test_01 () {
		homePage.use_of_sendKeys_method_then_click_by_enter_key_of_the_laptop_01();
	}
	
	@Test(enabled = false)
	public void use_of_sendKeys_method_then_click_by_enter_key_of_the_laptop_test_02 () {
		homePage.use_of_sendKeys_method_then_click_by_enter_key_of_the_laptop_02();
	}
	
	@Test(enabled = false)
	public void use_of_sendKeys_method_then_click_by_return_key_of_the_laptop_test () {
		homePage.use_of_sendKeys_method_then_click_by_return_key_of_the_laptop();
	}
	
	@Test(enabled = false)
	public void use_of_sendKeys_method_then_click_by_tab_key_of_the_laptop_test () {
		homePage.use_of_sendKeys_method_then_click_by_tab_key_of_the_laptop();
	}
	
	@Test(enabled = false)
	public void use_of_navigate_method_test () {
		homePage.use_of_navigate_method ();
	}
	
	@Test(enabled = false)
	public void set_a_specific_size_for_window() {
		homePage.set_a_specific_size_for_window();
	}
	
	@Test(enabled = false)
	public void use_of_mouse_hoverAction_on_ourLocations_test () {
		homePage.use_of_mouse_hoverAction_on_ourLocations ();
	}
	
	@Test(enabled = true)
	public void mouseHoverActionOnAboutUs() {
		homePage.mouseHoverActionOnAboutUs();
	}
	
	@Test(enabled = false)
	public void alternate_of_click_method_test() {
		homePage.alternate_of_click_method();
	}
	
	@Test(enabled = false)
	public void alternate_of_send_keys_method_test() {
		homePage.alternate_of_send_keys_method();
	}
	
	
	@Test(enabled = false)
	public void login_process_by_JavascriptExecutor_test() {
		homePage.login_process_by_JavascriptExecutor();
	}
	
	// it will fail
	@Test(enabled = false)
	public void how_to_handle_hidden_element_by_regular_selenium_method_test() {
		homePage.how_to_handle_hidden_element_by_regular_selenium_method();
	}
	
	@Test(enabled = false)
	public void how_to_handle_hidden_element_by_javascriptExecutor_test() {
		homePage.how_to_handle_hidden_element_by_javascriptExecutor();
	}
	
	@Test(enabled = false)
	public void use_of_explicitly_wait_01_test() {
		homePage.use_of_explicitly_wait_01();
	}
	
	@Test(enabled = false)
	public void use_of_explicitly_wait_02_test() {
		homePage.use_of_explicitly_wait_02();
	}
	
	@Test(enabled = false)
	public void use_of_explicitly_wait_03_test(){
		homePage.use_of_explicitly_wait_03();
	}
	
	@Test(enabled = false)
	public void use_of_explicitly_wait_04_test(){
		homePage.use_of_explicitly_wait_04();
	}
	
	@Test(enabled = false)
	public void use_of_explicitly_wait_05_test(){
		homePage.use_of_explicitly_wait_05();
	}
	
	@Test(enabled = false)
	public void use_of_scroll_down_and_up_by_actions_class_Test () {
		homePage.use_of_scroll_down_and_up_by_actions_class();
	}
	
	
	
	@Test(enabled = false)
	public void use_of_scroll_down_and_up_by_javascriptExecutor_test () {
		homePage.use_of_scroll_down_and_up_In_A_Certain_Pixel_by_javascriptExecutor ();
	}
	
	@Test(enabled = false)
	public void use_of_scroll_down_and_scroll_up_by_robot_class () throws InterruptedException, AWTException {
		homePage.use_of_scroll_down_and_scroll_up_by_robot_class ();
	}
		
	@Test(enabled = false)
	public void scroll_into_view_the_element_01_test() {
		homePage.scroll_into_view_the_element_01();
	}
	
	@Test(enabled = false)
	public void scroll_into_view_the_element_02_test() {
		homePage.scroll_into_view_the_element_02();
	}
	
	@Test(enabled = false)
	public void web_based_alert_accept_test () {
		homePage.web_based_alert_accept();		
	}
	
	@Test(enabled = false)
	public void web_based_alert_dismiss_test () {
		homePage.web_based_alert_dismiss();		
	}
	
	@Test(enabled = false)
	public void  authentication_pop_up_test () throws InterruptedException {
		homePage. authentication_pop_up ();
	}

	@Test(enabled = false)
	public void use_of_right_click_action_test () {
		homePage.use_of_right_click_action ();
	}

	@Test(enabled = false)
	public void use_of_double_click_action_test () throws InterruptedException {
		homePage.use_of_double_click_action ();
	}
		
	@Test(enabled = false)
	public void use_of_drag_and_drop_action_test () throws InterruptedException {
		homePage.use_of_drag_and_drop_action ();
	}
	
	@Test(enabled = false)
	public void use_of_slider_action_test () {
		homePage.use_of_slider_action ();
	}
	
	@Test(enabled = false)
	public void use_of_slider_action_alternate_test () {
		homePage.use_of_slider_action_alternate ();
	}
	
	@Test(enabled = false)
	public void read_table_test () {
		homePage.read_table ();
	}
	
	@Test(enabled = false)
	public void read_any_row_of_the_table_test ()  {
		homePage.read_any_row_of_the_table ();
	}
	
	@Test(enabled = false)
	public void read_any_cell_of_a_row_of_the_table () {
		homePage.read_any_cell_of_a_row_of_the_table ();
	}
		
	
	@Test(enabled = false)
	public void switch_between_window_01_test () {
		homePage.switch_between_window_01();	
	}

	@Test(enabled = false)
	public void switch_between_window_02_test () {
		homePage.switch_between_window_02();		
	}
	
	@Test(enabled = false)
	public void switch_between_window_03_Test () {
		homePage.switch_between_window_03 ();
	}
	
	
	
	@Test(enabled = false, priority = 3, groups = {"functionalTest", "sanityTest", "smokeTest", "regressionTest"})
	public void getMethodsOfThePage03Test() {
		homePage.getMethodsOfThePage03();
	}
	 
	@Test(enabled = false, priority = 1, groups = {"regressionTest"})
	public void getMethodsOfThePage04Test() {
		homePage.getMethodsOfThePage04();
	}
	
	@Test(enabled = false, priority = 2, groups = {"functionalTest", "sanityTest"})
	public void getMethodsOfThePage05Test() {
		homePage.getMethodsOfThePage05();
	}
	
	@Test(enabled = false)
	public void use_of_expectedExceptions01Test () {
		homePage.use_of_expectedExceptions01();
	}
	
	@Test(enabled = false, expectedExceptions = ArithmeticException.class)
	public void use_of_expectedExceptions02Test () {
		homePage.use_of_expectedExceptions02();
	}
	
	// It will fail as element is not found
	@Test(enabled = false)
	public void use_of_expectedExceptions03Test () {
		homePage.use_of_expectedExceptions03();
	}
	
	@Test(enabled = false, expectedExceptions = org.openqa.selenium.NoSuchElementException.class)
	public void use_of_expectedExceptions04Test () {
		homePage.use_of_expectedExceptions03();
	}
	
	@Test(enabled = false)
	public void new_user_registration_button_enabled_test(){
		homePage.new_user_registration_button_enabled();
	}
	// use of dependsOnMethods
	// we have to keep the above method true to run this
	// change the new_user_registration_button_enabled method to fail 
	// and see the above method skipped as it depends on new_user_registration_button_enabled
	
	
	@Test(enabled = false, dependsOnMethods = "new_user_registration_button_enabled_test")
	public void newUserRegistrationButtonClickTest() {
		homePage.newUserRegistrationButtonClick();
	}
	
	@Test(enabled = false)
	public void skipHomePageTitle01Test() {
		homePage.skipHomePageTitle01();
	}
	
	@Test(enabled = false)
	public void skipHomePageTitle02Test() {
		homePage.skipHomePageTitle02();
	}
	
	// use of invocation count, when? -- if you know some test cases fail for no reason
	// and then you fix it, you can run more than one time time by invocation count	
	@Test(enabled = false, invocationCount = 5, timeOut = 10000)
	public void getMethodsOfThePage06Test() {
		homePage.getMethodsOfThePage06();
	}
	
	// use of threadPoolSize
	//TODO Is the threadPoolSize working? No, NEED TO RESOLVED, 
	// may be working as multi threaded, can't see, need to be make sure
	// Ask Nasir to solve it
	@Test(enabled = false, invocationCount = 6, threadPoolSize = 3, timeOut = 10000)
	public void getMethodsOfThePage07Test() {
		homePage.getMethodsOfThePage07();
	}
	
	// Below we wrote the code directly in test cases, you will not find any code in HomePage
	// interview question: what are the alternative of click(), 
	// but they are not expecting first 2 answer, they are looking for javascriptExecutor
	// alternate of click()
	@Test(enabled = false)
	public void alternate_of_click_method_in_loginButtonTest01() throws InterruptedException {
		driver.findElement(By.id("cms-login-submit")).sendKeys(Keys.ENTER);
		Thread.sleep(3000);
	}
	
	// alternate of click()
	@Test(enabled = false)
	public void alternate_of_click_method_in_loginButtonTest02() throws InterruptedException {
		driver.findElement(By.id("cms-login-submit")).sendKeys(Keys.RETURN);
		Thread.sleep(3000);
	}
	
	// Important interview question + they ask you to write the code in MS word
	// so, practice it by paper pen, then in ms word
	// alternate of click()
	@Test(enabled = false)
	public void alternate_of_click_method_in_loginButtonTest03() throws InterruptedException {
		WebElement loginButton = driver.findElement(By.id("cms-login-submit"));
		JavascriptExecutor js = (JavascriptExecutor) driver; // We don't need it here
		// Because JavascriptExecutor Interface is instantiated in base class, js object came form there
		js.executeScript("arguments[0].click()", loginButton);
		// arguments[0] means, find the web element of index 0, first occurrence
		Thread.sleep(4000);
	}
	
	// alternate of click()
	// "arguments[0].click()" ---> above is easy to memorize, memorize it, if you want
	// follow the above one, because you can use any kind of locator 
	// (specially xpath is difficult to create by below one)
	// don't follow this one, but if you ever see it, i hope you can recognize it
	@Test(enabled = false)
	public void alternate_of_click_method_in_loginButtonTest04() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.getElementById('cms-login-submit').click();");
		Thread.sleep(4000);
	}
	
	// this is high level, so just see, don't take them seriously
	// alternative to click an web element in many ways (never memorize, a collection of code)
	
	// Not important
	
	// alternate of click()
	@Test(enabled = false)
	public void homepageLoginButtonTest06() {
		WebElement homepageLoginButton = driver.findElement(By.xpath("//button[@id='cms-login-submit']"));
		Actions actions = new Actions(driver);
		actions.click(homepageLoginButton).perform();
	}
	
	// Not important
	// alternate of click()
	@Test(enabled = false)
	public void homepageLoginButtonTest07() {
		WebElement homepageLoginButton = driver.findElement(By.xpath("//button[@id='cms-login-submit']"));
		Actions actions = new Actions(driver);
		actions.moveToElement(homepageLoginButton).click().perform();
	}
	
	// Not important
	// alternate of click()
	@Test(enabled = false)
	public void homepageLoginButtonTest08() {
		WebElement homepageLoginButton = driver.findElement(By.xpath("//button[@id='cms-login-submit']"));
		Actions actions = new Actions(driver);
		actions.clickAndHold(homepageLoginButton).release().perform();
	}
	
	// Not important
	// alternate of click()
	@Test(enabled = false)
	public void homepageLoginButtonTest09() {
		WebElement homepageLoginButton = driver.findElement(By.xpath("//button[@id='cms-login-submit']"));
		Actions actions = new Actions(driver);
		actions.sendKeys(homepageLoginButton, Keys.RETURN).perform();
	}
	
	// Sets the amount of time to wait for an asynchronous script to finish execution before throwing an error. 
	// not important at all
	@SuppressWarnings("deprecation")
	@Test(enabled = false)
	public void use_of_set_script_timeout_for_window() {
		driver.manage().timeouts().setScriptTimeout(Duration.ofSeconds(15));
		// setScriptTimeout () method deprecated, so giving you warning, this method is going to be out from selenium
        // you use @SuppressWarnings("deprecation")
		driver.get("https://www.ebay.com");	
	}
		
	 
	 

}
