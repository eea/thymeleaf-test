Thymeleaf+Spring test project
=============================

The purpose of this project is to investigate Spring and Thymeleaf as a new software standard for Eionet software.
It is set up as a demo of E-PRTR for the use of discussing the rewrite of same.

The application uses Liquibase to create and upgrade the database, and Thymeleaf as the templating engine.
You can find the layout template at src/main/webapp/WEB-INF/thymeleaf/layout.html. The database is in-memory
for the production and file-based for test. You can therefore just drop the WAR file into Tomcat, and it will
create tables, load demo data and launch.

Dependencies
------------
* Tomcat 7
* Java 1.7 (Also works with 1.6)
* Spring 4
* Thymeleaf 2.1.4
* H2 Database Engine

Automated tests
---------------
There are test examples of both controllers and data access objects using the Spring test package.
Note that loading demo data is part of the liquibase changelog, and the tests use that data instead
of initialising with their own test data.

How to build
------------
You need Git to check the code out from the repository and to build you need Java and Maven.  All other dependencies will automatically be downloaded by Maven.

For Windows see the pages on:
* [Git for Windows](http://git-scm.com/downloads)
* [Maven for Windows](http://maven.apache.org/guides/getting-started/windows-prerequisites.html).

To build you do:
```
git clone https://github.com/eea/thymeleaf-test.git
cd thymeleaf-test
mvn.bat install
```

This will create a `target` subdirectory, build the code, run the tests and put a WAR file in target. You can then deploy this file to Tomcat. It contains an embedded database with demo data.
