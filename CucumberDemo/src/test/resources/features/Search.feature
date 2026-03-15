Feature: Search functionality
@searchTest
 Scenario:Validate search with an existing product name
   Given the user is on the home page
   When the user enters a "existing" product name in the search field
   And clicks the Search button
   Then the user should see the relevant product displayed in the search results
  
@searchTest
Scenario:Validate search with a non-existing product name
  Given the user is on the home page
  When the user enters a "non-existing" product name in the search field
  And clicks the Search button
  Then the user should receive a message "There is no product that matches the search criteria."
  
  
@searchTest
Scenario:Validate search without providing any product name
  Given the user is on the home page
  When the user enters a "" product name in the search field
  And clicks the Search button
  Then the user should receive a message "There is no product that matches the search criteria."     