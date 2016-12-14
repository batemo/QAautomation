package Step;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by BatEmo on 12/7/2016.
 */
public class DatePicker {
    WebDriver driver;
    @BeforeClass
    public void setUp(){
        driver = new FirefoxDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void datepicker(){
        driver.get("http://demoqa.com/datepicker/");
        driver.findElement(By.xpath("//input[@id ='datepicker1']")).click();

        List<WebElement> allDates = driver.findElements(By.cssSelector("td .ui-state-default"));

        for (WebElement date:allDates) {
            String dateText = date.getText();
            if (dateText.equalsIgnoreCase("25")){
                date.click();
                break;
            }
        }
    }
}
