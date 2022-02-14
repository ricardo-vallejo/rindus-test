package pages;

import common.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class HomePage extends BasePage {

    // Elements
    @FindBy(id = "nav-logo-sprites")
    WebElement logoPage;

    @FindBy(id = "twotabsearchtextbox")
    WebElement searchBox;

    @FindBy(id = "nav-cart")
    WebElement shoppingCart;

    /**
     * Constructor inherited from BasePage
     * @param driver
     */
    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);
    }

    // Methods
    public void searchItem(String itemToSearch){
        if (validateElement(logoPage)){
            searchBox.sendKeys(itemToSearch);
            searchBox.sendKeys(Keys.RETURN);
        }
    }

    public void openShoppingCart(){
        shoppingCart.click();
    }
}