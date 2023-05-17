Feature: Admin Back-End Functionality

  Background: 
    Given user launch Chrome Browser
    When user opens url "https://www.phptravels.net/admin"

  Scenario Outline: Admin login with invalid credentials
    When user enters Email  as "<email>" and Password as "<password>"
    And click on Login
    Then user should get an Error message "<message>"
    And Page Title should be "Administator Login"
    Then Close Browser

    Examples: 
      | email                | password  | message                                             |
      | admin@phptravels.com | abcd      | Invalid Login Credentials                           |
      | adminphptravels.com  | demoadmin | The Email field must contain a valid email address. |
      |                      | demoadmin | The Email field is required.                        |
      | admin@phptravels.com |           | The Password field is required.                     |

  Scenario: Admin login with valid credentials
    When user enters Email  as "admin@phptravels.com" and Password as "demoadmin"
    And click on Login
    Then Page Title should be "Dashboard"
    And Close Browser

  Scenario: Test the link booking and then test the display of Booking invoice where payment is successful
    Given user is on Admin Dashboard
    And user click on Booking link
    Then Page Title should be "All Bookings View"
    And user check for booking invoice where payment is successful
    Then Close Browser

  Scenario: Admin change the booking status from pending to confirmed and verifying the count in dashboard
    Given user is on Admin Dashboard
    And user click on Booking link
    Then user select a record having booking status as Pending and change it to Confirmed
    And user verify the count in dashboard
    Then Close Browser

  Scenario: Admin delete a record having booking status as Cancelled
    Given user is on Admin Dashboard
    And user click on Cancelled booking link
    Then Page Title should be "cancelled Bookings View"
    Then user delete the record having booking status as Cancelled
    Then Close Browser

  Scenario: Verifying Website link functionality
    Given user is on Admin Dashboard
    And user click on Website link
    Then Close Browser
