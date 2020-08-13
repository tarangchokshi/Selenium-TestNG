 # invoice adress Building > Manage Invoice 
Feature: open the Invoice adress tab and perform an action
Scenario: verify that user can able to add new billing adress detail
Given Open an url and login with the valid detail
Then User click on the MyApplication > Building> select building > invoiceaddress
Then click on the invoiceadress from sidebar
Then keep the new invoiceadress field blank and check validation
Then click on the Add newbilling adress button
Then click on remove invoice button