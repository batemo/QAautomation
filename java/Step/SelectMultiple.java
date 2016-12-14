package Step;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.awt.*;
import java.util.List;

/**
 * Created by BatEmo on 12/13/2016.
 */
public class SelectMultiple extends Autocomplete{

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
    public void selectMulty() throws Exception{
        driver.get("http://book.theautomatedtester.co.uk/multi-select.html");

        WebElement select = driver.findElement(By.id("selectWithMultipleEqualsMultiple"));

        List<WebElement> options = select.findElements(By.tagName("option"));

        Actions builder = new Actions(driver);
        Action multipleSelect = builder.keyDown(Keys.SHIFT)
                .click(options.get(0))
                .click(options.get(2))
                .build();
        multipleSelect.perform();
    }
}
