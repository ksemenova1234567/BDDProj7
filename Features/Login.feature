Feature: Login

Scenario Outline: Valid login
Given user is on the login page
When user enters valid "<username>" and password
And user clicks on the login button
Then user should be logged in
Examples:
|username|
|sroyamt|