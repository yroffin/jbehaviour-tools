Remote Extention
================

1. Setup
--------

This step is stored in maven module : jbehaviour-remote

This step implements:
- local access
- remote access with sftp
- remote command with ssh

TODO : FTP (but nowadays FTP is often forbiden so ...)

TODO : explain get/put method

3. Connexion
------------

Framework vision
	...
	@Given("with remote create $type resource $url identified by $resource")
	...
	@When("with remote open resource '$resource'")
	...

4. remote access SFTP
---------------------

Framework vision
	@Then("with remote check if $file exist on $resource")
	...
	@Given("with remote list directory $directory on $resource")
	...
	@When("with remote put $input to $output on $resource")
	...
	@When("with remote put $input to $output on $resource")
	...

5. remote access SSH
--------------------

Framework vision
	@Given("with remote execute command $command on $resource")
	...


6. Global sample
----------------

	Feature: Launch some tests with remote
		In order to test this feature
		As an explicit system actor
		I want to verify this behaviour
		Register system with 'org.jbehaviour.plugins.system.SystemSteps' plugin
		Register sikuli with 'org.jbehaviour.plugins.remote.JBehaviourRemoteSteps' plugin
		Report 'org.jbehaviour.report.impl.JBehaviourVelocityReport' 'src/test/resources/template/junit.vm' 'target/TEST-remote.xml'
		Declare sftpRessource as String 'sftp://none:none@localhost'
		Declare sshRessource as String 'ssh://none:none@localhost'

	Scenario: Verify we can make some test with remote
		Given with remote create sftp resource $sftpRessource identified by sftp@gandalf
		Given with remote list directory '/etc' on sftp@gandalf
		Then  with remote check if '/etc/passwd' exist on sftp@gandalf
		Given with remote create ssh resource $sshRessource identified by ssh@gandalf
		Given with remote execute command 'ls -lrt' on ssh@gandalf

