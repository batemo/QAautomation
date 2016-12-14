package Step;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.IOException;

/**
 * Created by BatEmo on 11/5/2016.
 */
public class TakeScreenshot {

    public void takeShot(String shotName) throws IOException{
        WebDriver driver = new FirefoxDriver();
        File scr = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        System.out.println(scr.getAbsolutePath());
        File dest = new File("C:\\Users\\BatEmo\\IdeaProjects\\Screenshots\\" + shotName + ".png");
        FileUtils.copyFile(scr, dest);
    }
}
