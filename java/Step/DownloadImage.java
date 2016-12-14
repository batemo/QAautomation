package Step;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Created by BatEmo on 12/13/2016.
 */
public class DownloadImage extends Autocomplete{

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
    public void downloadImage() throws Exception{


        driver.get("http://feelgrafix.com/group/pictures.html");

        WebElement image = driver.findElement(By.cssSelector("img[src='/data/pictures/pictures-1.jpg']"));
        image.click();

        Actions action= new Actions(driver);
        action.contextClick(image).build().perform();

        action.sendKeys(Keys.SHIFT, "v").build().perform();
        Thread.sleep(3000);

        Robot robot = new Robot();
        // To press D key.
        robot.keyPress(KeyEvent.VK_D);
        // To press : key.
        robot.keyPress(KeyEvent.VK_SHIFT);
        robot.keyPress(KeyEvent.VK_SEMICOLON);
        robot.keyRelease(KeyEvent.VK_SHIFT);
        // To press \ key.
        robot.keyPress(KeyEvent.VK_T);
        robot.keyPress(KeyEvent.VK_E);
        robot.keyPress(KeyEvent.VK_S);
        robot.keyPress(KeyEvent.VK_T);
        robot.keyPress(KeyEvent.VK_BACK_SLASH);
        // To press "test" key one by one.

         //To press Save button.
        robot.keyPress(KeyEvent.VK_ENTER);
    }
}

