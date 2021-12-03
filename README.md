# WeatherShopping
This repo contains the framework that execute end to end positive scenario of Weather shopping application.

# Description
This framework has all pages data stored in UI\src\test\java\com\WeatherShopper\UI\Pages location.
Test case can be found in UI\src\test\java\com\WeatherShopper\UI\TestCases
This framework is built up using Java language with Selenium, Maven and testng jars. Parallel testing is implemented using testng and browser configuration is done in testng.xml file.

# Prerequisite to execute test case 
1). Install Java and Maven in your system and setup environment variable(JAVA_HOME & MAVEN_HOME) for both of them. And, add bin folder location of both in PATH variable.

# How to execute
1). Download source code of this framework from this repository.
2). Open command prompt and change directory to base folder of this repo. Make sure you reached in the directory where pom.xml and testng.xml files are present.
3). Run "mvn clean test -Dsurefire.suiteXmlFiles=testng.xml" command
4). It will trigger the execution and execution will happen in Chrome & Edge browser.
5). Once the execution is completed, user can view the report from test-output/emailable-report.html after refreshing the folder.
