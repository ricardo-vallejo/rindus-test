package pages;

import common.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class ConfirmationPage extends BasePage {

    // Page Elements
    @FindBy(xpath = "//span[@class='a-size-medium-plus a-color-base sw-atc-text a-text-bold']")
    WebElement confirmationMessage;

    /**
     * Constructor inherited from BasePage
     * @param driver
     */
    public ConfirmationPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
    }

    //Methods
    public String getConfirmationMessageText(){
        return confirmationMessage.getText();
    }
}
