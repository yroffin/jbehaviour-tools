Jdbc Extention
==============

1. Setup
--------

This step is stored in maven module : jbehaviour-jdbc

This step implements:
- jdbc connect
- describe table
- select from entities and store result

2. Sample
---------

>Feature: Launch all test from jdbc feature<br/>
>  In order to test this feature<br/>
>  As an explicit system actor<br/>
>  I want to verify this behaviour<br/>
>  Register system  with "org.jbehaviour.plugins.system.SystemSteps" plugin<br/>
>  Register jdbc    with "org.jbehaviour.plugins.jdbc.JdbcSteps" plugin<br/>
>  Declare driverJdbc as String 'org.h2.Driver'<br/>

>   Scenario: Verify we can use this jdbc driver<br/>
>    Given connect with 'org.h2.Driver' and url 'jdbc:h2:mem' 'sa' '' as 'connexion01'<br/>
>    Given column length to 20 bytes<br/>
>    Given desc 'TEST1'<br/>
>    When  query 'SELECT * FROM TEST1' as select1<br/>
>    When  query 'SELECT * FROM TEST2' as select2<br/>
>    When  query 'SELECT * FROM TEST3' as select3<br/>
>    When  query 'SELECT * FROM TEST4' as select4<br/>
>    Then  $select1 have 4 lines<br/>
>    Then  $select2 have 4 lines<br/>
>    Then  $select3 have 5 lines<br/>
>    Then  $select4 have 6 lines<br/>
