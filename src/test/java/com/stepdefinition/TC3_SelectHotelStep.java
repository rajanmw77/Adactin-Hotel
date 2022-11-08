package com.stepdefinition;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import com.base.BaseClass;
import com.pagemanagers.PageObjectManager;

import io.cucumber.java.en.*;

public class TC3_SelectHotelStep extends BaseClass {
	
	PageObjectManager pom = new PageObjectManager();

	@Then("User should select the hotel name")
	public void user_should_select_the_hotel_name() throws InterruptedException {
		pom.getSelectHotelPage().selectHotel();
	}

	@Then("User should verify after selecting hotel success message {string}")
	public void user_should_verify_after_selecting_hotel_success_message(String expSuccessMsg) {
//		WebElement selectHotelsuccessMsg = pom.getBookHotelPage().getSelectHotelSuccessMsg();
//		String textFromWebpage = getTextFromWebpage(selectHotelsuccessMsg);
//		boolean b = textFromWebpage.contains(expSuccessMsg);
//		Assert.assertTrue("Verify After Selecting Hotel Success Message", b);
		
		WebElement selectHotelsuccessMsg = pom.getBookHotelPage().getSelectHotelSuccessMsg();
		String textFromWebpage = getTextFromWebpage(selectHotelsuccessMsg);
		Assert.assertEquals("Verify After Selecting Hotel Success Message", expSuccessMsg, textFromWebpage);
	}

	@Then("User should click continue without selecting the hotel")
	public void user_should_click_continue_without_selecting_the_hotel() {
	pom.getSelectHotelPage().withoutSelectHotel();
	}

	@Then("User should verify after without selecting hotel error message {string}")
	public void user_should_verify_after_without_selecting_hotel_error_message(String expErrorMsg) {
		WebElement withoutSelectErrorMsg = pom.getSelectHotelPage().getWithoutSelectHotelErrorMsg();
		String textFromWebpage = getTextFromWebpage(withoutSelectErrorMsg);
		boolean b = textFromWebpage.contains(expErrorMsg);
		Assert.assertTrue("Verify After Without Selecting Hotel Error Messag", b);

	}

}
