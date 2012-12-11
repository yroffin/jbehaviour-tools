System Extention
================

1. Setup
--------

This step is stored in maven module : jbehaviour-soapui

Soapui integration simply use [SystemSteps](system.md)

	...
	Register sample with 'org.jbehaviour.plugins.system.SystemSteps' plugin
	...

2. Service mock server
----------------------

An asynchronous command can be start (system dependent, so take care with unix ou windows prerequisite)

This command is started by a first "Given" command, and the second "Given" wait for completion.

And in story it could be used as ...

	Feature: Launch a story sample for testing async command call
	...
	Register system with 'org.jbehaviour.plugins.system.SystemSteps' plugin
	Declare mockservicerunner as Json 'org.jbehaviour.soapui.ConfigSoapuiBean'
	{
		"xml":"src/test/resources/soapui/StockQuote-soapui-project.xml",
		"port":8080,
		"url":"/test"
	}
	...
	Given start 'mockservicerunner.bat' with $mockservicerunner.getMockServiceRunner() as mockservicerunner
	Given wait for 2 seconds
	Given start 'testrunner.bat' with $mockservicerunner.getServiceRunner() as testrunner
	Given wait for async command $testrunner
	Given send return to async command $mockservicerunner
	Given wait for async command $mockservicerunner
	...
	
TODO ... more description

