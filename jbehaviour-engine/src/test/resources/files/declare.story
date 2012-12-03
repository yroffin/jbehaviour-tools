Feature: Launch a story sample
  In order to test this feature
  As an explicit system actor
  I want to verify this behaviour
  #
  # this declaration is mandatory to reference org.jbehaviour.plugins.SampleSteps in the system
  # sample reference is defined so it can be use to suppress
  # ambigous declaration
  #
  Register sample with 'org.jbehaviour.plugins.system.SystemSteps' plugin
  Register sample with 'org.jbehaviour.plugins.SampleSteps' plugin
  Declare ref001 as String 'some string 001'
  Declare ref002 as String "some string 002"

  Scenario: Verify this sample
    Any   some precondition with $argument
    Given some precondition
      And some other precondition
     When some action by the actor
      And some other action
      And yet another action
     Then some testable outcome is achieved
    Given store last result as resultat_du_test_1
     Then something else we can check happens too
    Given store last result as resultat_du_test_2
