package common;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    private WebDriver driver;
    protected WebDriverWait wait;

    /**
     * Base Page constructor to initiate the driver and wait object
     * @param driver
     */
    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    /**
     * Method to validate if a element is visible
     * @param element WebElement
     * @return Boolean value
     */
    protected boolean validateElement(WebElement element){
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    /**
     * Method to validate if a element is clickable
     * @param element WebElement
     */
    protected void elementAvailable(WebElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }
}
