package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {
    public static WebDriver driver;

    /**
     * Create the browser instance
     */
    @Before
    public void openNavigator(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        resetNavigator();
    }

    /**
     * Close the browser instance
     */
    @After
    public void closeNavigator(){
        driver.quit();
    }

    /**
     * Delete cookies and maximize browser
     */
    public void resetNavigator(){
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
    }

    /**
     * Method to open a URL
     * @param url
     */
    public static void goTo(String url){
        driver.get(url);
    }
}
