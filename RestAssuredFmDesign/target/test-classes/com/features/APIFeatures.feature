#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: Validate place APIs
  I want to use this template for my feature file

  @tag1
  Scenario Outline: Verify place is correcty added using AddPlace api
    Given Add place Api payload "<name>" "<language>" "<address>"
    When user calls "AddPlaceAPI" with "Post" http request
    Then the API call is success with status code 200
    And "status" in response body is "OK"
    And "scope" in response body is "APP"
    And place_id created maps to "<name>" using "GetPlaceAPI"

	Examples:
		|name | language | address|
		|CJ street house | English | las vegas |
    

	Scenario: Verify if delete place functionality is working
		Given DeletePlace payload
		When user calls "DeletePlaceAPI" with "Post" http request
		Then the API call is success with status code 200
	  And "status" in response body is "OK"
	
	
	
  
  
  
    
    