Jdbc Extention
==============

1. Setup
--------

This step is stored in maven module : jbehaviour-jdbc

This step implements:
- jdbc connect
- describe table
- select from entities and store result

Jdbc driver must be in classpath.

2. Jdbc connect
---------------

This method handle the jdbc connection configuration :
- $driver  : jdbc driver
- $url     : url
- $user    : user
- $passwrd : password
- $reference to identified and then using this jdbc connection

Framework vision
	...
	@Given("connect with $driver and url $url $user $passwrd as $reference")
	public Connection ...
	...

Story sample
	Given connect with 'org.h2.Driver' and url 'jdbc:h2:mem' 'sa' '' as 'connexion01'


3. Printing and describing table
--------------------------------

Framework vision
	...
	@Given("column length to $length bytes")
	...
	@Given("desc $table")
	public IBehaviourResultSet ...
	...

Story sample
		Given column length to 20 bytes
		Given desc 'TEST1'

4. Query and test result
------------------------

Framework vision
	@When("query $value as $reference")
	public IBehaviourResultSet ...
	...
	@Then("$reference have $nb lines")
	public boolean ...
	...

Story sample
	When  query 'SELECT * FROM TEST4' as select4
	Then  $select1 have 4 lines


5. Global sample
----------------

	Feature: Launch all test from jdbc feature
		In order to test this feature
		As an explicit system actor
		I want to verify this behaviour
		Register system  with "org.jbehaviour.plugins.system.SystemSteps" plugin
		Register jdbc    with "org.jbehaviour.plugins.jdbc.JdbcSteps" plugin
		Declare driverJdbc as String 'org.h2.Driver'

	Scenario: Verify we can use this jdbc driver
		Given connect with 'org.h2.Driver' and url 'jdbc:h2:mem' 'sa' '' as 'connexion01'
		Given column length to 20 bytes
		Given desc 'TEST1'
		When  query 'SELECT * FROM TEST1' as select1
		When  query 'SELECT * FROM TEST2' as select2
		When  query 'SELECT * FROM TEST3' as select3
		When  query 'SELECT * FROM TEST4' as select4
		Then  $select1 have 4 lines
		Then  $select2 have 4 lines
		Then  $select3 have 5 lines
		Then  $select4 have 6 lines
