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
    