package Step;


import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.concurrent.TimeUnit;

/**
 * Created by BatEmo on 9/25/2016.
 */
public class executeJS {

    public String url = "http://dhtmlx.com/docs/products/dhtmlxTree/";


    @Test
    public void lesson11(){

        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        capabilities.setCapability("marionette", true);
        WebDriver driver = new FirefoxDriver(capabilities);

       // System.setProperty("webdriver.chrome.driver", "C:/Users/BatEmo/IdeaProjects/chromedriver.exe");
        //WebDriver driver = new ChromeDriver();


        driver.manage().window().maximize();


        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.get(url);

        try {
            Thread.sleep(1000);
        }catch (InterruptedException e){
            System.out.println("No good!");
        }

        //scroll to element
        WebElement demo = driver.findElement(By.cssSelector(".live-demo-block"));
        Actions actions = new Actions(driver);
        actions.moveToElement(demo);
        actions.perform();

        WebElement dragElementFrom = driver.findElement(By.cssSelector(".selectedTreeRow"));
        //Locate element where you wants to drop.
        WebElement dropElementTo = driver.findElement(By.xpath("//*[@id=\"treebox2\"]/div/table/tbody/tr[2]/td[2]"));

        Actions action = new Actions(driver);

        Action dragDrop = action.dragAndDrop(dragElementFrom, dropElementTo).build();
        dragDrop.perform();

        Actions builder = new Actions(driver);
        Action dragAndDrop = builder.clickAndHold(dragElementFrom)
                .moveToElement(dropElementTo)
                .release(dropElementTo)
                .build();
        dragAndDrop.perform();

        try {
            Thread.sleep(5000);
        }catch (InterruptedException e){
            System.out.println("No good!");
        }

        Actions screenshot = new Actions(driver);




//        driver.get("http://www.w3schools.com/html/html5_draganddrop.asp");
//
//        try {
//            Thread.sleep(1000);
//        }catch (InterruptedException e){
//            System.out.println("No good!");
//        }
//
//        WebElement dragElement = driver.findElement(By.id("div1"));
//        WebElement dropElement = driver.findElement(By.xpath("//*[@id=\"div2\"]"));
//
//        Actions builder2 = new Actions(driver);
//        Action draganddrop2 = builder2.clickAndHold(dragElement)
//                .moveToElement(dropElement)
//                .release(dropElement)
//                .build();
//        draganddrop2.perform();
//
//

//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("javascript:window.scrollBy(250,350)");
//        js.executeScript("");

        driver.close();
        driver.quit();
        }
}

