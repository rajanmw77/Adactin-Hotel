package com.stepdefinition;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.base.BaseClass;
import com.pagemanagers.PageObjectManager;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class HooksClass extends BaseClass {
	
	@Before
	public void beforeScenario() throws FileNotFoundException, IOException {
		getDriver(getPropertyFileValue("browserName"));
		enterUrl(getPropertyFileValue("url"));
		maximizeWindows();
	}
	
	@After
	public void afterScenario(Scenario scenario) throws IOException {

		scenario.attach(takeScreenShortByte(), "images/png", "Scenario");
//		boolean b = scenario.isFailed();
//		if (b) {
//			scenario.attach(takeScreenShortByte(), "images/png", "FailedScenario");
//		}
		quitWindow();
	}

}
