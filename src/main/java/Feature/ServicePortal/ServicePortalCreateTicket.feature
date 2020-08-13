Feature: ServicePortal > Create Ticket from Service Portal & Make its Performing and generate Invoice. 

Scenario: verify that user can create service portal ticket and performing ticket
Given Login with mail site and go to service portal > setting > find and click on portal url 
Then verify that username and serviceportal page shown as expected
Then go to my profile and get data
Then check validation for creating ticket
Then fill address and ticket section detail
Then verify contact section data
Then verify the Overview detail and click on the send notification
Then Verify that detail shown in the reported fault is correct or not
Then verify the ticket in ticketapp
Then create performing ticket