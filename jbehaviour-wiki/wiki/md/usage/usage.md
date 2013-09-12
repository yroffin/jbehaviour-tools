Usage
=====

1. General
----------

A story look like this kind of presentation :

	...
	#
	# some comment ...
	#
	...
	Feature: [some feature]
		==> some feature to implement with this story
	In order to [test purpose]
		==> objectives of this story
	As an [actor description]
		==> actor for this story
	I want to [story purpose]
		==> purpose of this story
	Register [reference]
		==> reference of this class during story running") with [classpath] ==> class path, class path must be enclose by cote plugin
	Declare  [reference]
		==> reference of this object during story running") as   [String|Json]
		==> type of this object") [classpath]
		==> class path, class path must be enclose by cote [json declaration] ==> object declaration or value
	Include  [story path]
		==> path where we can find this story, path must be enclose by cote")
	...
	
	...
	#
	# some comment ...
	#
	Scenario: [scenario purpose]
		==> some scenario description
	Given [some precondition]
		==> some precondition
	And   [some other condition]
		==> some other precondition to initialize
	When  [something hapen]
		==> declare an event reaction
	And   [some other event]
		==> another declaration
	Then  [some action]
		==> some feature to implement with this story
	And   [some other action]
		==> some feature to implement with this story
	...

2. Feature
----------

A feature implement the story declaration, this feature can have a description to identify
the purpose of this story.

	Feature: Launch a story sample
	In order to test this feature
	As an explicit system actor
	I want to verify this behaviour
	...

2. Register
-----------

Each scenario will implement some steps, each step must be recognized by a declared class.
Class register consist to declare a class path associated to one global unique id, this global id will be use to correct ambiguity if necessary.

	...
	Register sample with 'org.jbehaviour.plugins.SampleSteps' plugin
	...

This declaration declare an internal global id 'sample' for the class [org.jbehaviour.plugins.SampleSteps](https://github.com/yroffin/jbehaviour-tools/blob/1.0.0.0.0/jbehaviour-engine/src/test/java/org/jbehaviour/plugins/SampleSteps.java)
this class must be in classpath.

**Notice that** override is working, so default extention can be overriden (SystemSteps etc ...).

3. Declare
----------

Each scenario will implement some steps, each step can use local object (String, Class ...) ...

For a json declaration :

	...
	Declare ref001 as Json 'org.jbehaviour.plugins.ComplexJsonBean'
	{
	"field1":"value1",
	"field2":"value2",
	"field3":1000
	}
	...

And for a String declaration :

	...
	Declare ref002 as String "some string 002"
	...

3. Include
----------

A story can include an external story for :

* All Registered Class inclusion of this external story
* All Declared Object inclusion of this external story
* All Scenario inclusion of this external story

A sample code could be :

	...
	Include 'src/test/resources/files/sample.story'
	...

