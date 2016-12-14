package Step;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import sun.management.Util;
import sun.text.normalizer.Utility;

import java.util.concurrent.TimeUnit;

/**
 * Created by BatEmo on 12/4/2016.
 */
public class AlertBox  {
    ExtentReports report;
    ExtentTest logger;
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

    @Test //accept simple alert box
    public void simpleAlertBox(){
        driver.get("http://www.globalsqa.com/demo-site/alertbox/");
        driver.findElement(By.xpath("//button[contains(text(),'Try it')]")).click();

        Alert simpleAlert = driver.switchTo().alert();


        String alertText = simpleAlert.getText();
        System.out.println("Alert text is " + alertText);

        simpleAlert.accept();




        //possible options with alerts - accept; dismiss;
        //http://www.globalsqa.com/demo-site/alertbox/
    }

    @Test
    public void confirmationBox() throws Exception{
        ExtentReports extent = new ExtentReports("D:\\Downloads\\LearnAutomation.html");
        logger=report.startTest("ConfirmBox: ");


        driver.get("http://www.globalsqa.com/demo-site/alertbox/");
        driver.findElement(By.xpath("//li[contains(text(),'Confirmation Box')]")).click();
        driver.findElement(By.cssSelector("button[onclick=\"myFunctionTab2()\"]")).click();

        logger.log(LogStatus.INFO, "Application is up and running");

        Alert confirmationAlert = driver.switchTo().alert();
        String alertText = confirmationAlert.getText();
        System.out.println("Alert text is " + alertText);
        Thread.sleep(4000);
        //confirmationAlert.accept();
        confirmationAlert.dismiss();
        logger.log(LogStatus.PASS, "Title verified");
    }

    @Test
    public void promptBox() throws Exception{
        driver.get("http://www.globalsqa.com/demo-site/alertbox/");
        driver.findElement(By.xpath("//li[contains(text(),'Prompt Box')]")).click();
        driver.findElement(By.cssSelector("button[onclick=\"myFunctionTab3()\"]")).click();

        Alert promptAlert = driver.switchTo().alert();
        String alertText = promptAlert.getText();
        System.out.println("Alert text is " + alertText);
        promptAlert .sendKeys("Accepting the alert");
        Thread.sleep(4000);
        promptAlert.accept();

//        WebElement element = (new WebDriverWait(driver, 5
//        ).until(ExpectedConditions.presenceOfElementLocated(By.id(""))));
    }
}

