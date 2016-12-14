package Page;

import org.openqa.selenium.WebDriver;

/**
 * Created by BatEmo on 11/16/2016.
 */
public class ABVPage {

    public static String chromeDriver = "webdriver.gecko.driver";
    public static String chromeDriverPath = "C:/Users/BatEmo/IdeaProjects/geckodriver.exe";
    public static String siteURl = "https://www.abv.bg/";
    public static String username = ".abv-passport:nth-of-type(1) .abv-error";
    public static String password = ".abv-passport:nth-of-type(2) .abv-error";
    public static String password2 = ".abv-passport:nth-of-type(3) .abv-error";
    public static String phone = ".abv-passport:nth-of-type(4) .abv-error";
    public static String name = ".abv-passport:nth-of-type(5) .abv-error";
    public static String familiyName = ".abv-passport:nth-of-type(6) .abv-error";
    public static String gender = "//form[@id='regform']/div[11]/div";
    public static String date = "//form[@id='regform']/div[12]/div[2]";
    public static String code = "//form[@id='regform']/div[14]/div[2]";
}
