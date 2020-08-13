Feature: BuildingUnit > Manage Contact
##contact
Scenario: verify that user open the Add new contact detail and check validations
Given Open the url and login with the valid details
When User click on the MyApplication and select the building unit
Then click on the unit contact from sidebar
Then verify that the unit contact validation error shows below the field
Then click on the Add unit contact button 
Then click on the unit contact submit button
Then click on unit contact remove button