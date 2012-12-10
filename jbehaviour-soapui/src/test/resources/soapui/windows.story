Feature: Launch a story sample for testing async command call
  In order to test this feature
  As an explicit system actor
  I want to verify this behaviour
  Register system with 'org.jbehaviour.plugins.system.SystemSteps' plugin

  Scenario: Verify this sample
# Asynchronous soapui server
    Given start 'mockservicerunner.bat' with 'src\\test\\resources\\soapui\\StockQuote-soapui-project.xml -p 8080 -a /test' as mockservicerunner
    Given wait for 2 seconds
# synchronous webservice call
    Given start 'testrunner.bat' with 'src\\test\\resources\\soapui\\StockQuote-soapui-project.xml -e http://localhost:8080/test' as testrunner
    Given wait for async command $testrunner
# Asynchronous soapui stop
    Given send return to async command $mockservicerunner
    Given wait for async command $mockservicerunner
    