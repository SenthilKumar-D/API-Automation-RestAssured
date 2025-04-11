Feature: Create new incidents in ServiceNow Api

Scenario: Create new incidents without body in ServiceNow Api


Given Set the baserURI and BasePath for ServiceNow Api
And Set the Authentication for the host
When Create the new incident without body
Then Validate the Response body
And Validate the Status code for the response