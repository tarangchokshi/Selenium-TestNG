Feature: Building > Manage Building
Scenario: verify that user able to open the and building succesfully
Given Open the application URL
When  User click on the MyApplication and select the building  
Then  Verify that title of the page should be As expected
Then User click on the List tab
Then Enter the pincode and number
Then click on the searchbutton
Then click on the add button
Then Verify that record save successfully