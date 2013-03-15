System Extention
================

1. Setup
--------

This step is stored in maven module : jbehaviour-engine (core)

A standard step object exist, called SystemSteps ... it can be resistered like this in story feature part

	...
	Register sample with 'org.jbehaviour.plugins.system.SystemSteps' plugin
	...

2. Asynchronous command call
----------------------------

An asynchronous command can be start (system dependent, so take care with unix ou windows prerequisite)

This command is started by a first "Given" command, and the second "Given" wait for completion.

Framework vision ...

	...
	public class org.jbehaviour.plugins.system.SystemSteps {
	...
	@Given("start $command with $args as $reference") {
		...
	}
	@Given("send return to async command $reference") {
		...
	}
	@Given("wait for async command $reference") {
		...
	}
	...

And in story it could be used as ...

	...
	Given start 'cmd.exe' with '/C echo storyTest' as windowsCmdTest
	Given send return to async command $windowsCmdTest
	Given wait for async command $windowsCmdTest
	...

Waiting for completion can be call whenever you want in your story, this behaviour is needed for example
when you want to start daemon tools (ex: soapui webservice server mocking) and then waiting for it's completion.

Send some return (CR) to this async command is also possible:

	...
	Given send return to async command $windowsCmdTest
	...

Send a Carriage Return to async processus identified by '$windowsCmdTest'

3. Setting environnement
------------------------

This extention permit to modify environnement variable.

Framework vision ...

	...
	public class org.jbehaviour.plugins.system.SystemSteps {
	...
	@Given("set property $property to $value")
		...
	}
	...

And in story it could be used as ...

	...
	Given set property 'PATH' to 'C:\\temp'
	...

4. Printing/Writing object
--------------------------

This extention permit to print in local logs object (by calling toString())

Framework vision ...

	...
	public class org.jbehaviour.plugins.system.SystemSteps {
	...
	@Given("print object $value")
		...
	}
	@Given("store last result as $reference")
	public Object storeReference(String reference) {
		...
	}
	@Then("store last result in file $filename")
		...
	}
	...

And in story it could be used as ...<br/>

	...
	Given print object 'ID'
	Given store last result as REF
	Then store last result in file 'C:\\temp\last_result.txt'
	...

This sample :
- print object in session (story session) identified by ID
- store last result (last return of the last mehod called) in a reference REF
- dump last result content to one file

5. Waiting for second and millisecond
-------------------------------------

This extention permit to waiting.

Framework vision ...

	...
	public class org.jbehaviour.plugins.system.SystemSteps {
	...
	@Given("wait for $value second")
		...
	}
	@Given("wait for $value millisecond")
		...
	}
	...

And in story it could be used as ...

	...
	Given wait for 2 seconds
	Given wait for 2 milliseconds
	...

6. Storing object in session
----------------------------

This extention permit to store and lod object/string from session (all the story session).
Main order is 'store last result as $reference', then you can re-use this reference in story.

Framework vision ...

	...
	public class org.jbehaviour.plugins.system.SystemSteps {
	...
	 @Given("store last result as $reference")
		...
	}
	...

And in story it could be used as ...

	...
	Given store last result as 'myReference'
	Given make something with $myReference
	...

Notice that $myReference will be passed as a plain object during method call ...

7. Iterate on object
--------------------

This extention permit to iterate on object such as list.

Framework vision ...

	...
	public class org.jbehaviour.plugins.system.SystemSteps {
	...
	@Given("foreach $list as $item call $scenario")
		...
	}
	...

And in story it could be used as ...

	Feature: Launch a story sample for testing scenario call
	In order to test this feature
	As an explicit system actor
	I want to verify this behaviour
	Register system with 'org.jbehaviour.plugins.system.SystemSteps' plugin
	Declare ref001 as Json 'org.jbehaviour.plugins.ComplexForeachBean'
	{
		"listInteger":[0,1,2,3,4],
		"listString":["A","B","C"]
	}

	Scenario: Verify this sample
		Given print object $ref001
		Given foreach $ref001.getListInteger() as arg001 call 'Print each item'

	Scenario: Print each item
		Given print object $arg001

