Feature: Update Shopping Cart

  Background: Open and Search
    Given the user goes to amazon page
    And search "hats for men"
    And the user select the first result
    And select quantity 2
    When the user clicks on Add to Cart

  @AmazonTest
  Scenario: Update quantity
    Given the user opens the Cart summary
    When the user changes the quantity to 1
    Then the system refresh the page
    And the system update the total
    And the system update the quantity