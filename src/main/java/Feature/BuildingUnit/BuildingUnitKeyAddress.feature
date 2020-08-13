Feature: BuildingUnit > Manage KeyAddress
#key adress
Scenario: verify that user open the key adress forms and check validation
Given Open the url and login with the valid unit data keyaddress
When User click on the MyApplication and select the buildingunit key address
Then click on the key address from sidebar
Then verify that the validation error shows below the field for keyaddress unit
Then click on the Add keyadress button for unit
Then click on submit button 
Then click on remove to remove unit keyaddress