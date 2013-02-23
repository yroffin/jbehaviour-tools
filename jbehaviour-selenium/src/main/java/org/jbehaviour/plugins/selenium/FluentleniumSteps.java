/**
 *  Copyright 2012 Yannick Roffin
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *   limitations under the License.
 */

package org.jbehaviour.plugins.selenium;

import org.fluentlenium.core.FluentAdapter;
import org.jbehaviour.annotation.Given;
import org.jbehaviour.annotation.Then;
import org.jbehaviour.annotation.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FluentleniumSteps extends FluentAdapter {
	Logger logger = LoggerFactory.getLogger(FluentleniumSteps.class);

	private WebDriver driver;
	
	@Given("launch the chrome navigator")
	public void startChromeNavigator() {
		logger.info("Start chrome navigator with " + System.getProperty("webdriver.chrome.driver"));
		driver = new ChromeDriver();
		this.initFluent(driver);
	}

	@Given("launch the ie navigator")
	public void startIeNavigator() {
		logger.info("Start internet explorer navigator with " + System.getProperty("webdriver.chrome.driver"));
		driver = new InternetExplorerDriver();
		this.initFluent(driver);
	}

	@Given("launch the html navigator")
	public void startHtmlNavigator() {
		logger.info("Start html navigator");
		driver = new HtmlUnitDriver();
		this.initFluent(driver);
	}

	@When("i goto to $parameter")
	public void gotoUrl(String parameter) {
		logger.info("Goto url " + parameter);
		logger.info(goTo(parameter).pageSource()+"");
	}
	
	@When("i fill $id with $value")
	public String fillSomething(String id, String value) {
		logger.info("Fill " + id + " with " + value);
		fill(id).with(value);
		return this.pageSource();
	}

	@When("i click on $value")
	public String clickOn(String value) {
		logger.info("Click on element " + value);
		click(value);
		return this.pageSource();
	}

	@When("i submit $value")
	public String submitAValue(String value) {
		logger.info("Submit " + value);
		submit(value);
		return this.pageSource();
	}

	@Then("Title must contain $value")
	public boolean titleMustContain(String value) {
		boolean result = title().contains(value);
		logger.info("Title source must contain " + value + " : " + result);
		return result;
	}

	@Then("Body must contain $value")
	public boolean bodyMustContain(String value) {
		boolean result = pageSource().contains(value);
		logger.info("Page source must contain " + value + " : " + result);
		return result;
	}

	@Given("Close browser driver")
	public void closeDriver() {
		driver.close();
	}
}
