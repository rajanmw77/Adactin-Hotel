package com.stepdefinition;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import com.base.BaseClass;
import com.pagemanagers.PageObjectManager;

import io.cucumber.java.en.*;

public class CommonStep extends BaseClass {

	PageObjectManager pom = new PageObjectManager();

	@Then("User should verify after Login success message {string}")
	public void user_should_verify_after_login_success_message(String expLoginSuccessMesage) {
		WebElement txtLoginMsg = pom.getSearchHotelPage().getTxtLoginMsg();
		String textFromWebpage = getAttributeValue(txtLoginMsg);
		Assert.assertEquals("Verify After Login Success Message", expLoginSuccessMesage, textFromWebpage);
	}

}
