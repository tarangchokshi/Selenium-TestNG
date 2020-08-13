Feature: BuildingUnit > Manage Add Manual 

Scenario: verify that get the validation error while mandatory fields are blank 
Given Open application URL
When  User click on the stayobject from sidebar 
Then  click on the Addstayobject link
Then  Keep the form blank and click on the save
Then  verify that validation message shows expected 
Then  User again click on the Addstayobject link
Then  user fill the detail