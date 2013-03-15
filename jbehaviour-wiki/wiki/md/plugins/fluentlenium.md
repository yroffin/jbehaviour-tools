Fluentlenium Extention
======================

1. Setup
--------

This step is stored in maven module : jbehaviour-selenium

This module is based on [selenium](http://http://seleniumhq.org) and [fluentlenium](https://github.com/FluentLenium/FluentLenium)

This step implements:
- TODO ...

2.Framework declaration
-----------------------

  ...
  @Given("launch the chrome navigator")
  ...
  @Given("launch the ie navigator")
  ...
  @Given("launch the html navigator")
  ...
  @When("i goto to $parameter")
  ...
  @When("i fill $id with $value")
  ...
  @When("i click on $value")
  ...
  @When("i submit $value")
  ...
  @Then("Title must contain $value")
  ...
  @Then("Body must contain $value")
  ...
  @Given("Close browser driver")
  ...

3. Global sample
----------------

  Feature: Launch a web client and go to 'http://www.bing.com'
    In order to test this feature
    As an explicit system actor
    I want to verify this behaviour
    Register system       with "org.jbehaviour.plugins.system.SystemSteps" plugin
    Register fluentlenium with 'org.jbehaviour.plugins.selenium.FluentleniumSteps' plugin
    Declare urlBinq as String 'http://www.bing.com'
    Declare chromeDriver as String 'C:\\tmp\\chromedriver.exe'
    Declare fluentLenium as String 'FluentLenium'
    Declare output as String 'target/output.txt'
  
  Scenario: Verify we can go to 'http://www.bing.com'<br/>
    Given set property 'webdriver.chrome.driver' to $chromeDriver
    Given launch the html navigator
    When i goto to $urlBinq
    When i fill '#sb_form_q' with $fluentLenium
    When i submit '#sb_form_go'
    Store in file $output
    Then Title must contain $fluentLenium
