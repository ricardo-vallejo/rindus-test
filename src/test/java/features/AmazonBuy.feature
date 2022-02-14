Feature: Add items to the cart

  Background: Open and Search
    Given the user goes to amazon page

  @AmazonTest
  Scenario: Buy a hat for men
    Given search "hats for men"
    And the user select the first result
    And select quantity 2
    When the user clicks on Add to Cart
    Then the system shows the confirmation page