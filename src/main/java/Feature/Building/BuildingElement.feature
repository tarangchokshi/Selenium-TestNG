Feature: Building > Manage BuildingElement

Scenario: verify that user able to add Element succesfully 
Given user click on the Element tab
When  User click on the MyApplication and select the buildings
Then click on the element from sidebar
Then click on the add new elements
Then click submit
Then verify that it should shows the validation error while required field is empty
Then click on the add new element
Then verify that it shows the toast message element added successfully
Then click on the delete button