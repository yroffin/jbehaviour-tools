Introduction
============

Main purpose of jbehaviour-tools is to simplify common developpment tools for
simple users in "natural" langage.

behaviour-tools is not a fork, but it's based on the great idea of dan north : [http://dannorth.net/introducing-bdd](http://dannorth.net/introducing-bdd)
all is rewritten, and based on a antlr grammar.

This framework permit to parse and execute story with a [jbehave](http://jbehave.org)/[cumcumber](http://cukes.info/) approach but with some extention :

* json object on the fly creation and manipulation in the story (with jackson)
* velocity templating integration to manipulating all object created on the fly in the story
* storage during the story on object in session
* include other story
* registering annoted class at the begining of the story

the purpose of this framework is to simplify, and make readable all story manipulated by a business analyst
and avoid to consider so much technical method for using testing tools :

- soapui
- ssh/scp/sftp/svn/git manipulation
- remote host manipulation (unix system)
- selenium suite
- and so on ...

[Default usage](usage/usage.md)

Extention
=========

[System](plugins/system.md) core included ...<br/>
[Sikuli](plugins/sikuli.md)<br/>
[Remote](plugins/remote.md)<br/>
[Jdbc](plugins/jdbc.md)<br/>
[Fluentlenium](plugins/fluentlenium.md)<br/>

