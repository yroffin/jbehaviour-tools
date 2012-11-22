#
# this declaration is mandatory to reference org.jbehaviour.plugins.SampleSteps in the system
# sample reference is defined so it can be use to suppress
# ambigous declaration
#
Feature: Launch a story sample
  In order to test this feature
  As an explicit system actor
  I want to verify this behaviour
  Register sample with 'org.jbehaviour.plugins.SampleSteps' plugin

  Scenario: Verify this sample
    Any   some precondition with $argument
    Given some precondition
      And some other precondition
     When some action by the actor
      And some other action
      And yet another action
     Then some testable outcome is achieved
      And something else we can check happens too
