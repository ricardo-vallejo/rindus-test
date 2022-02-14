package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import pages.ItemPage;

import static hooks.BaseTest.driver;

public class ItemPageSteps {

    // Page Objects
    ItemPage itemPage = new ItemPage(driver);

    @And("select quantity {int}")
    public void selectQuantity(int quantity) {
        itemPage.selectQuantity(quantity);
    }

    @When("the user clicks on Add to Cart")
    public void theUserClicksOnAddToCart() {
        itemPage.addToCart();
    }
}
