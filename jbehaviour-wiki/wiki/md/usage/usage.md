Usage
=====

1. General
----------

A story look like this kind of presentation :

> \#<br />
> \# some comment ...<br />
> \#<br />
> 
> Feature: [some feature](# "some feature to implement with this story")<br />
> In order to [test purpose](# "objectives of this story")<br />
> As an [actor description](# "actor for this story")<br />
> I want to [story purpose](# "purpose of this story")<br />
> Register [reference](# "reference of this class during story running") with [classpath](# "class path, class path must be enclose by cote") plugin<br />
> Declare  [reference](# "reference of this object during story running") as   [String|Json](# "type of this object") [classpath](# "class path, class path must be enclose by cote") [json declaration](# "object declaration or value")<br />
> Include  [story path](# "path where we can find this story, path must be enclose by cote")<br />
> 
>	#<br />
>	# some comment ...<br />
>	#<br />
>	Scenario: [scenario purpose](# "some scenario description")<br />
>	Given [some precondition](# "some precondition")<br />
>	And   [some other condition](# "some other precondition to initialize")<br />
>	When  [something hapen](# "declare an event reaction")<br />
>	And   [some other event](# "another declaration")<br />
>	Then  [some action](# "some feature to implement with this story")<br />
>	And   [some other action](# "some feature to implement with this story")<br />

### Feature ###

A feature implement the story declaration, this feature can have a description to identify
the purpose of this story.

> Feature: Launch a story sample<br />
>   In order to test this feature<br />
>   As an explicit system actor<br />
>   I want to verify this behaviour<br />
>   ...<br />

### Register ###

Each scenario will implement some steps, each step must be recognized by a declared class.
Class register consist to declare a class path associated to one global unique id, this global id will be use to correct ambiguity if necessary.

>   ...<br />
> Register sample with 'org.jbehaviour.plugins.SampleSteps' plugin<br />
>   ...<br />

This declaration declare an internal global id 'sample' for the class [org.jbehaviour.plugins.SampleSteps](https://github.com/yroffin/jbehaviour-tools/blob/v1.1a/jbehaviour-engine/src/test/java/org/jbehaviour/plugins/SampleSteps.java)
this class must be in classpath.

**Notice that** override is working, so default extention can be overriden (StoreSteps, SystemSteps etc ...).

### Declare ###

Each scenario will implement some steps, each step can use local object (String, Class ...) ...

For a json declaration :

>   ...<br />
> Declare ref001 as Json 'org.jbehaviour.plugins.ComplexJsonBean'<br />
> {<br />
>   "field1":"value1",<br />
>   "field2":"value2",<br />
>   "field3":1000<br />
> }<br />
>   ...<br />

And for a String declaration :

>   ...<br />
> Declare ref002 as String "some string 002"<br />
>   ...<br />

### Include ###

A story can include an external story for :

* All Registered Class inclusion of this external story
* All Declared Object inclusion of this external story
* All Scenario inclusion of this external story

A sample code could be :

>   ...<br />
> Include 'src/test/resources/files/sample.story'<br />
>   ...<br />

2. Extention
------------

### StoreSteps ###

This extention permit to store object in session :

> Store last action result in reference $reference<br />
>> result as $reference
>> Example: result as 'myReference'

> Store last action result in file $filename<br />
>> in file $filename
>> Example: in file 'C:\\output\\file.txt'

Extention declaration :
>   ...<br />
> Register sample with 'org.jbehaviour.plugins.system.StoreSteps' plugin<br />
>   ...<br />

### SystemSteps ###

This extention permit to store object in session :

> Set environement property to a defined value<br />
>> set property $property to $value
>> Example: set property 'PATH' to 'C:\\temp'

> Print object (object is a reference to a defined reference) as string in default output<br />
>> print object $value
>> Example: print object 'ID'

Extention declaration :
>   ...<br />
> Register sample with 'org.jbehaviour.plugins.system.StoreSteps' plugin<br />
>   ...<br />

