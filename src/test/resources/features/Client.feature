@Clients
Feature: Clients from workspaces on Clockify
  As a Clockify user I want to review my workspaces so that I can interact with my clients

  Background:
    Given With an account and a Mzc2NTU1NTAtYzhmNi00NWVmLWI5Y2MtMDgyYmNlOGVlYThm api key on Clockify
    And With the workspace named HardBrick selected

  @GetAllMyClients
  Scenario: Getting the clients from different workspaces

  @GetAClient
  Scenario: Getting a client by its id

  @CreateAClient
  Scenario: Creating a client on the selected workspace

  @DeleteAClient
  Scenario: Deleting a client from the selected workspace