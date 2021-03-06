Feature: Launch a story sample for testing async command call
  In order to test this feature
  As an explicit system actor
  I want to verify this behaviour
  Register system with 'org.jbehaviour.plugins.system.SystemSteps' plugin

# This story only work on windows
  Scenario: Verify this sample
    Given start 'cmd.exe' with '/C echo storyTest' as windowsCmdTest
    Given wait for async command $windowsCmdTest
