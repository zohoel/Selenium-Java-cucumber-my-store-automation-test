# My Store - Test Automation Project using Selenium, Cucumber and Java
E2E testing suite for 'My Store' web app
## General info
Test automation suite for 'My Store' web application written with Selenium-Cucumer framework in Java using Maven . 'My Store' web app is dummy website for learning test automation. Contains all basic flows of a e-commerce website.
Test case for smoke test in Cucumber studio:
<a href="https://github.com/elmahodzic/My_store_SeleniumCucumberJava/blob/master/My_store_smoke_test.xlsx">Smoke test</a>
Test cases for regression test in Cucumber studio : 
<a href="https://github.com/elmahodzic/My_store_SeleniumCucumberJava/blob/master/My_store_regression_test.xlsx">Regression test</a>
# Environment
Windows:
- Java version 11.0.8
- Chrome version 84.0.4147.125
- Firefox version 81.0.2
MacOS:
- Java version 1.8.0_171
- Chrome version 86.0.4240.111
## Setting up
After cloning run mvn clean install
## Running test
To run tests using chrome browser on windows use:
`mvn test -Dbrowser=chrome -Dos=windows`
Folder 'drivers' also contains geckodriver and chromedriver for MacOS.
To run tests on mac using i.e firefox run:
`mvn test -Dbrowser=firefox -Dos=mac`
## Status
Currently project contains only smoke test script.