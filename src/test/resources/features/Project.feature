@Projects
Feature: Projects on Clockify Workspaces
  As a Clockify user I want to review my workspaces so that I can interact with my projects

  Background:
    Given With an account and a Mzc2NTU1NTAtYzhmNi00NWVmLWI5Y2MtMDgyYmNlOGVlYThm api key on Clockify
    And With the workspace named HardBrick selected

  @GetProjectsFromWorkspace
  Scenario: Getting the projects from different workspaces
    When I perform a 'GET' to 'PROJECT' endpoint with the 'projectsJson' and ''
    Then status code 200 is obtained
    And Print response

  @CreateANewProject
  Scenario: Creating a project on the selected workspace
    When I perform a 'POST' to 'PROJECT' endpoint with the 'projectsJson' and 'name:TestLippia'
    Then status code 201 is obtained
    And Print response

  @FindProjectById
  Scenario: Getting a project by its id
    When I perform a 'GET' to 'PROJECT' endpoint with the 'projectJson' and 'projectId:692e556f5f6071272393a77c'
    Then status code 200 is obtained
    And Print response
    
  @DeleteProject
  Scenario: Deleting a project from the selected workspace
    When I perform a 'PUT' to 'PROJECT' endpoint with the 'projectJson' and 'projectId:6937484621a5ed759263ce88,archived:true'
    Then status code 200 is obtained
    And I perform a 'DELETE' to 'PROJECT' endpoint with the 'projectJson' and 'projectId:6937484621a5ed759263ce88'
    Then status code 200 is obtained
    And Print response