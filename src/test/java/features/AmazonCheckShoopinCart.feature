Feature: Check Shopping Cart

  Background: Open and Search
    Given the user goes to amazon page
    And search "hats for men"
    And the user select the first result
    And select quantity 2
    When the user clicks on Add to Cart

  @AmazonTest
  Scenario: Check Shopping Cart
    Given the user add 2 hats to the cart
    When the user clicks on Cart icon
    Then the system shows the summary