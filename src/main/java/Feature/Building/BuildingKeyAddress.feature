Feature: Building > Manage KeyAddress
#key adress
Scenario: verify that user open the key adress form and check validation
Given Open the url and login with the valid data keyaddress
Then User click on the MyApplication > Building> select building > keyaddress
Then click on the keyadress from sidebar
Then verify that the validation error shows below the field
Then click on the Add keyadress button
Then click on submit 
Then click on remove 