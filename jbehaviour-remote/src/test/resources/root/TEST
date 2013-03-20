Feature: Launch some tests with remote
  In order to test this feature
  As an explicit system actor
  I want to verify this behaviour
  Register system with 'org.jbehaviour.plugins.system.SystemSteps' plugin
  Register remote with 'org.jbehaviour.plugins.remote.JBehaviourRemoteSteps' plugin
  Report 'org.jbehaviour.report.impl.JBehaviourVelocityReport' 'src/test/resources/template/junit_output.vm' 'target/xml/ssh.txt'
  Report 'org.jbehaviour.report.impl.JBehaviourVelocityReport' 'src/test/resources/template/junit.vm' 'target/xml/TEST-ssh.xml'
  Declare sftpRessource as String 'sftp://none:none@localhost:2222'
  Declare sshRessource as String 'ssh://none:none@localhost:2222'

Scenario: Verify we can make some test with remote
	# sftp part
	Given with remote create sftp resource $sftpRessource identified by sftp@gandalf
	Given with remote list directory '/etc' on sftp@gandalf
	When  with remote put 'src/test/resources/files/ssh.story' to '/TEST' on sftp@gandalf
	Then  with remote check if '/etc/passwd' exist on sftp@gandalf
	# ssh part
	Given with remote create ssh resource $sshRessource identified by ssh@gandalf
	Given with remote execute command 'ls -lrt;bug;exit 1' on ssh@gandalf
	Given store last result as consoleStream
	Call  foreach $consoleStream.getStdout() as arg001 call 'Print each item'
	Given with remote execute command 'set -x;rm -f TEST' on ssh@gandalf

Scenario: Print each item
    Given print object $arg001

