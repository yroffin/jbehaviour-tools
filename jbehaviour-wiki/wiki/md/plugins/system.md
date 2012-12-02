System Extention
================

1. Setup
--------

This step is stored in maven module : jbehaviour-engine (core)

This extention permit to store object in session :

> Set environement property to a defined value<br />
>> set property $property to $value
>> Example: set property 'PATH' to 'C:\\temp'

> Print object (object is a reference to a defined reference) as string in default output<br />
>> print object $value
>> Example: print object 'ID'

> Store last action result in reference $reference<br />
>> store last result as $reference
>> Example: result as 'myReference'

> Store last action result in file $filename<br />
>> store last result in file $filename
>> Example: in file 'C:\\output\\file.txt'

Extention declaration :
>   ...<br />
> Register sample with 'org.jbehaviour.plugins.system.SystemSteps' plugin<br />
>   ...<br />




