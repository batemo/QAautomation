package Step;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created by BatEmo on 12/12/2016.
 */
public class DragAndDrop extends Autocomplete {

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
    public void dragAndDrop() throws Exception {
        this.driver.get("https://snook.ca/technical/mootoolsdragdrop/");
        WebElement dragEl = this.driver.findElement(By.id("dragger"));
        WebElement dropEl = this.driver.findElement(By.xpath("//div[contains(text(),'Item 1')]"));

        Actions builder = new Actions(driver);
        builder.dragAndDrop(dragEl, dropEl).build().perform();
        Action dragAndDrop = builder.clickAndHold(dragEl)
                .moveToElement(dropEl)
                .release(dropEl)
                .build();
        dragAndDrop.perform();


    }
}
