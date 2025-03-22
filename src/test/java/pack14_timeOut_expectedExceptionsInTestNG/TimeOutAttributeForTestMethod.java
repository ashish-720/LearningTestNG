package pack14_timeOut_expectedExceptionsInTestNG;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class TimeOutAttributeForTestMethod {
    //If we want decide how much time a test method should take to complete(timeout=3000) attr used
    //If we are expecting some exceptions in testmethod we can use to expectedExceptions=That exceptions class

    @Test(timeOut = 20000, expectedExceptions = {NoSuchElementException.class})
    public void login(){
        WebDriver driver;
        WebDriverManager.getInstance(DriverManagerType.CHROME).setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        WebElement username = driver.findElement(By.xpath("//input[@name='Wrong name value']"));
        username.sendKeys("Admin");
        driver.quit();
    }
}
