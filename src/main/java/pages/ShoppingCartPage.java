package pages;

import common.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class ShoppingCartPage extends BasePage {

    // Elements
    @FindBy(id = "sc-subtotal-label-activecart")
    WebElement subtotalQuantity;

    @FindBy(xpath = "//span[@id='sc-subtotal-amount-activecart']//span[@class='a-size-medium a-color-base sc-price sc-white-space-nowrap']")
    WebElement totalPrice;

    @FindBy(css = ".sc-price.sc-product-price")
    WebElement unitPrice;

    @FindBy(css = ".quantity [id$='-announce']")
    WebElement quantityButton;

    @FindBy(css = ".a-nostyle.a-list-link")
    WebElement quantityList;

    @FindBy(css = "input[value='Delete']")
    WebElement deleteButton;

    /**
     * Constructor inherited from BasePage
     * @param driver
     */
    public ShoppingCartPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);
    }

    // Methods
    public String getQuantityText(){
        String subtotalQuantityText = subtotalQuantity.getText();
        return subtotalQuantityText;
    }

    public String getTotalPrice(){
        String totalPriceText = totalPrice.getText();
        return totalPriceText;
    }

    public String getUnitPriceText(){
        return unitPrice.getText();
    }

    public void selectQuantity(int quantity){
        quantityButton.click();
        quantityList.findElement(By.cssSelector("[data-value='{\"stringVal\":\""+quantity+"\"}']")).click();
    }

    /**
     * Method to calculate the total price
     * @param unitPriceText Unit price text from the page
     * @param quantity Quantity
     * @return Total Price
     */
    public double calculateTotalPrice(String unitPriceText, int quantity){
        double unitPrice = Double.parseDouble(unitPriceText.replace("$", ""));
        return unitPrice * quantity;
    }

    public void elementAvailable(){
        elementAvailable(deleteButton);
    }
}
