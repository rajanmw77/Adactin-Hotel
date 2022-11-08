package com.stepdefinition;

import java.awt.AWTException;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import com.base.BaseClass;
import com.pagemanagers.PageObjectManager;

import io.cucumber.java.en.*;

public class TC2_SearchHotelStep extends BaseClass {

	PageObjectManager pom = new PageObjectManager();

	@Then("User should search holtels {string},{string},{string},{string},{string},{string},{string} and {string}")
	public void user_should_search_holtels_and(String location, String hotels, String roomType, String noOfRooms,
			String checkIn, String checkOut, String noOfAdults, String noOfChild) throws AWTException, InterruptedException {
		pom.getSearchHotelPage().searchHotels(location, hotels, roomType, noOfRooms, checkIn, checkOut, noOfAdults,
				noOfChild);
	}

	@Then("User should verify after search hotel success message {string}")
	public void user_should_verify_after_search_hotel_success_message(String expSuccessMsg) {
		WebElement searchHotelsuccessMsg = pom.getSearchHotelPage().getSearchHotelSuccessMsg();
		String textFromWebpage = getTextFromWebpage(searchHotelsuccessMsg);
		boolean b = textFromWebpage.contains(expSuccessMsg);
		Assert.assertTrue("Verify After Search Hotel Success Message", b);
	}

	@Then("User should enter only mandatory fields {string},{string},{string},{string} and {string}")
	public void user_should_enter_only_mandatory_fields_and(String location, String noOfRooms, String checkIn,
			String checkOut, String noOfAdult) throws AWTException, InterruptedException {
		pom.getSearchHotelPage().searchHotelsWithMandatoryFields(location, noOfRooms, checkIn, checkOut, noOfAdult);

	}

	@Then("User should search hotel {string},{string},{string},{string},{string},{string},{string} and {string}")
	public void user_should_search_hotel_and(String location, String hotels, String roomType, String noOfRooms,
			String checkIn, String checkOut, String noOfAdults, String noOfChild) throws AWTException, InterruptedException {
		pom.getSearchHotelPage().searchHotelsWithInvalidDate(location, noOfRooms, checkIn, checkOut, noOfAdults);
	}

	@Then("User should verify after enter Invalid date error message {string},{string}")
	public void user_should_verify_after_enter_invalid_date_error_message(String checkInDateErrorMsg, String checkOutDateErrorMsg) {
			WebElement checkInDateErrorMsg2 = pom.getSearchHotelPage().getCheckInDateErrorMsg();
			String textFromWebpage = getTextFromWebpage(checkInDateErrorMsg2);
			boolean b = textFromWebpage.contains(checkInDateErrorMsg);
			Assert.assertTrue("Verify After Enter Invalid Date Error Message", b);
			WebElement checkInDateErrorMsg3 = pom.getSearchHotelPage().getCheckOutDateErrorMsg();
			String textFromWebpage1 = getTextFromWebpage(checkInDateErrorMsg3);
			boolean b1 = textFromWebpage1.contains(checkOutDateErrorMsg);
			Assert.assertTrue("Verify After Enter Invalid Date Error Message", b1);
	}

	@Then("User should search hotel without enter any field")
	public void user_should_search_hotel_without_enter_any_field() {
		pom.getSearchHotelPage().searchHotelsWithoutAnyFields();
	}

	@Then("User should verify after Enter without enter any fields error message {string}")
	public void user_should_verify_after_enter_without_enter_any_fields_error_message(String withoutAnyFieldErrorMsg) {
		WebElement withoutAnyFieldErrorMsg2 = pom.getSearchHotelPage().getWithoutAnyFieldErrorMsg();
		String textFromWebpage = getTextFromWebpage(withoutAnyFieldErrorMsg2);
		boolean b = textFromWebpage.contains(withoutAnyFieldErrorMsg);
		Assert.assertTrue("Verify After Enter Without Enter Any Fields Error Message", b);
	}

}
