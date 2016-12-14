package Step;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Created by BatEmo on 12/14/2016.
 */
public class ExplicitWaits extends Autocomplete {

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
    public void explicitWaits(){

        driver.get("https://www.facebook.com/");
       WebDriverWait wait = new WebDriverWait(driver,5);

        wait.until(ExpectedConditions.textToBePresentInElementValue(By.id("u_0_l"), "Log In"));

        WebElement womanRadioButton = driver.findElement(By.xpath("//input[@id='u_0_h']//following-sibling::label"));
        womanRadioButton.click();

        wait.until(ExpectedConditions.elementToBeSelected(By.id("u_0_h")));

        Assert.assertTrue(wait.until(ExpectedConditions.urlMatches("https://www.facebook.com/")));

        Assert.assertTrue(wait.until(ExpectedConditions.urlContains("facebook")));


        Assert.assertTrue(wait.until
                (ExpectedConditions.titleIs
                        ("Facebook - Log In or Sign Up")));

        wait.until(ExpectedConditions.titleContains("Log In or"));

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("u_0_l")));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("u_0_e")));

        List<WebElement> allTds = driver.findElements(By.cssSelector("tbody td"));
        wait.until(ExpectedConditions.visibilityOfAllElements(allTds));



    }
}
