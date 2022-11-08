package com.stepdefinition;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import com.base.BaseClass;
import com.pagemanagers.PageObjectManager;

import io.cucumber.java.en.*;

public class TC4_BookHotelStep extends BaseClass {

	PageObjectManager pom = new PageObjectManager();

	@Then("User should book a hotel {string},{string} and {string}")
	public void user_should_book_a_hotel_and(String firstName, String lastName, String address,
			io.cucumber.datatable.DataTable dataTable) throws InterruptedException {
		List<Map<String, String>> asMaps = dataTable.asMaps();
		String ccNo = asMaps.get(0).get("ccNo");
		String ccType = asMaps.get(1).get("ccType");
		String expMonth = asMaps.get(2).get("expMonth");
		String expYear = asMaps.get(3).get("expYear");
		String ccv = asMaps.get(4).get("CVV");
		pom.getBookHotelPage().bookHotel(firstName, lastName, address, ccNo, ccType, expMonth, expYear, ccv);
	}

	@Then("User should verify after book a hotel success message {string}")
	public void user_should_verify_after_book_a_hotel_success_message(String expBookingSuccessMsg) {
//		WebElement bookHotelsuccessMsg = pom.getBookHotelPage().getBookConformSuccessMsg();
//		String textFromWebpage = getTextFromWebpage(selectHotelsuccessMsg);
//		boolean b = textFromWebpage.contains(expBookingSuccessMsg);
//		Assert.assertTrue("Verify After Book A Hotel Success Message", b);
		
		WebElement bookHotelsuccessMsg = pom.getBookingConfirmPage().getBookConformSuccessMsg();
		String textFromWebpage = getTextFromWebpage(bookHotelsuccessMsg);
		Assert.assertEquals("Verify After Selecting Hotel Success Message", expBookingSuccessMsg, textFromWebpage);
	
	}

	@Then("User should book a hotel without entering any fields")
	public void user_should_book_a_hotel_without_entering_any_fields() {
		pom.getBookHotelPage().bookHotleWithoutAnyFields();
	}

	@Then("User should verify after book now button error message {string},{string},{string},{string},{string},{string} and {string}")
	public void user_should_verify_after_book_now_button_error_message_and(String expFstNameErrMsg,
			String expLstNameErrMsg, String expAddErrMsg, String expccNoErrorMsg, String expccTypeErrorMsg,
			String expMonErrMsg, String expcvvErrorMsg) {

		WebElement fstNameErrorMsg = pom.getBookHotelPage().getFstNameErrorMsg();
		String txtFstNa = getTextFromWebpage(fstNameErrorMsg);
		boolean b = txtFstNa.contains(expFstNameErrMsg);
		Assert.assertTrue("Verify After Book Now Button Error Messag", b);

		WebElement lstNameErrorMsg = pom.getBookHotelPage().getLstNameErrorMsg();
		String txtLstNa = getTextFromWebpage(lstNameErrorMsg);
		boolean b1 = txtLstNa.contains(expLstNameErrMsg);
		Assert.assertTrue("Verify After Book Now Button Error Messag", b1);

		WebElement addErrorMsg = pom.getBookHotelPage().getAddErrorMsg();
		String address = getTextFromWebpage(addErrorMsg);
		boolean b2 = address.contains(expAddErrMsg);
		Assert.assertTrue("Verify After Book Now Button Error Messag", b2);

		WebElement ccNOErrorMsg = pom.getBookHotelPage().getCcNoErrorMsg();
		String txtCC = getTextFromWebpage(ccNOErrorMsg);
		boolean b3 = txtCC.contains(expccNoErrorMsg);
		Assert.assertTrue("Verify After Book Now Button Error Messag", b3);

		WebElement ccTypeErrorMsg = pom.getBookHotelPage().getCcTypeErrorMsg();
		String txtType = getTextFromWebpage(ccTypeErrorMsg);
		boolean b4 = txtType.contains(expccTypeErrorMsg);
		Assert.assertTrue("Verify After Book Now Button Error Messag", b4);

		WebElement ccExpErrorMsg = pom.getBookHotelPage().getCcExpiryErrorMsg();
		String txtExp = getTextFromWebpage(ccExpErrorMsg);
		boolean b5 = txtExp.contains(expMonErrMsg);
		Assert.assertTrue("Verify After Book Now Button Error Messag", b5);

		WebElement cvvErrorMsg = pom.getBookHotelPage().getCvvErrorMsg();
		String txtcvv = getTextFromWebpage(cvvErrorMsg);
		boolean b6 = txtcvv.contains(expcvvErrorMsg);
		Assert.assertTrue("Verify After Book Now Button Error Messag", b6);
	}

}
