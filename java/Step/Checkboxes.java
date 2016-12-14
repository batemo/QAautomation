package Step;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

/**
 * Created by BatEmo on 12/7/2016.
 */
public class Checkboxes {

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
    public void checkboxes(){
        driver.get("http://demoqa.com/registration/");

        if ( !driver.findElement(By.cssSelector("input[name='radio_4[]']")).isSelected() )
        {
            driver.findElement(By.cssSelector("input[name='radio_4[]']")).click();
        }

        if ( !driver.findElement(By.cssSelector("My selector here")).isSelected())
        {
            driver.findElement(By.cssSelector("My selector here']")).click();
        }
    }

}
