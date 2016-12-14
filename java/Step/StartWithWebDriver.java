package Step;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by BatEmo on 11/21/2016.
 */
public class StartWithWebDriver{

    WebDriver driver;

    @Before
    public void setUp(){
        driver = new FirefoxDriver();
        //driver.get("http://www.google.com");

        driver.navigate().to("http://www.abv.bg");
        driver.manage()
                .window()
                .maximize();
        driver.manage()
                .timeouts()
                .implicitlyWait(30, TimeUnit.SECONDS);
    }

    @After
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void checkErrorMessages(){
        driver.findElement(By.xpath("//strong[contains(text(),'Регистрирай се!')]"))
                .click();

        Assert.assertTrue
                (driver.findElements(By.xpath("//h2[contains(text(),'Създаване на АБВ Профил')]"))
                        .size() != 0 ); // element is on page
        Assert.assertTrue
                (driver.findElements(By.xpath("//h2[contains(text(),'Създаване на АБВ Профил')]"))
                        .size() == 1); // number of elements == int


        driver.findElement(By.cssSelector("input[value = \"Създай АБВ Профил\"]")).click();

        List<WebElement> errorMessages = driver.findElements(By.cssSelector(".abv-error"));
        for (WebElement element: errorMessages) {
            Assert.assertTrue(element.isDisplayed()); // check multiple elements are displayed
        }

         Assert.assertEquals(driver.findElement(By.xpath("//div[contains(text(),'Моля попълнете полето АБВ потребител.')]"))
                 .getText(), "Моля попълнете полето АБВ потребител.");
        Assert.assertEquals(driver.findElement(By.cssSelector(".abv-row:nth-of-type(1) .abv-error")).getText(),
                "Моля попълнете полето АБВ потребител.");

        ((JavascriptExecutor) driver).executeScript("$('.fr')[1].click()");





    }
}
