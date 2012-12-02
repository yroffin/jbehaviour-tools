Fluentlenium Extention
======================

1. Setup
--------

This step is stored in maven module : jbehaviour-selenium

This module is based on [selenium](http://http://seleniumhq.org) and [fluentlenium](https://github.com/FluentLenium/FluentLenium)

This step implements:
- TODO ...

2. Sample
---------

>Feature: Launch a web client and go to 'http://www.bing.com'<br/>
>  In order to test this feature<br/>
>  As an explicit system actor<br/>
>  I want to verify this behaviour<br/>
>  Register system       with "org.jbehaviour.plugins.system.SystemSteps" plugin<br/>
>  Register fluentlenium with 'org.jbehaviour.plugins.selenium.FluentleniumSteps' plugin<br/>
>  Declare urlBinq as String 'http://www.bing.com'<br/>
>  Declare chromeDriver as String 'C:\\tmp\\chromedriver.exe'<br/>
>  Declare fluentLenium as String 'FluentLenium'<br/>
>  Declare output as String 'target/output.txt'<br/>

>   Scenario: Verify we can go to 'http://www.bing.com'<br/>
>    Given set property 'webdriver.chrome.driver' to $chromeDriver<br/>
>    Given launch the html navigator<br/>
>     When i goto to $urlBinq<br/>
>     When i fill '#sb_form_q' with $fluentLenium<br/>
>     When i submit '#sb_form_go'<br/>
>     Store in file $output<br/>
>     Then Title must contain $fluentLenium<br/>
