Feature: Supplier Back-End Functionality

  Background: 
    Given user launch Chrome Browser
    When user opens url "https://www.phptravels.net/supplier"

  Scenario Outline: Supplier login with invalid credentials
    When user enters Email  as "<email>" and Password as "<password>"
    And click on Login
    Then user should get an Error message "<message>"
    And Page Title should be "Supplier Login"
    Then Close Browser

    Examples: 
      | email                   | password     | message                                             |
      | supplier@phptravels.com | abcd         | Invalid Login Credentials                           |
      | supplierphptravels.com  | demosupplier | The Email field must contain a valid email address. |
      |                         | demosupplier | The Email field is required.                        |
      | supplier@phptravels.com |              | The Password field is required.                     |

  Scenario: Supplier login with valid credentials
    When user enters Email  as "supplier@phptravels.com" and Password as "demosupplier"
    And click on Login
    Then Page Title should be "Dashboard"
    And Close Browser

  Scenario: Check whether the dashboard contains  SALES OVERVIEW AND SUMMARY
    Given user is on Supplier Dashboard
    And user able to see "Sales overview & summary"
    And Close Browser

  Scenario: Check whether the dashboard contains REVENUE BREAKDOWN
    Given user is on Supplier Dashboard
    And user check for "Revenue Breakdown 2023"
    And Close Browser

  Scenario: Check for Tours Module
    Given user is on Supplier Dashboard
    And user check for Tours module
    And user click on Manage Tours
    And Close Browser
