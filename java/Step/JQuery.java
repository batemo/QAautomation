package Step;

import javafx.stage.Screen;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created by BatEmo on 12/14/2016.
 */
public class JQuery extends Autocomplete{

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
    public void jquery(){

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("return ");
    }
}
