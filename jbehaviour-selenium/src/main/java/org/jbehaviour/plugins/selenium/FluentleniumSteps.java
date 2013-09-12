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

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.jetty.util.log.Log;
import org.fluentlenium.core.Fluent;
import org.fluentlenium.core.FluentAdapter;
import org.fluentlenium.core.domain.FluentList;
import org.fluentlenium.core.domain.FluentWebElement;
import org.fluentlenium.core.filter.Filter;
import org.fluentlenium.core.filter.FilterConstructor;
import org.fluentlenium.core.filter.matcher.EqualMatcher;
import org.jbehaviour.annotation.Given;
import org.jbehaviour.annotation.Then;
import org.jbehaviour.annotation.When;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FluentleniumSteps extends FluentAdapter {
	Logger logger = LoggerFactory.getLogger(FluentleniumSteps.class);

	protected WebDriver driver;
	
	/**
	 * launch the chrome navigator
	 */
	@Given("launch the chrome navigator")
	public void startChromeNavigator() {
		logger.info("Start chrome navigator with " + System.getProperty("webdriver.chrome.driver"));
		driver = new ChromeDriver();
		drivers.add(driver);
		this.initFluent(driver);
	}

	@Given("launch with remote driver $driver on $hostname")
	public void lancerInternetExplorer32BitsRemote(String navigator, String hostname) throws MalformedURLException {
		// We could use any driver for our tests...
		DesiredCapabilities capabilities = null;
		if("firefox".compareTo(navigator) == 0) {
			capabilities = DesiredCapabilities.firefox();
		}
		if("ie".compareTo(navigator) == 0) {
			capabilities = DesiredCapabilities.internetExplorer();
		}
		
		// ... but only if it supports javascript
		capabilities.setJavascriptEnabled(true);

		// Get a handle to the driver. This will throw an exception
		// if a matching driver cannot be located
		driver = new RemoteWebDriver(new URL(hostname), capabilities);

		// Query the driver to find out more information
		Capabilities actualCapabilities = ((RemoteWebDriver) driver).getCapabilities();
		
		logger.info(actualCapabilities.asMap().toString());

		drivers.add(driver);
		this.initFluent(driver);
	}

	/**
	 * launch internet explorer
	 */
	@Given("launch the ie navigator")
	public void startIeNavigator() {
		logger.info("Start internet explorer navigator with " + System.getProperty("webdriver.chrome.driver"));
		driver = new InternetExplorerDriver();
		this.initFluent(driver);
	}

	/**
	 * launch defautl html navigator
	 */
	@Given("launch the html navigator")
	public void startHtmlNavigator() {
		logger.info("Start html navigator");
		driver = new HtmlUnitDriver();
		this.initFluent(driver);
	}

	/**
	 * go to url
	 * @param parameter
	 * @return 
	 */
	@When("i goto to $parameter")
	public String gotoUrl(String parameter) {
		logger.info("Goto url " + parameter);
		logger.info(goTo(parameter).pageSource()+"");
		return this.pageSource();
	}
	
	/**
	 * fill edit field
	 * @param id
	 * @param value
	 * @return
	 */
	@When("i fill $id with $value")
	public String fillSomething(String id, String value) {
		logger.info("Fill " + id + " with " + value);
		fill(id).with(value);
		return this.pageSource();
	}

	/**
	 * clock on element
	 * @param value
	 * @return
	 */
	@When("i click on $value")
	public String clickOn(String value) {
		logger.info("Click on element " + value);
		click(value);
		return this.pageSource();
	}

	/**
	 * submit a value
	 * @param value
	 * @return
	 */
	@When("i submit $value")
	public String submitAValue(String value) {
		logger.info("Submit " + value);
		submit(value);
		return this.pageSource();
	}

	/**
	 * assert title contain something
	 * @param value
	 * @return
	 */
	@Then("Title must contain $value")
	public boolean titleMustContain(String value) {
		boolean result = title().contains(value);
		logger.info("Title source must contain " + value + " : " + result);
		return result;
	}

	/**
	 * assert body contain something
	 * @param value
	 * @return
	 */
	@Then("Body must contain $value")
	public boolean bodyMustContain(String value) {
		boolean result = pageSource().contains(value);
		logger.info("Page source must contain " + value + " : " + result);
		return result;
	}

	/**
	 * close drive
	 */
	@Given("Close browser driver")
	public void closeDriver() {
		driver.quit();
		driver.close();
	}

	public static List<WebDriver> drivers = new ArrayList<WebDriver>();

	@Given("launch Internet Explorer with driver $path")
	public Fluent altIeLaunch(String path) {
		System.setProperty("webdriver.ie.driver", path);
		System.setProperty("webdriver.chrome.driver", path);
		DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
		caps.setJavascriptEnabled(true);
		caps.setCapability(
				InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,
				true);
		driver = new InternetExplorerDriver(caps);
		drivers.add(driver);
		return initFluent(driver);
	}

	/**
	 * property matcher
	 */
	private class withCustomValue extends Filter {
		public withCustomValue(String property, String value) {
			super(property, new EqualMatcher(value));
		}
	}

	@Given("take screenshot in directory $dir with filename $filename")
	public String screenshot(String dir, String filename) throws Exception {
		logger.info("Screenshot: " + dir + "/" + filename);
		takeScreenShot(dir + "/" + filename);
		logger.info("URL: " + driver.getCurrentUrl());
		return pageSource();
	}

	@When("i click on $tag tag with $property containing $name")
	public String iClickOnTagWithPropertyWithName(String tag, int index, String property, String name) throws Exception {
		FluentList<FluentWebElement> element = find(tag, new withCustomValue(property, name));
		if(element.size() > 0) {
			element.get(index).click();
		} else {
			logger.error("No "+tag+" element with property " + property + " containing " + name);
			throw new Exception("No "+tag+" element with property " + property + " containing " + name);
		}
		return pageSource();
	}

	@When("i fill with $value on $tag tag with $property containing $name")
	public String iFillATagWithPropertyWithName(String value, String tag, int index, String property, String name) throws Exception {
		FluentList<FluentWebElement> element = find(tag, new withCustomValue(property, name));
		if(element.size() > 0) {
			fillSomething(tag + '#' + element.get(index).getId(), value);
		} else {
			logger.error("No "+tag+" element with property " + property + " containing " + name);
			throw new Exception("No "+tag+" element with property " + property + " containing " + name);
		}
		return pageSource();
	}

	@When("i click on a link with text $text")
	public String iClickOnTagWithPropertyWithText(String tag, String text) throws Exception {
		FluentList<FluentWebElement> element = find(tag, FilterConstructor.withText(text));
		if(element.size() == 1) {
			element.get(0).click();
		} else {
			logger.error("No "+tag+" element with text containing " + text);
			throw new Exception("No "+tag+" element with text containing " + text);
		}
		return pageSource();
	}

	/**
	 *release driver method in order to quit all driver
	 */
	public static void releaseDrivers() {
		for(WebDriver driver : drivers) {
			driver.quit();
		}
	}
}
