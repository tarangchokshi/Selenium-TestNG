Feature: BuildingUnit > Manage Element

Scenario: verify that user can add new element to stay object 
Given Open an application
When User click on the MyApplication and select the buildingunit
Then click on the unit element from sidebar
Then User click on the add new element to stay object 
Then Keep the form empty
Then verify that validation message show expected 
Then User again click on the add new element to stay object
Then User fill the correct detail and submit
Then verify that it should show the data save successfully message 
Then click on the delete buttons