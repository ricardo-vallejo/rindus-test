package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pages.HomePage;

import static hooks.BaseTest.driver;
import static hooks.BaseTest.goTo;

public class HomePageSteps {

    // Page Objects
    HomePage homePage = new HomePage(driver);

    @Given("the user goes to amazon page")
    public void theUserGoesToAmazonPage() {
        goTo("https://www.amazon.com/");
    }

    @And("search {string}")
    public void search(String itemToSearch) {
        homePage.searchItem(itemToSearch);
    }

    @When("the user clicks on Cart icon")
    public void theUserClicksOnCartIcon() {
        homePage.openShoppingCart();
    }
}
