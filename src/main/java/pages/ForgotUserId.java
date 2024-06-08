package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import static common.CommonActions.*;

import java.util.List;

public class ForgotUserId {
	public WebDriver driver;
	public Select select;

	public ForgotUserId(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[contains(text(), 'User I')]")
	WebElement forgetUserid;
	
	@FindBy(xpath = "//h1[contains(text(), 'Forgot User ID')]")
	WebElement forgotUserIdHeader;
	
	@FindBy(xpath = "//p[contains(text(), 'Please e')]")
	WebElement forgotUserIdSubHeader;
		
	@FindBy(xpath = "//p[contains(@id, 'cms-allfields-req')]")
	WebElement allFieldsRequired;
	
	@FindBy(xpath = "//input[contains(@id, 'cms-forgotid-fi')]")
	WebElement firstName;
	
	@FindBy(xpath = "//input[@name='cms-forgotid-lastName']")
	WebElement lastName;
	
	@FindBy(xpath = "//select[@name='cms-forgotid-birthDate']")
	WebElement birthDate;
	
	@FindBy(xpath = "//select[@id='cms-forgotid-birthYear']")
	WebElement birthYear;
	
	@FindBy(xpath = "//select[contains(@name, 'cms-forgotid-birthM')]")
	WebElement birthMonth;
	
	@FindBy(xpath = "//select[@name='cms-forgotid-birthMonth']//option")
	List<WebElement> birthMonthList;
	
	@FindBy(xpath = "//input[@id='cms-forgotid-forgotEmail']")
	WebElement email;
	
	@FindBy(xpath = "//input[@id='cms-forgotid-usZipCode']")
	WebElement zipCode;
	
	@FindBy(xpath = "//button[contains(text(), 'Su')]")
	WebElement submitButton;
	
	
	public void navigateToForgotUserIdPage() {
		pause(3);
		clickElement(forgetUserid);
		pause(5);
		verifyTitle(driver, "CMS Enterprise Portal - Forgot User ID");
		verifyCurrentUrl(driver, "https://portal.cms.gov/portal/forgotuserid");
		validationOfHeader(forgotUserIdHeader, "Forgot User ID");
		validationOfSubHeader(forgotUserIdSubHeader, "Please enter the following information to retrieve your User ID.");
		verifyTextOfTheWebElement(allFieldsRequired, "All fields are required.");
	}
	
	// drop down, by all 3 methods
	// drop down is a commonly asked interview question
	
	// birth month
	// use method --> selectByValue()
	public void use_of_dropdown_with_selectByValue_method() {
		select = new Select(birthMonth);
		select.selectByValue("06"); // for choosing June
		pause(3);
	}
	
	// birth date
	// use method --> selectByIndex()
	// This method is not suggested, or not used much
	// Because, adding a new web element or deleting a new one can change the index number	
	public void use_of_dropdown_with_selectByIndex_method() {
		select = new Select(birthDate);
		select.selectByIndex(8); // for choosing 8
		pause(3);
	}
	
	// birth year
	// drop down is a commonly asked interview question
	// Most commonly use method --> selectByVisibleText()
	public void use_of_dropdown_selectByVisibleText_method() {
		select = new Select(birthYear);
		select.selectByVisibleText("1988"); // for choosing 1988
		pause(3);
	}
	
	public void forgotUserid() {
		inputText(firstName, "Mohammad");
		pause(3);
		inputText(lastName, "Sharkar");
		pause(3);
		selectDropdownOnebyOne(birthMonth, birthMonthList); // high level, we can do same for birth date and year
		pause(3);
		selectDropdown(birthMonth, "June");
		pause(3);
		selectDropdown(birthDate, "8");
		pause(3);
		selectDropdown(birthYear, "1988");
		pause(3);
		inputText(email, "tofael483@gmail.com");
		pause(3);
		inputText(zipCode, "10019");
		pause(3);
		clickElement(submitButton);
		pause(3);
	}


}
