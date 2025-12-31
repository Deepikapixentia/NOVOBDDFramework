Feature: validate the Login functionality

Scenario: valid the login with valid credentials

Given user launched the browser
And user launched the application URL
When user enters username data "bdatla@pixentia.com" in username field 
And user enters password data "Test123$" in password field
And user clicks on the Login button
Then user redirects to "ChasmaNOVO" page