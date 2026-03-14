Feature: Login Functionality

@sanity
Scenario Outline:  Login with valid credentials
Given  User navigated to login page
When  User enters valid email address "<username>" in email filed
And User enters valid password "<password>" in password filed
And User clicks on login button
Then User should get sucessfull logged in
Examples:
|username         |password|
|rushi1@gmail.com |11111   |
|rushi2@gmail.com |11111   |
|rushi3@gmail.com |11111   |


@smoke
Scenario Outline:   Login with Invalid credentials
Given  User navigated to login page
When  User enters invalid email address "<username>" in email filed
And User enters invalid password "<password>" in password filed
And User clicks on login button
Then User should get proper warning message about credentials mismatch
Examples:
|username           |password|
|rushi101@gmail.com |11154   |
|rushi202@gmail.com |11178   |
|rushi303@gmail.com |11194   |


Scenario Outline:  Login with valid email and invalid password 
Given  User navigated to login page
When  User enters valid email address "<username>" in email filed
And User enters invalid password "<password>" in password filed
And User clicks on login button
Then User should get proper warning message about credentials mismatch
Examples:
|username         |password|
|rushi1@gmail.com |11112   |
|rushi2@gmail.com |11132   |
|rushi3@gmail.com |11156   |


@regression
Scenario:  Login with Invalid email and valid password 
Given  User navigated to login page
When  User enters invalid email address "<username>" in email filed
And User enters valid password "<password>" in password filed
And User clicks on login button
Then User should get proper warning message about credentials mismatch
Examples:
|username           |password|
|rushi101@gmail.com |11111   |
|rushi202@gmail.com |11111   |
|rushi303@gmail.com |11111   |



Scenario:  Login without provide any credentials 
Given  User navigated to login page
When  User dont enters email address into email filed
And User dont enters valid password into password filed
And User clicks on login button
Then User should get proper warning message about credentials mismatch