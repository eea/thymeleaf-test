Thymeleaf+Spring test project
=============================

The purpose of this project is to investigate Spring and Thymeleaf as a new software standard for Eionet software.
It is set up as a demo of E-PRTR for the use of discussing the rewrite of same.

The application uses Liquibase to create and upgrade the database, and Thymeleaf as the templating engine.
You can find the layout template at src/main/webapp/WEB-INF/thymeleaf

Automated tests
---------------
There are test examples of both controllers and data access objects using the Spring test package.
Note that loading demo data is part of the liquibase changelog, and the tests use that data instead
of initialising with their own test data.

Spring 4
--------

The current configuration is using Spring 3. This is because I don't have access to a Tomcat 7 server for
the demonstration. To switch to Spring 4, beyond changing spring.version to 4.1.4.RELEASE, you also must
change the spring-mvc-config.xml in src/main/webapp/WEB-INF/ and the Maven dependencies to Servlet 3.0.

```xml
<dependency>
    <groupId>javax.servlet</groupId>
    <artifactId>javax.servlet-api</artifactId>
    <version>3.0.1</version>
    <scope>provided</scope>
</dependency>
```

