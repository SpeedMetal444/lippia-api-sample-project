@Workspaces
Feature: Workspace on Clockify
  As a Clockify user I want to perform a request to get a proper response from my Workspaces

  Background:
    Given With an account and a Mzc2NTU1NTAtYzhmNi00NWVmLWI5Y2MtMDgyYmNlOGVlYThm api key on Clockify

  @GetAllMyWorkspaces
  Scenario: Get all my workspaces
    When I perform a 'GET' to 'WORKSPACE' endpoint with the 'workspacesJson' and ''
    Then status code 200 is obtained
    And Print response