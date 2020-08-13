Feature: TicketApp > Create Performing Ticket & Verify

Scenario: verify that user can successfully create performing Ticket
Given Open the url and login with valid credentials
When User clicks on MyApplications and selects ticket
Then fill the details and save ticket
Then verify performing ticket failure details
Then verify performing ticket appointment details
Then fill in workorder and verify data
Then verify performing ticket history details
Then make performing and initial tickets report ready
Then verify invoice specifications
Then add and verify invoice workorder