Feature: Agent Front-End Functionality

  Background: 
    Given user launch chrome browser
    When user opens URL "https://phptravels.net/login"

  Scenario Outline: Agent login with invalid credentials
    When user enters email as "<email>" and password as "<password>"
    And click on login
    Then user should get an error message
    And Page title should be "Login - PHPTRAVELS"
    Then Close browser

    Examples: 
      | email                | password  |
      | abc@gmail.com        | demoagent |
      | agent@phptravels.com | agentdemo |
      | agentphptravels.com  | abcde     |

  Scenario: Agent login with valid credentials and verifying Logout functionality
    When user enters email as "agent@phptravels.com" and password as "demoagent"
    And click on login
    Then Page title should be "Dashboard - PHPTRAVELS"
    When user click on logout link
    Then Page title should be "Login - PHPTRAVELS"
    And Close browser

  Scenario: Verifying My Booking Functionality
    Given user is on Agent Dashboard
    And user check for My booking icon and click on it
    Then Page title should be "Bookings - PHPTRAVELS"
    Then Close browser

  Scenario: Verifying Add Funds Functionality
    Given user is on Agent Dashboard
    And user check for Add Fund icon and click on it
    Then Page title should be "Add Funds - PHPTRAVELS"
    Then Close browser

  Scenario: Verifying My Profile Functionality
    Given user is on Agent Dashboard
    And user check for My Profile icon and click on it
    Then Page title should be "Profile - PHPTRAVELS"
    Then Close browser

  Scenario Outline: Check for Hotel link and search hotel by city
    Given user is on Agent Dashboard
    And user check for Hotel icon and click on it
    Then Page title should be "Search Hotels - PHPTRAVELS"
    And user search hotel by city "<city>"
    Then Page tile should be "<page title>"
    Then Close browser

    Examples: 
      | city  | page title                   |
      | dubai | Hotels in dubai - PHPTRAVELS |

  Scenario: Check for Flight link
    Given user is on Agent Dashboard
    And user check for Flight icon and click on it
    Then Page title should be "Search flights - PHPTRAVELS"
    Then Close browser

  Scenario: Check for Tours link
    Given user is on Agent Dashboard
    And user check for Tour icon and click on it
    Then Page title should be "Search Tours - PHPTRAVELS"
    Then Close browser

  Scenario: Check for Visa link
    Given user is on Agent Dashboard
    And user check for Visa icon and click on it
    Then Page title should be "Submit Visa - PHPTRAVELS"
    Then Close browser

  Scenario: Check for Blog link
    Given user is on Agent Dashboard
    And user check for Blog link and click on it
    Then Page title should be "Blog - PHPTRAVELS"
    Then Close browser

  Scenario: Check for Offers link
    Given user is on Agent Dashboard
    And user check for Offers link and click on it
    Then Page title should be "Offers - PHPTRAVELS"
    Then Close browser

  Scenario: Verifying whether it is possible to convert USD to INR amount
    Given user is on Agent Dashboard
    And user click on USD link a dropdown menu is shown
    Then user select INR from the dropdown menu
    Then Close browser
