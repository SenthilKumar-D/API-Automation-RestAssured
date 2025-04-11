Feature: Create new incidents in ServiceNow Api 

Background: 

	Given Set the baserURI and BasePath for ServiceNow Api 
	And Set the Authentication for the host 


@smoke	
Scenario: Create new incidents without body in ServiceNow Api 

	When Create the new incident without body 
	Then Print the Response body in the console 
	And Validate the Status code for the response 
	

@regression	
Scenario Outline: Create new incidents with body in ServiceNow Api 

	When Send the post request with the description <description name> in the payload 
	And Send the post request with the short description <short description name> in the payload 
	Then Validate the Status code for the response 
	
	Examples: 
	
		|description name|short description name|
		|Description 1|Short description 1|
		|Description 2|Short description 2|