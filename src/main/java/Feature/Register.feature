#Feature: Ensure that user can register for Login
#
#Scenario: verify that User Register successfully or not
#Given Open the registration link
#When User click on the registration button and fill the valid detail
#Then user got the registration successfully done message
#
#Scenario: verify that user got the error while email not in correct format 
#Given Open the registration link
#When Enter all valid input and incorrect Email
#Then user should get the validation error for the Email
##
#Scenario: verify that user got error while enter incorrect password 
#Given Open the registration link
#When Enter all valid input and incorrect password
#Then user should get the validation error password does not match
##
#Scenario: verify that user got error message while unchecked the checkbox and click on submit 
#Given Open the registration link
#When Enter allvalid input and uncheck checkbox then clik on signup button
#Then it shows the validation error below the checkbox
#
#Scenario: verify that user clear the dropdown textfield 
#Given Open the registration link
#When click on the close(X)button inside the dropdown
#Then dropdown should be clear
#
#Scenario: verify that user got the notification Email-Adress already use
#Given Open the registration link
#When Enter all valid input field value and use the already used email adress in the email field
#Then it shows the notification email already used
#
#Scenario: verify that header of the page is Free Registration
#Given Open the registration link
#When Observe the header
#Then it should be Free registration




