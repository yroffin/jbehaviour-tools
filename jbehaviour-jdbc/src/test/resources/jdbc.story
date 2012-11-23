Feature: Launch all test from jdbc feature
  In order to test this feature
  As an explicit system actor
  I want to verify this behaviour
  Register store   with "org.jbehaviour.plugins.system.StoreSteps" plugin
  Register system  with "org.jbehaviour.plugins.system.SystemSteps" plugin
  Register jdbc    with "org.jbehaviour.plugins.jdbc.JdbcSteps" plugin
  Declare driverJdbc as String 'org.h2.Driver'

   Scenario: Verify we can use this jdbc driver
    Given connect with 'org.h2.Driver' and url 'jdbc:h2:mem' 'sa' '' as 'connexion01'
    Then  query 'SELECT * FROM TEST1'
    Then  query 'SELECT * FROM TEST2'
    Then  query 'SELECT * FROM TEST3'
    Then  query 'SELECT * FROM TEST4'

