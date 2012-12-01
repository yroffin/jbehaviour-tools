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

2. Sample
---------

>Feature: Launch some tests with remote<br/>
>  In order to test this feature<br/>
>  As an explicit system actor<br/>
>  I want to verify this behaviour<br/>
>  Register system with 'org.jbehaviour.plugins.system.SystemSteps' plugin<br/>
>  Register sikuli with 'org.jbehaviour.plugins.remote.JBehaviourRemoteSteps' plugin<br/>
>  Report 'org.jbehaviour.report.impl.JBehaviourVelocityReport' 'src/test/resources/template/junit.vm' 'target/TEST-remote.xml'<br/>
>  Declare sftpRessource as String 'sftp://none:none@localhost'<br/>
>  Declare sshRessource as String 'ssh://none:none@localhost'<br/>

>Scenario: Verify we can make some test with remote<br/>
>	Given with remote create sftp resource $sftpRessource identified by sftp@gandalf<br/>
>	Given with remote list directory '/etc' on sftp@gandalf<br/>
>	Then  with remote check if '/etc/passwd' exist on sftp@gandalf<br/>
>	Given with remote create ssh resource $sshRessource identified by ssh@gandalf<br/>
>	Given with remote execute command 'ls -lrt' on ssh@gandalf<br/>

