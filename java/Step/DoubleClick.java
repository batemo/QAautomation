package Step;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by BatEmo on 12/13/2016.
 */
public class DoubleClick extends Autocomplete{


    @BeforeClass
    @Override
    public void setUp() {
        super.setUp();
    }

    @AfterClass
    @Override
    public void tearDown() {
        super.tearDown();
    }

    @Test
    public void doubleClick() throws Exception{
        this.driver.get("http://only-testing-blog.blogspot.in/2014/09/selectable.html");
        WebElement element = driver.findElement(By.xpath("//button[contains(text(),'Double-Click Me To See Alert')]"));

        Actions action = new Actions(driver);
        action.doubleClick(element);
        action.perform();

        Thread.sleep(3000);
        String alert_message = driver.switchTo().alert().getText();
        driver.switchTo().alert().accept();
        System.out.println(alert_message);
    }
}
