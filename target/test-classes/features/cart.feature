Feature: Add to Cart Functionality

  @CartTest
  Scenario: Add a product to the cart
    Given I am on the login page
    When I enter valid credentials
    And I click on the login button
    When User clicks the button for the product
    Then The cart badge displays