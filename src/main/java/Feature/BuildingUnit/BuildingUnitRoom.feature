Feature: BuildingUnit > Manage Rooms
Scenario: verify that user can able to manage room for buildingunit 
Given Open the url and login with the valid data room for buildingunit
When User click on the MyApplication > Buildingunit> select building room
Then Check validation for Edit buildingunit room 
Then Add and verify default buildingunit room 
Then Update and verify newfloor buildingunit room 
Then Delete and verify buildingunit room 