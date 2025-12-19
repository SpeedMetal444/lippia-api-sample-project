@Clients
Feature: Clients from workspaces on Clockify
  As a Clockify user
  I want to review my workspaces
  So that I can interact with my clients

  Background:
    Given With an account and a 'Mzc2NTU1NTAtYzhmNi00NWVmLWI5Y2MtMDgyYmNlOGVlYThm' api key on Clockify
    And With the workspace named 'HardBrick' selected

  @GetAllMyClients @Smoke @Regression
  Scenario: Getting the clients from different workspaces
    When I perform a 'GET' to 'CLIENT' endpoint with the 'clientsJson' and ''
    Then status code 200 is obtained
    And Print response

  @GetAClient @Regression
  Scenario: Getting a client by its id
    When I perform a 'GET' to 'CLIENT' endpoint with the 'clientJson' and 'clientId:6928f5ed96220f42b645b890'
    Then status code 200 is obtained
    And Print response

  @CreateAClient @Regression
  Scenario: Creating a client on the selected workspace
    When I perform a 'POST' to 'CLIENT' endpoint with the 'clientsJson' and 'name:TestLippia2'
    Then status code 201 is obtained
    And Print response

  @DeleteAClient @Regression
  Scenario: Deleting a client from the selected workspace
    When I perform a 'DELETE' to 'CLIENT' endpoint with the 'clientJson' and 'clientId:6928f5ed96220f42b645b890'
    Then status code 200 is obtained
    And Print response