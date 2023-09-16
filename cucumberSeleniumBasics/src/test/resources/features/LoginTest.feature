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
Feature: User Login
  User should be able to login

  @tag1
  Scenario: Testing login with valid credentials
    Given I am on "https://www.saucedemo.com/" login page
    When I enter username as "standard_user" and password as "secret_sauce"
    Then user is logged in successfuly
    

  @tag2
  Scenario: Testing checkout
    Given I am on "https://www.saucedemo.com/" login page
    When I enter username as "standard_user" and password as "secret_sauce"
    Then Add item to cart
    Then Go to cart checkout
    Then Fill the info and finish
    Then user is logged out successfuly
    
    
    
    
    