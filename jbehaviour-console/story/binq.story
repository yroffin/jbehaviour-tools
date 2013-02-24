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

   Scenario: Verify we can go to 'http://www.bing.com'
    Given set property 'webdriver.chrome.driver' to $chromeDriver
    Given launch the html navigator
     When i goto to $urlBinq
     When i fill '#sb_form_q' with $fluentLenium
     When i submit '#sb_form_go'
     Then store last result in file $output
     Then Title must contain $fluentLenium
    Given Close browser driver


