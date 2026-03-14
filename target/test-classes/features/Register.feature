Feature: Registration Functionality

Scenario: User creates an account only with mandatary fileds
Given User navigate to register account page 
When User enters the details into below fileds
| fname     | ganesh        |
| lname     | suryavanshi   |
| telephone | 9999999999122 |
| password  | 11111         |
And User selects privacy policy
And User click on continue button
Then User account should get create successfully

Scenario: User creates an account with all fileds
Given User navigate to register account page 
When User enters the details into below fileds
| fname     | rahul         |
| lname     | gaikwad       |
| telephone | 9999999999221 |
| password  | 11111         |
And User selects yes for newsletter
And User selects privacy policy
And User click on continue button
Then User account should get create successfully

@smoke
Scenario: User creates a duplicate account
Given User navigate to register account page 
When User enters the details iwith same email and below fileds
| fname    | rushi            | 
| lname    | shete            |
| email    | rushi6@gmail.com |
| telephone| 12345678         |
| password | 11111         	  |
And User selects privacy policy
And User click on continue button
Then User should get a proper warning  about duplicate email

@regression
Scenario: User creates account without filling any details
Given User navigate to register account page 
When User dont enters any details into fileds
And User click on continue button
Then User should get a proper warning  messages for every mandatary filed