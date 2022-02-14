package stepdefinitions;

import io.cucumber.java.en.Given;
import pages.ResultsPage;

import static hooks.BaseTest.driver;

public class ResultPageSteps {

    // Page Objects
    ResultsPage resultsPage = new ResultsPage(driver);

    @Given("the user select the first result")
    public void theUserSelectTheFirstResult() {
        resultsPage.clickItem();
    }
}
