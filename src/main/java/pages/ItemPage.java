package pages;

import common.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class ItemPage extends BasePage {

    // Elements
    @FindBy(css = "#selectQuantity [id$='-announce']")
    WebElement quantityButton;

    @FindBy(css = ".a-nostyle.a-list-link")
    WebElement quantityList;

    @FindBy(id = "add-to-cart-button")
    WebElement addCartBtn;

    /**
     * Constructor inherited from BasePage
     * @param driver
     */
    public ItemPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
    }

    // Methods
    public void selectQuantity(int quantity){
        quantityButton.click();
        quantityList.findElement(By.cssSelector("[data-value='{\"stringVal\":\""+quantity+"\"}']")).click();
    }

    public void addToCart(){
        addCartBtn.click();
    }

}
