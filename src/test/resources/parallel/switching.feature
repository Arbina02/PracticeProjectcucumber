Feature: Switching windows

Scenario: Switching Window
Given User redirected to Practice page 
When User click on Open window button
Then User will navigate to new window

Scenario: Switching Tab
Given User redirected to Practice page
When  User click on Open Tab button
Then User will navigate to new Tab

Scenario: Swithing to Alert
Given User redirected to Practice page
When  User click on Alert option
Then  User  click on confirm option
And  User Add data and perform related function
