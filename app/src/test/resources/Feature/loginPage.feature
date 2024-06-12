Feature: Login Functionality of demo Website

  as a user of demo website
  i should be able to login with my account
  so that i can access my account related features

  Background:
    Given I am on the demo site login page

  Scenario Outline: Successful login with valid credentials
    Given I have entered valid "<username>" and "<password>"
    When I click on the login button
    Then I should see a success message indicating "<success_message>"

    Examples:
      | username           | password | success_message    |
      | testmail@gmail.com | test@123 | Login Successfully |

  Scenario Outline: Unsuccessful login with invalid user credentials
    Given I have entered invalid "<username>" and "<password>"
    When I click on the login button
    Then I should see an error message indicating "<error_message>"

    Examples:
      | username            | password  | error_message              |
      | 8464853483          | abAB@1211 | Your password is incorrect |
      | testuser2@email.com | test2     | Your password is incorrect |

    Scenario: Navigating to the Register User page
      When I click on Register link
      Then I should be redirected to the user registration page