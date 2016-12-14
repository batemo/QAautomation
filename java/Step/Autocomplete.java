package Step;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by BatEmo on 12/7/2016.
 */
public class Autocomplete {
    WebDriver driver;
    @BeforeClass
    public void setUp(){
        this.driver = new FirefoxDriver();

        this.driver.manage().window().maximize();
        this.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @AfterClass
    public void tearDown(){
        this.driver.quit();
    }

    @Test
    public void autocomplete(){
        driver.get("http://demoqa.com/autocomplete/");
        driver.findElement(By.xpath("//input[@id='tagss']")).sendKeys("ac");
        List<WebElement> dropdownOptions = driver.findElements(By.cssSelector(".ui-autocomplete li"));

        for (WebElement option:dropdownOptions
             ) {
            String actionScript = option.getText();
            if (actionScript.equalsIgnoreCase("ActionScript")){
                option.click();
                break;
            }
        }
    }
}
