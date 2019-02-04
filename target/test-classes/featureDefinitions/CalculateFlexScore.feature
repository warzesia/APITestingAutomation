Feature: Calculate FlexScore based on given FlexOffer and FlexRequest

Scenario: 
	Receive valid FlexScore response by calling the FlexScore API endpoint with valid FlexScore request
	Given System generates a valid FlexScore request
	When The FlexScore Request is sent to the FlexScore API Endpoint
	Then The response should contain Valid Server Code 
		And The response should contain JSON body matching the FlexScore Response Schema
		And The response JSON body should contain valid FlexScore Content
			
Scenario: 
	Receive server error response by calling the FlexScore API endpoint with invalid FlexScore request
	Given System generates an invalid FlexScore request
	When The FlexScore Request is sent to the FlexScore API Endpoint
	Then The response should contain Invalid Server Code
	