@regression
Feature: As an Enggner I need to automate So I can show my awesome automation skills

  Background: 
    Given I am on the userInfo Page

  @smokeTest @createUser
  Scenario: As a User I should be able to add a user and validate the user has been added to the table
    When I add new user with following details
      | novak | bellman | novak_bellman | 1234567 | Company BBB | Admin | novak@gmail.com | 7031234567 |
    And I click on Save button
    Then The added user displays on the user table

  @smokeTest @deleteUser
  Scenario: As a User I should be able to delete a User
    When I find the user with username "novak" and I click on the delete button
    Then A confirmation dialog should appear with the text: "Do you really want to delete the user?"
    When I click on Ok button
    Then The user should be deleted
