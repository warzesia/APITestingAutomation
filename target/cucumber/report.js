$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("CalculateFlexScore.feature");
formatter.feature({
  "line": 1,
  "name": "Calculate FlexScore based on given FlexOffer and FlexRequest",
  "description": "",
  "id": "calculate-flexscore-based-on-given-flexoffer-and-flexrequest",
  "keyword": "Feature"
});
formatter.before({
  "duration": 238044927,
  "status": "passed"
});
formatter.scenario({
  "line": 3,
  "name": "Receive valid FlexScore response by calling the FlexScore API endpoint with valid FlexScore request",
  "description": "",
  "id": "calculate-flexscore-based-on-given-flexoffer-and-flexrequest;receive-valid-flexscore-response-by-calling-the-flexscore-api-endpoint-with-valid-flexscore-request",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 4,
  "name": "System generates a valid FlexScore request",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "The FlexScore Request is sent to the FlexScore API Endpoint",
  "keyword": "When "
});
formatter.step({
  "line": 6,
  "name": "The response should contain Valid Server Code",
  "keyword": "Then "
});
formatter.step({
  "line": 7,
  "name": "The response should contain JSON body matching the FlexScore Response Schema",
  "keyword": "And "
});
formatter.step({
  "line": 8,
  "name": "The response JSON body should contain valid FlexScore Content",
  "keyword": "And "
});
formatter.match({
  "location": "CalculateFlexScoreSteps.system_generates_a_valid_FlexScore_request()"
});
formatter.result({
  "duration": 114852429,
  "status": "passed"
});
formatter.match({
  "location": "CalculateFlexScoreSteps.the_FlexScore_Request_is_sent_to_the_FlexScore_API_Endpoint()"
});
formatter.result({
  "duration": 490916515,
  "status": "passed"
});
formatter.match({
  "location": "CalculateFlexScoreSteps.the_response_should_contain_Valid_Server_Code()"
});
formatter.result({
  "duration": 174283816,
  "status": "passed"
});
formatter.match({
  "location": "CalculateFlexScoreSteps.the_response_should_contain_JSON_body_matching_the_FlexScore_Response_Schema()"
});
formatter.result({
  "duration": 79791345,
  "status": "passed"
});
formatter.match({
  "location": "CalculateFlexScoreSteps.the_response_JSON_body_should_contain_valid_FlexScore_Content()"
});
formatter.result({
  "duration": 65349686,
  "status": "passed"
});
formatter.after({
  "duration": 73890,
  "status": "passed"
});
formatter.before({
  "duration": 584766,
  "status": "passed"
});
formatter.scenario({
  "line": 10,
  "name": "Receive server error response by calling the FlexScore API endpoint with invalid FlexScore request",
  "description": "",
  "id": "calculate-flexscore-based-on-given-flexoffer-and-flexrequest;receive-server-error-response-by-calling-the-flexscore-api-endpoint-with-invalid-flexscore-request",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 11,
  "name": "System generates an invalid FlexScore request",
  "keyword": "Given "
});
formatter.step({
  "line": 12,
  "name": "The FlexScore Request is sent to the FlexScore API Endpoint",
  "keyword": "When "
});
formatter.step({
  "line": 13,
  "name": "The response should contain Invalid Server Code",
  "keyword": "Then "
});
formatter.match({
  "location": "CalculateFlexScoreSteps.system_generates_an_invalid_FlexScore_request()"
});
formatter.result({
  "duration": 340872,
  "status": "passed"
});
formatter.match({
  "location": "CalculateFlexScoreSteps.the_FlexScore_Request_is_sent_to_the_FlexScore_API_Endpoint()"
});
formatter.result({
  "duration": 433701,
  "status": "passed"
});
formatter.match({
  "location": "CalculateFlexScoreSteps.the_response_should_contain_Invalid_Server_Code()"
});
formatter.result({
  "duration": 145543263,
  "status": "passed"
});
formatter.after({
  "duration": 1309498,
  "status": "passed"
});
});