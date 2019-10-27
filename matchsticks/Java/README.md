To compile, you need Java 7 or newer installed.

The initial project contains only one source file. Compile and run:

* ```javac src/main/java/floppylab/matchsticks/Matchsticks.java -d target```
* ```java -cp target floppylab.matchsticks.Matchsticks```

You can use Maven to build Jar file. Execute the following command from the matchsticks working folder:
* ```mvn install```

Then execute the generated Jar:

* ```java -jar matchsticks-0.0.1-SNAPSHOT.jar```

The project is a standard Eclipse Maven project. You can Import it to your Workspace: File/Import/Maven/Existing Maven Projects.
