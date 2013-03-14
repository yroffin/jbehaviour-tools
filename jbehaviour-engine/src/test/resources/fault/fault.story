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
  Register sample with 'org.jbehaviour.plugins.FaultSteps' plugin

  Scenario: Verify this sample
    Given some message to throw 'test'
  
