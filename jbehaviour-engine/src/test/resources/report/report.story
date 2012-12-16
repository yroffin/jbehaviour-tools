Feature: Launch a story sample for testing json object
  In order to test this feature
  As an explicit system actor
  I want to verify this behaviour
  Report 'org.jbehaviour.report.impl.JBehaviourVelocityReport' 'src/test/resources/template/junit.vm' 'target/surefire-reports/TEST-report.xml'
  Register system with 'org.jbehaviour.plugins.system.SystemSteps' plugin
  Declare ref001 as Json 'org.jbehaviour.plugins.ComplexJsonBean'
{
  "field1":"value1",
  "field2":"value2",
  "field3":1000
}
  Declare ref002 as String "some string 002"

  Scenario: Verify this sample
    Given print object $ref001.getField1()
    Given print object $ref001.getField2()
    Given print object $ref001.getField3()
    Given print object $ref001
    Given print object $ref002
    Given wait for 1 seconds
    Given wait for 1500 milliseconds
    Then  return 'false'
    Then  throw 'unable to check this value'

 