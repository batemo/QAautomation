package Step;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * Created by BatEmo on 12/13/2016.
 */
public class RightClick extends Autocomplete{

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
    public void rightClick() throws Exception{
        driver.get("http://abv.bg");
        Actions builder = new Actions(driver);
        WebElement element = driver.findElement(By.tagName("body"));
        Action contextClick = builder.contextClick(element)
                .build();
        contextClick.perform();
        Thread.sleep(4000);
    }
}
