Feature: Customer Front-End Functionality

  Background: 
    Given user launch chrome browser
    When user opens URL "https://phptravels.net/login"

  Scenario Outline: Customer login with invalid credentials
    When user enters email as "<email>" and password as "<password>"
    And click on login
    Then user should get an error message
    And Page title should be "Login - PHPTRAVELS"
    Then Close browser

    Examples: 
      | email               | password |
      | abc@gmail.com       | demouser |
      | user@phptravels.com | userdemo |
      | userphptravels.com  | abcde    |

  Scenario: Customer login with valid credentials and verifying Logout functionality
    When user enters email as "user@phptravels.com" and password as "demouser"
    And click on login
    Then Page title should be "Dashboard - PHPTRAVELS"
    When user click on logout link
    Then Page title should be "Login - PHPTRAVELS"
    And Close browser

  Scenario: Verifying MY BOOKING functionalities and check whether customer can view the voucher
    When user is on customer dsahboard
    And click on MY BOOKING icon
    Then Booking  Page title should be "Bookings - PHPTRAVELS"
    When user click on view voucher button
    Then user able to see booking invoice
    And Close browser

  Scenario: Verifying Add funds functionalities and check whether customer can  make a payment of USD50
    When user is on customer dsahboard
    And user Click on ADD FUNDS icon in the Dashboard
    Then Page title should be "Add Funds - PHPTRAVELS"
    And user make a payment of USD50
    And Close browser

  Scenario: Verifying MY PROFILE functionality and check whether customer can  update address in the profile
    When user is on customer dsahboard
    And user Click on My Profile icon in the Dashboard
    Then Page title should be "Profile - PHPTRAVELS"
    And user update address in the profile
    Then user get a message as "Profile updated successfully."
    And Close browser
