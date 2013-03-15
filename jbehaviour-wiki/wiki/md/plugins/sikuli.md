Sikuli Extention
================

1. Setup
--------

This step is stored in maven module : jbehaviour-sikuli

2. Asynchronous command call
----------------------------


Framework vision ...

	...
	@Given("with sikuli type $character on $image")
	...
	@Given("with sikuli type return")
	...
	@Given("with sikuli click on $image")
	...
	@Given("with sikuli doubleclick on $image")
	...
	@Given("with sikuli capture desktop to $filename in $format format")
	...


2. Sample
---------

	Feature: Launch some tests with sikuli
		In order to test this feature	
		As an explicit system actor	
		I want to verify this behaviour	
		Register system with 'org.jbehaviour.plugins.system.SystemSteps' plugin	
		Register sikuli with 'org.jbehaviour.plugins.sikuli.JBehaviourSikuliSteps' plugin	
		Report 'org.jbehaviour.report.impl.JBehaviourVelocityReport' 'src/test/resources/template/junit.vm' 'target/TEST-report.xml'	
		Declare filename as String 'target/screen.png'	
		Declare iconGoogle as String 'file:src/test/resources/files/icon_google.png'	
		Declare barreGoogle as String 'file:src/test/resources/files/barre_google.png'	

	Scenario: Verify we can make some test with sikuli	
		Given with sikuli doubleclick on $iconGoogle	
		Given with sikuli type 'www.google.fr' on $barreGoogle	
		Given with sikuli type return	
		Given wait for 1 second	
		Given with sikuli capture desktop to $filename in png format	

