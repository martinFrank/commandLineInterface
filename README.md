# commandLineInterface
CommandLineInterpreter

this library provides a command line interface for apps.
The CommandLineInterpreter is the centered Class here. it takes the Input
from CommandLine and maps it into proper commands. These
commands are given to the CommandProvider, who's responsible to
execute it.

To make that concept working, the Interpreter offers a set of commands,
which can be executed.

###version 0.2
 - Seperation of main from cli
 - provide access to help / exit

### news
 - finally i managed to add support for [sonar cloud](https://sonarcloud.io/dashboard?id=martinFrank_cli)
 - finally i can do continuous integration with [cirrus-ci](https://cirrus-ci.com/)
 - finally able to upload jars into the maven repository ()
 
read the guid on how to deploy into [maven repository](https://maven.apache.org/repository/guide-central-repository-upload.html)