package pages;

import org.testng.annotations.Test;

import baseUtil.BaseClass;

public class ForgotUseridTest extends BaseClass {
	
	@Test (enabled = false)
	public void navigateToForgotUserIdPageTest() {
		forgotUserId.navigateToForgotUserIdPage();
	}
	
	@Test (enabled = false)
	public void use_of_dropdown_with_selectByValue_method_test() {
		forgotUserId.navigateToForgotUserIdPage();
		forgotUserId.use_of_dropdown_with_selectByValue_method();
	}
	
	@Test (enabled = false)
	public void use_of_dropdown_with_selectByIndex_method_test() {
		forgotUserId.navigateToForgotUserIdPage();
		// forgotUserId.use_of_dropdown_with_selectByValue_method();
		forgotUserId.use_of_dropdown_with_selectByIndex_method();
	}
	
	@Test (enabled = false)
	public void use_of_dropdown_selectByVisibleText_method_test() {
		forgotUserId.navigateToForgotUserIdPage();
//		forgotUserId.use_of_dropdown_with_selectByValue_method();
//		forgotUserId.use_of_dropdown_with_selectByIndex_method();
		forgotUserId.use_of_dropdown_selectByVisibleText_method();
	}
	
	// This below test is enough for the feature, above tests are single test
	@Test(enabled = true)
	public void forgotUseridTest() {
		forgotUserId.navigateToForgotUserIdPage();
		forgotUserId.forgotUserid();
	}


}
