Feature: Login functionality

@sanity
Scenario: Successful login with valid credentials
  Given user is on login page
  When user enters user email as "sandracassonello@hotmail.com" and password "test"
  And clicks login button
  Then user should see home page

Scenario: Unsuccessful login with invalid credentials
  Given user is on login page
  When user enters user email as "test@hotmail.com" and password "123"
  And clicks login button
  Then user should see an error message

@negative
Scenario: Login with invalid credentials but expecting success (deliberate fail)
  Given user is on login page
  When user enters user email as "test@hotmail.com" and password "123"
  And clicks login button
  Then user should see an error message

Scenario: Login with empty email and password
  Given user is on login page
  When user enters user email as "" and password ""
  And clicks login button
  Then user should see an error message

Scenario: Login with empty email and valid password
  Given user is on login page
  When user enters user email as "" and password "test"
  And clicks login button
  Then user should see an error message

Scenario: Login with valid email and empty password
  Given user is on login page
  When user enters user email as "sandracassonello@hotmail.com" and password ""
  And clicks login button
  Then user should see an error message
  
  
  
  Scenario Outline:Login with different users
  Given the user enters username "<username>"
  And the user enters password "<password>"
  Then login should be successful
  
  Examples:
  | username | password |
  | admin    | admin123 |
  | user 1   | pass123  |
  | user 2   | pass234  |
  
  
  Scenario:Login with multiple users
  Given the user enters login data
  |username | password |
  | admin    | admin123 |
  | user 1   | pass123  |
  | user 2   | pass234  |
  
  
  
  
  
  
  
