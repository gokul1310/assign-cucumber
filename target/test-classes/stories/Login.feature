Feature: Login Tests
Narrative: The purpose of this test is to verify login functionality

Scenario: Valid login
Given user is in login page
When he enters username as "admin" and password as "admin"
And clicks on login button
Then emp welcome page is displayed


Scenario: Invalid login username
Given user is in login page
When he enters invalid username as "noadmin" and password as "admin"
And clicks on login button
Then he remains in login screen

Scenario: Invalid login password
Given user is in login page
When he enters invalid username as "admin" and password as "noadmin"
And clicks on login button
Then he remains in login screen