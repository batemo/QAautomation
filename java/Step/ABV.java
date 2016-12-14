package Step;


import Page.ABVPage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static Page.ABVPage.*;
import static org.testng.Assert.assertEquals;

/**
 * Created by BatEmo on 11/8/2016.
 */
public class ABV {

    public WebDriver driver;

    @Test
    public void goToRegistrationForm() throws Exception {


        //System.setProperty(chromeDriver, chromeDriverPath);
        driver = new FirefoxDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        goToSiteURL();
        clickRegisterLink();
        clickSubmitFormButton();

        assertAbvPotrebitelValidation(username);
        assertPasswordFieldValidation(password);
        assertPassWord2Validation(password2);
        assertPhoneNumberFieldValidation(phone);
        assertNameValidation(name);
        assertNameValidation(familiyName);
        assertGenderValidation(gender);
        assertBirthDateValidation(date);
        assertCodeValidation(code);


        driver.close();
        driver.quit();
    }

    private void assertCodeValidation(String code) {
        assertEquals(driver.findElement(By.xpath(code))
                .getText(), "Моля,попълнете полето.");
    }

    private void assertBirthDateValidation(String date) {
        assertEquals(driver.findElement(By.xpath(date))
                .getText(), "Моля, изберете дата на раждане.");
    }

    private void assertGenderValidation(String gender) {
        assertEquals(driver.findElement(By.xpath(gender))
                .getText(), "Моля, изберете пол.");
    }

    private void assertNameValidation(String name) {
        assertEquals(driver.findElement(By.id(name))
                .getText(), "Това поле не може да съдържа по-малко от 2 символа.");
    }

    private void assertPhoneNumberFieldValidation(String phone) {
        assertEquals(driver.findElement(By.id(phone))
                .getText(), "Това поле не може да съдържа по-малко от 9 символа.");
    }

    private void assertPassWord2Validation(String password2) {
        assertEquals(driver.findElement(By.id(password2))
                .getText(), "Моля, въведете повторно паролата си.");
    }

    private void assertPasswordFieldValidation(String password) {
        assertEquals(driver.findElement(By.id(password))
                .getText(), "Това поле не може да съдържа по-малко от 6 символа.");
    }

    private void assertAbvPotrebitelValidation(String username) {
        assertEquals(driver.findElement(By.id(username))
                .getText(), "Това поле не може да съдържа по-малко от 3 символа.");
    }

    private void clickSubmitFormButton() {
        driver.findElement(By.cssSelector("input[value= \"Създай АБВ Профил\"]")).click();
    }

    private void clickRegisterLink() {
        driver.findElement(By.xpath("//div[@id='leftSide']/a[2]/strong")).click();
    }

    private void goToSiteURL() {
        driver.get(siteURl);
    }

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}