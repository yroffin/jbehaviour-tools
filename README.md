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

WIKI
====
Cf: [wiki](jbehaviour-wiki/wiki/md/index.md)

TODO
====

- find report in classpath (with resource loader)
- remove JBehaviour prefix on standard Steps
- move all standard command/extention to plugins
- transform wait for async in 'Then' with return code analysis

LICENSE
=======

_Copyright 2012 Yannick Roffin_

_Licensed under the Apache License, Version 2.0 (the "License");_
_you may not use this file except in compliance with the License._
_You may obtain a copy of the License at_

_http://www.apache.org/licenses/LICENSE-2.0_

_Unless required by applicable law or agreed to in writing, software_
_distributed under the License is distributed on an "AS IS" BASIS,_
_WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied._
_See the License for the specific language governing permissions and_
_limitations under the License._

