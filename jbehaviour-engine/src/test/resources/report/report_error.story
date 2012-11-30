Feature: Launch a story sample for testing json object
  In order to test this feature
  As an explicit system actor
  I want to verify this behaviour
  Report 'org.jbehaviour.report.impl.JBehaviourVelocityReport' 'src/test/resources/template/junit.vm' 'target/TEST-report.xml'
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
    Given wait for 100 millisecond
    Then  return 'false'

 