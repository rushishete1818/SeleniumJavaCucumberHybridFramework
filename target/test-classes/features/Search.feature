Feature: Search functionality

Scenario: User searches for a valid product
Given User opens the application
When User enters valid product "hp" into search box field
And User clicks on search button
Then User should get valid product display in search result

Scenario: User searches for a invalid product
Given User opens the application
When User enters invalid product "honda" into search box field
And User clicks on search button
Then User should get message about no prodct matching

Scenario: User searches without any product
Given User opens the application
When User dont enter any product name into search box field 
And User clicks on search button
Then User should get message about no prodct matching