package com.stepdefinition;

import java.awt.AWTException;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import com.base.BaseClass;
import com.pagemanagers.PageObjectManager;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TC1_LoginStep extends BaseClass {

	PageObjectManager pom = new PageObjectManager();

	@Given("User is on the Adactin Page")
	public void user_is_on_the_adactin_page() throws FileNotFoundException, IOException {
//		getDriver(getPropertyFileValue("browserName"));
//		enterUrl(getPropertyFileValue("url"));
//		maximizeWindows();
	}

	@When("User should perform Login {string},{string}")
	public void user_should_perform_login(String userName, String password) {
		pom.getLoginPage().login(userName, password);
	}

	@When("User should perform Login {string},{string} with Enter Key")
	public void user_should_perform_login_with_enter_key(String userName, String password) throws AWTException {
		pom.getLoginPage().loginWithEnter(userName, password);
	}

	@Then("User should verify after login with Invalid Credential error message {string}")
	public void user_should_verify_after_login_with_invalid_credential_error_message(String expLoginErrorMessage) {
		WebElement txtErrorLogin = pom.getLoginPage().getTxtErrorLogin();
		String textFromWebpage = getTextFromWebpage(txtErrorLogin);
		boolean b = textFromWebpage.contains(expLoginErrorMessage);
		Assert.assertTrue("Verify After Login Using Invalid Credential Error Message Contains", b);
	}

}
