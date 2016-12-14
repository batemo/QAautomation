package Step;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

/**
 * Created by BatEmo on 12/8/2016.
 */
public class UploadFile{

    WebDriver driver;

 @BeforeClass
 public void setUp(){
     driver = new FirefoxDriver();

     driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
     driver.manage().window().maximize();
 }

  @AfterClass
  public void tearDown(){
      driver.quit();
  }

    @Test
    public void uploadFile() throws Exception{
        driver.navigate().to("http://www.globalsqa.com/samplepagetest/");
        WebElement upload = driver.findElement(By.cssSelector("input[name='file-553']"));
        upload.sendKeys("D:\\Books\\QA Automation course\\Lesson 13 - Selenium\\Checkboxes.png");
    }
}
