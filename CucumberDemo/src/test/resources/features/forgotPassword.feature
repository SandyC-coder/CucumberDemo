Feature: Forgot Password functionality


 As a registered user
 I want to reset my password
 So I can access to my account if I forget it
 
 Background:
     Given the user is on the login page
     When the user clicks the link "Forgotten Password"
     
   @runThis  
Scenario: Validate the user is able to reset the password
    
    And the user enters an email address as "sandracassonello@hotmail.com"
    And the user clicks on "Continue"
    Then a confirmation message should be displayed


Scenario: User enter an invalid email format
   
    And the user enters an email address as "sandracassonello"
     And the user clicks on "Continue"
    Then the user should see a warning message
    
    
@runThis
Scenario:User enter an unregistered email
        
         And the user enters an email address as "ciccio@hotmail.com"
         And the user clicks on "Continue" 
         Then the user should see a warning message "Warning: The E-Mail Address was not found in our records, please try again!"