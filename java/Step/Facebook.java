package Step;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by BatEmo on 11/23/2016.
 */
public class Facebook  extends TakeScreenshot{


    WebDriver driver;

    @BeforeClass
    public void setUp() {
        setDriver(new FirefoxDriver());
        getDriver().get("https://www.facebook.com/");
        getDriver().manage().window().maximize();
    }

    @Test
    public void logIn1()throws IOException {

        getDriver().findElement(By.id("email")).sendKeys("1233123");
        getDriver().findElement(By.id("pass")).sendKeys("123123");
        takeShot("123");
        getDriver().findElement(By.cssSelector("input[type = \"submit\"]")).click();
    }

    @Test
    public void seeElementsExist(){
        List<WebElement> languages =  driver.findElements(By.cssSelector("tbody td.plm"));
        Assert.assertTrue(languages.size() != 0);
        for (WebElement lang: languages
             ) {
            Assert.assertTrue(lang.isDisplayed());
        }
    }


    @AfterClass
    public void tearDown() {
        getDriver().quit();
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public void takeShot(String shotName) throws IOException{
        File scr = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        System.out.println(scr.getAbsolutePath());
        File dest = new File("C:\\Users\\BatEmo\\IdeaProjects\\Screenshots\\" + shotName + ".png");
        FileUtils.copyFile(scr, dest);
    }
}

