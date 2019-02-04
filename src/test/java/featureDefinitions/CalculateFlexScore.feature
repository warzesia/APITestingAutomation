Feature: Calculate FlexScore based on given FlexOffer and FlexRequest

Scenario: 
	Receive valid FlexScore response by calling the FlexScore API endpoint 
	with valid FlexScore request
Given System generates a valid FlexScore request
When Valid FlexScore Request is sent to the FlexScore API Endpoint
Then FlexScore API Endpoint should generate a response
	And The response should containt Valid Server Code
	And The response should contain JSON body matching the FlexScore Response Schema
	And The response JSON body should contain valid FlexScore Content