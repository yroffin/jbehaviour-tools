Jdbc Extention
==============

1. Setup
--------

This step is stored in maven module : jbehaviour-jdbc

This step implements:
- jdbc connect
- describe table
- select from entities and store result

2. Sample
---------

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
