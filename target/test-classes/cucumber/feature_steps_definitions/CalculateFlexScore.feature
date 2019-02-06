Feature: Calculate FlexScore based on given FlexOffer and FlexRequest

Scenario: Receive valid FlexScore response by calling the FlexScore API endpoint with valid FlexScore request
	Given System generates a valid FlexScore request
	When The FlexScore Request is sent to the FlexScore API Endpoint
	Then The response should contain Valid Server Code 
		And The response should contain JSON body matching the FlexScore Response Schema
		And The response JSON body should contain valid FlexScore Content
			
Scenario: Receive server error response by calling the FlexScore API endpoint with invalid FlexScore request
	Given System generates an invalid FlexScore request
	When The FlexScore Request is sent to the FlexScore API Endpoint
	Then The response should contain Invalid Server Code
	
	
#TODO: 
# "The response should contain Valid Server Code" and
# "The response should contain Invalid Server Code"
# To be replaced with description containing actual Code (200, 500)..	
	
	
#Scenario: Receive server response in less than 1000 milliseconds when calling it 10 times
#	Given System generates 10 valid FlexScore requests
#	When The 10 FlexScore Request are sent to the FlexScore API Endpoint
#	Then The average response time is less than 1000 milliseconds
	
	