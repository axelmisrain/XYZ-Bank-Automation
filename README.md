# XYZ-Bank Automation
##Automation Test Plan
This document outlines the automation testing plan for XYZ Bank

## Objectives
The objectives of automation testing for the XYZ Bank are as follows:
- To ensure that the XYZ Bank application is stable and reliable.
- To increase the speed of testing and reduce manual effort.
- To reduce the overall cost of testing.
- To ensure that customer fuctionalities are working properly.
- To ensure bank transaction work properly as expected.

##Scope
The scope of automation testing includes:
-Fuctional Testing in all modules
-Regression Testing in all modules
-Smoke Testing in all modules

##Automation Tool
The automation tool selected for this project is Selenium version 4.20.0 with programing languaje Java following Page Object Model 
and a TDD framework (pages, tests, runners).

##Test Enviroment
-Browser: Google Chrome Version 126.0.6478.127
-Programing Language: Java, JavaScript
-Integrated Development Enviroment: IntelliJ

##Test Data
The following test data will be used for automation testing:
-Usernames and passwords
-User information (First name, Last name, Zip/Postal Code)

##Test Execution
The automation testing process will follow the below steps:
-Identify the test cases to be automated.
-Develop automation scripts for identified test cases.
-Execute the automation scripts.
-Analyze the test results.
-Report and track defects, if any.

##Risks and mitigation
The following risks are identified:
-Changes in the web elements: This can lead to element not found errors. To mitigate this risk the web locators
will be organized in a different package in a dynamic way. 
Enviroment: If the tests run in a production enviroment, it can lead to unintentinal transaction, improper withdraws, incurrect billing. 

##Conclusion 
The automation test plan outlines the strategy for automation testing of the XYZ-Bank. This plan will ensure that the application 
is stable and reliable. The plan will also reduce overall cost of testing and speed up the testing process. 
