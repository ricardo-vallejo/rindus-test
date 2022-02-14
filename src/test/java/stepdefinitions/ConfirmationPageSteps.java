package stepdefinitions;

import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;
import pages.ConfirmationPage;

import static hooks.BaseTest.driver;

public class ConfirmationPageSteps {

    // Page Objects
    ConfirmationPage confirmationPage = new ConfirmationPage(driver);

    @Then("the system shows the confirmation page")
    public void theSystemShowsTheConfirmationPage() {
        Assertions.assertEquals("Added to Cart", confirmationPage.getConfirmationMessageText());
    }
}
