Feature: TicketApp > Create External Performing Ticket & Verify

Scenario: verify that user can create external performing ticket successfully
Given user opens the url and login with valid data
When user goes to MyApplication and opens ticket module
Then add and verify order section data
Then add and verify contact section data
Then add and verify financial section data
Then verify external performing ticket failure details
Then verify external performing ticket key details
Then verify external performing ticket appointment details
Then verify external performing ticket order details
Then verify external performing ticket history detail