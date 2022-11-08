package com.pages;

import java.awt.AWTException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;

public class SearchHotelPage extends BaseClass{
	
	public SearchHotelPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "username_show")
	private WebElement txtLoginMsg;
	
	@FindBy(id="location")
	private WebElement location;
	
	@FindBy(id="hotels")
	private WebElement hotel;
	
	@FindBy(id="room_type")
	private WebElement roomType;
	
	@FindBy(id="room_nos")
	private WebElement noRooms;
	
	@FindBy(id="datepick_in")
	private WebElement checkIn;
	
	@FindBy(id="datepick_out")
	private WebElement checkOut;
	
	@FindBy(id="adult_room")
	private WebElement noAdult;
	
	@FindBy(id="child_room")
	private WebElement noChild;
	
	@FindBy(id="Submit")
	private WebElement submit;
	
	@FindBy(className = "login_title")
	private WebElement searchHotelSuccessMsg;
	
	@FindBy(id="checkin_span")
	private WebElement checkInDateErrorMsg;
	
	@FindBy(id="checkout_span")
	private WebElement checkOutDateErrorMsg;
	
	@FindBy(id = "location_span")
	private WebElement withoutAnyFieldErrorMsg;
	
	public WebElement getCheckInDateErrorMsg() {
		return checkInDateErrorMsg;
	}
	public WebElement getCheckOutDateErrorMsg() {
		return checkOutDateErrorMsg;
	}
	public WebElement getWithoutAnyFieldErrorMsg() {
		return withoutAnyFieldErrorMsg;
	}
	public WebElement getSearchHotelSuccessMsg() {
		return searchHotelSuccessMsg;
	}
	public WebElement getTxtLoginMsg() {
		return txtLoginMsg;
	}
	public WebElement getLocation() {
		return location;
	}
	public WebElement getHotel() {
		return hotel;
	}
	public WebElement getRoomType() {
		return roomType;
	}
	public WebElement getNoRooms() {
		return noRooms;
	}
	public WebElement getCheckIn() {
		return checkIn;
	}
	public WebElement getCheckOut() {
		return checkOut;
	}
	public WebElement getNoAdult() {
		return noAdult;
	}
	public WebElement getNoChild() {
		return noChild;
	}
	public WebElement getSubmit() {
		return submit;
	}

	public void searchHotelsCommonSteps(String location, String noOfRooms, String checkIn, String checkOut,
			String noOfAdults) throws AWTException, InterruptedException {
		selectOptionByAttribute(getLocation(), location);
		selectOptionByValue(getNoRooms(), noOfRooms);
		mouseOverAction(getCheckIn());
		elementClick(getCheckIn());
		insertTextUsingRobot(getCheckIn(), checkIn);
//		Thread.sleep(2000);
		mouseOverAction(getCheckOut());
		elementClick(getCheckOut());
//		Thread.sleep(2000);
		insertTextUsingRobot(getCheckOut(), checkOut);
		Thread.sleep(2000);
		selectOptionByValue(getNoAdult(), noOfAdults);
	}

	public void searchButton() {
		elementClick(submit);
	}

	public void searchHotels(String location, String hotels, String roomType, String noOfRooms, String checkIn,
			String checkOut, String noOfAdults, String noOfChild) throws AWTException, InterruptedException {
		searchHotelsCommonSteps(location, noOfRooms, checkIn, checkOut, noOfAdults);
		selectOptionByAttribute(getHotel(), hotels);
		selectOptionByAttribute(getRoomType(), roomType);
		selectOptionByValue(getNoChild(), noOfChild);
		searchButton();
	}

	public void searchHotelsWithMandatoryFields(String location, String noOfRooms, String checkIn, String checkOut,
			String noOfAdults) throws AWTException, InterruptedException {
		searchHotelsCommonSteps(location, noOfRooms, checkIn, checkOut, noOfAdults);
		searchButton();
	}

	public void searchHotelsWithInvalidDate(String location, String noOfRooms, String checkIn, String checkOut,
			String noOfAdults) throws AWTException, InterruptedException {
		searchHotelsCommonSteps(location, noOfRooms, checkIn, checkOut, noOfAdults);
		searchButton();
	}

	public void searchHotelsWithoutAnyFields() {
		searchButton();
	}
	
	
}
