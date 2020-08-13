Feature: BuildingUnit > Manage invoiceAddress
Scenario: verify that user can be able to add new billing adress detail
Given Open the url and login with the valid unit data invoiceaddress
Then User click on the MyApplication and select the buildingunit invoice
Then click on invoiceadress link from sidebar
Then verify that the validation error shows below the field for invoiceaddress unit
Then click on the Add invoiceaddress button for unit
Then click on remove to remove unit invoiceaddress