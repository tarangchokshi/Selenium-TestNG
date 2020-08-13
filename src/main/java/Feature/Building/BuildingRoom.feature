Feature: Building > Manage Room
# Change data
Scenario: verify that user can able to manage room for building 
Given Open the url and login with the valid data room
When User click on the MyApplication > Building> select building room
Then Check validation to add building room
Then Add and verify default building room
Then Update and verify newfloor building room
Then Delete and verify building room