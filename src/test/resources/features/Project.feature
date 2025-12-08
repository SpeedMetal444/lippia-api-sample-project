@Project
Feature: Projects on Clockify Workspaces
  As a Clockify user I want to review my workspaces so that I can interact with my projects

  Background:
    Given With an account and a Mzc2NTU1NTAtYzhmNi00NWVmLWI5Y2MtMDgyYmNlOGVlYThm api key on Clockify
    And With the workspace named HardBrick selected

  @GetProjectsFromWorkspace
  Scenario: Getting the projects from different workspaces
    When I perform a 'GET' to 'PROJECT' endpoint with the 'projectJson' and ''
    Then status code 200 is obtained
    And Print response