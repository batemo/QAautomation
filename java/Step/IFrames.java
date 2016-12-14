package Step;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by BatEmo on 12/6/2016.
 */
public class IFrames {

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
    public void iFrames() throws Exception{

        driver.get("http://www.dwuser.com/education/content/the-magical-iframe-tag-an-introduction/");


        JavascriptExecutor exe = (JavascriptExecutor) driver;
        Integer numberOfFrames = Integer.parseInt(exe.executeScript("return window.length").toString());
        System.out.println("Number of iframes on the page are " + numberOfFrames);

        driver.switchTo().frame(0);
        WebElement element = (new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated
                        (By.xpath("//h1[contains(text(),'Dangerous Winter Storm over the Northern Plains')]"))));

        //Thread.sleep(4000);
        driver.switchTo().defaultContent();

        driver.switchTo().frame("myDemoFrame");
        WebElement element2 = (new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated
                        (By.xpath("//h1[contains(text(),'Dangerous Winter Storm over the Northern Plains')]"))));

        driver.switchTo().defaultContent();
    }
}
