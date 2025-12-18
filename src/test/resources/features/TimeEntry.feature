@TimeEntry
Feature: Time entries on Clockify
  As a Clockify user
  I want to review my workspaces
  So that I can interact with my projects time entries

  Background:
    Given With an account and a 'Mzc2NTU1NTAtYzhmNi00NWVmLWI5Y2MtMDgyYmNlOGVlYThm' api key on Clockify
    And With the authenticated Clockify user 'Abel Godoy'
    And With the workspace named 'HardBrick' selected

  @GetAClientTimeEntries
  Scenario: Get the time entries for an specific user
    When I perform a 'GET' to 'TIME_ENTRY' endpoint with the 'userTimeEntriesJson' and ''
    Then status code 200 is obtained
    And Print response

  @AddATimeEntryToAProject
  Scenario: Add a time entry to an specific project
    Given With the project named 'TPFinal' selected
    When I perform a 'POST' to 'TIME_ENTRY' endpoint with the 'timeEntriesJson' and 'description:Testing TimeEntry12'
    Then status code 201 is obtained
    And Print response

  @EditATimeEntry
  Scenario: Edit an specific time entry
    When I perform a 'PUT' to 'TIME_ENTRY' endpoint with the 'timeEntryJson' and 'timeEntryId:694356fae1003f759f644d56,description:Testing PUT request'
    Then status code 200 is obtained
    And Print response

  @DeleteATimeEntry
  Scenario: Delete an specific time entry
    When I perform a 'DELETE' to 'TIME_ENTRY' endpoint with the 'timeEntryJson' and 'timeEntryId:694356fae1003f759f644d56'
    Then status code 204 is obtained
    And Print response