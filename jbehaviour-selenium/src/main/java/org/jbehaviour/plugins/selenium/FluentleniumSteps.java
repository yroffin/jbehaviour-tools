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
		logger.debug("Start chrome navigator with " + System.getProperty("webdriver.chrome.driver"));
		driver = new ChromeDriver();
		this.initFluent(driver);
	}

	@Given("launch the ie navigator")
	public void startIeNavigator() {
		logger.debug("Start internet explorer navigator with " + System.getProperty("webdriver.chrome.driver"));
		driver = new InternetExplorerDriver();
		this.initFluent(driver);
	}

	@Given("launch the html navigator")
	public void startHtmlNavigator() {
		logger.debug("Start html navigator");
		driver = new HtmlUnitDriver();
		this.initFluent(driver);
	}

	@When("i goto to $parameter")
	public void gotoUrl(String parameter) {
		logger.debug("Goto url " + parameter);
		logger.debug(goTo(parameter).pageSource()+"");
	}
	
	@When("i fill $id with $value")
	public void fillSomething(String id, String value) {
		logger.debug("Fill " + id + " with " + value);
		fill(id).with(value);
	}

	@When("i submit $value")
	public String submitAValue(String value) {
		logger.debug("Submit " + value);
		submit(value);
		return this.pageSource();
	}

	@Then("Title must contain $value")
	public boolean fillSomething(String value) {
		logger.debug("Title must contain " + value + " : " + title());
		return title().contains(value);
	}

	@Then("Close internet browser")
	public boolean closeIt() {
		driver.close();
		return true;
	}
}
