Feature: Create Delegate Ticket & Verify

Scenario: verify that user can create delegated ticket successfully
Given user opens the url and logs in to Loek
When user goes to MyApplication and opens ticket app
Then add and verify delegated order section data
Then add and verify delegated contact section data
Then add and verify delegated financial section data
Then verify delegated ticket failure details
Then verify delegated ticket key details
Then verify delegated ticket appointment details
Then verify delegated ticket order details
Then verify delegated ticket invoice details
Then verify delegated ticket history detail