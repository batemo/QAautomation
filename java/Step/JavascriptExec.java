package Step;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by BatEmo on 12/8/2016.
 */
public class JavascriptExec {
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = new FirefoxDriver();

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void scrollDown() {
        driver.get("https://www.seleniumeasy.com/selenium-tutorials/uploading-file-with-selenium-webdriver");
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        WebElement element = driver.findElement(By.xpath("//a[.='Images']"));
        jse.executeScript("arguments[0].scrollIntoView();", element);


        jse.executeScript("window.scrollBy(0,250)");

    }
}

