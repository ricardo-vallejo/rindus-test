package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import pages.HomePage;
import pages.ShoppingCartPage;

import static hooks.BaseTest.driver;

public class ShoppingCartPageSteps {

    // Page Objects
    ShoppingCartPage cartPage = new ShoppingCartPage(driver);
    HomePage homePage = new HomePage(driver);

    // Variables
    int itemQuantity;
    int itemUpdateQty;

    @When("the user changes the quantity to {int}")
    public void theUserChangesTheQuantityTo(int quantity) {
        itemUpdateQty = quantity;
        cartPage.selectQuantity(itemUpdateQty);
    }

    @Given("the user opens the Cart summary")
    public void theUserOpensTheCartSummary() {
        homePage.openShoppingCart();
    }

    @Given("the user add {int} hats to the cart")
    public void theUserAddHatsToTheCart(int quantity) {
        itemQuantity = quantity;
    }

    @Then("the system shows the summary")
    public void theSystemShowsTheSummary() {
        double totalPrice = cartPage.calculateTotalPrice(cartPage.getUnitPriceText(), itemQuantity);
        Assertions.assertTrue(cartPage.getQuantityText().contains(String.valueOf(itemQuantity)));
        Assertions.assertEquals("$"+totalPrice, cartPage.getTotalPrice());
    }

    @Then("the system update the total")
    public void theSystemUpdateTheTotal() {
        double totalPrice = cartPage.calculateTotalPrice(cartPage.getUnitPriceText(), itemUpdateQty);
        Assertions.assertEquals("$"+totalPrice, cartPage.getTotalPrice());
    }

    @And("the system update the quantity")
    public void theSystemUpdateTheQuantity() {
        Assertions.assertTrue(cartPage.getQuantityText().contains(String.valueOf(itemUpdateQty)));
    }

    @Then("the system refresh the page")
    public void theSystemRefreshThePage() {
        cartPage.elementAvailable();
    }
}
