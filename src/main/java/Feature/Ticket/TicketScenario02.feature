Feature: TicketApp > Edit Initial Ticket & Verify

Scenario: verify that user able to open the edit Ticket succesfully
Given Open the url and login with the valid data
When User click on MyApplications and select the ticket
Then go to detector section and update the data
Then go to notification section and update the data
Then go to contact section and update the data
Then go to financial section and update the data
Then go to overview section and verify the data
Then verify ticket reporter detail
Then verify ticket failure detail
Then verify ticket key detail
Then verify ticket appointment detail
Then verify ticket order detail
Then verify ticket invoice detail
Then verify ticket history detail
Then remove test suffix