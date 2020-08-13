Feature: TicketApp > Add Initial Ticket & Verify

Scenario: verify that user able to open the add Ticket succesfully
Given Open the url and login with the valid data ticket
When  User click on the MyApplication and select the ticket
Then update the details
Then verify overview data should be as inserted
Then click on save and verify unit details
Then verify ticket building details
Then verify ticket reporter details
Then verify ticket failure details
Then verify ticket appointment details
Then verify the validation for ticket note
Then add ticket note and verify data
Then remove ticket note
Then add ticket material and verify data
Then remove ticket material
Then verify ticket attachments
Then verify ticket order details
Then verify ticket invoice details
Then verify ticket history details