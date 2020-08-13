Feature: ServicePortal > Manage Service Portal & User
Scenario: verify that user can able to create the serviceportal
Given Open the url and login with correct detail
Then User click on the MyApplication >Serviceportal>setting
Then check if portal already exist then first delete it
Then User click on the Create serviceportal and check the validation 
Then user fill the correct detail and Save it
Then verify that it shows the message portal created successfully
Then click on the UserTab and select the AddUser
Then Fill the valid detail and click on the next
Then Fill the detail of the Add User and submit
Then verify that detail of the respective user shown as expected