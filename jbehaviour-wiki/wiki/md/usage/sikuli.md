Sikuli Extention
================

1. Setup
--------

This step is stored in maven module : jbehaviour-sikuli

2. Sample
---------

> Feature: Launch some tests with sikuli<br/>
>  In order to test this feature<br/>
>  As an explicit system actor<br/>
>  I want to verify this behaviour<br/>
>  Register system with 'org.jbehaviour.plugins.system.SystemSteps' plugin<br/>
>  Register sikuli with 'org.jbehaviour.plugins.sikuli.JBehaviourSikuliSteps' plugin<br/>
>  Report 'org.jbehaviour.report.impl.JBehaviourVelocityReport' 'src/test/resources/template/junit.vm' 'target/TEST-report.xml'<br/>
>  Declare filename as String 'target/screen.png'<br/>
>  Declare iconGoogle as String 'file:src/test/resources/files/icon_google.png'<br/>
>  Declare barreGoogle as String 'file:src/test/resources/files/barre_google.png'<br/>

> Scenario: Verify we can make some test with sikuli<br/>
>  Given with sikuli doubleclick on $iconGoogle<br/>
>  Given with sikuli type 'www.google.fr' on $barreGoogle<br/>
>  Given with sikuli type return<br/>
>  Given wait for 1 second<br/>
>  Given with sikuli capture desktop to $filename in png format<br/>

