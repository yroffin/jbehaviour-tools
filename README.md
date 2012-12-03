jbehaviour-tools
================

jbehaviour-tools

behaviour-tools is not a fork, but it's based on the great idea of dan north : http://dannorth.net/introducing-bdd
all is rewritten, and based on a antlr grammar.

this framework permit to parse and execute story with a jbehave approach but with some extention :
- json object on the fly creation and manipulation in the story (with jackson)
- velocity templating integration to manipulating all object created on the fly in the story
- storage during the story on object in session
- include other story
- registering annoted class at the begining of the story

the purpose of this framework is to simplify, and make readable all story manipulated by a business analyst
and avoid to consider so much technical method for using testing tools :
- soapui
- ssh/scp/sftp/svn/git manipulation
- remote host manipulation (unix system)
- selenium suite
- and so on ...

TODO
====

- transform getDuration in getTime
- integrate dis-ambiguity system using plugin name
- create atomic scenario notion (for calling as sub routine)
- implement Foreach keyword to iterate on List



