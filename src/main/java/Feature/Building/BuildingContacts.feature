Feature: Building > Manage Contact 
##contact
Scenario: verify that user open the Add new connection detail and check validations
Given Open the url and login with the valid detailss
Then User click on the MyApplication Building select building contact
Then click on the contact from sidebar
Then verify that the contact validation error shows below the field
Then click on the Add contact button 
Then click on the contact submit button
Then click on contact remove button