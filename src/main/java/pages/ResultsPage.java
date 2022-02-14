package pages;

import common.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class ResultsPage extends BasePage {

    // Elements
    @FindBy(css = "img[data-image-index='2']")
    WebElement itemToSelect;

    /**
     * Constructor inherited from BasePage
     * @param driver
     */
    public ResultsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
    }

    // Methods
    public void clickItem(){
        if (validateElement(itemToSelect)){
            itemToSelect.click();
        }
    }
}
