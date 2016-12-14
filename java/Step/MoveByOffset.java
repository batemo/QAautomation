package Step;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created by BatEmo on 12/13/2016.
 */
public class MoveByOffset extends Autocomplete {

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
    public void moveByOffset() throws Exception{
        driver.get("http://www.theautomatedtester.co.uk/demo2.html");
        WebElement drag = driver.findElement(By.className("draggable"));
        new Actions(driver).dragAndDropBy(drag, 150, 200).build() .perform();

        Actions builder = new Actions(driver);
        builder.dragAndDropBy(drag ,456 ,789).build().perform();
        Thread.sleep(4000);
    }
}
