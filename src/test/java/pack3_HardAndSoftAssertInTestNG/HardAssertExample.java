package pack3_HardAndSoftAssertInTestNG;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HardAssertExample {
    @Test
    public void testFacebook() {
        //Hard assert
        WebDriverManager.getInstance(DriverManagerType.CHROME).setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.facebook.com/");
        String actualTitleToBeVerified = "Facebook – log in or sign up";
        Assert.assertEquals(driver.getTitle(), actualTitleToBeVerified, "Verifying facebook title");
        driver.findElement(By.name("email")).sendKeys("abc@720");
        String valueTypedFromUI = driver.findElement(By.name("email")).getAttribute("value");
        Assert.assertTrue(valueTypedFromUI.equals("abc@720"));
        driver.quit();
    }

    @Test
    public void testFacebookCertainScenarios() {
        //soft assert
        WebDriverManager.getInstance(DriverManagerType.CHROME).setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com/");

        SoftAssert sft = new SoftAssert();
        //title verified
        String actualTitleToBeVerified = "Facebook – log in or sign up kkkkkkkkkkkkkkkkkkkkkkkk";
        sft.assertEquals(driver.getTitle(), actualTitleToBeVerified, "Verifying facebook title: ");

        driver.findElement(By.name("email")).sendKeys("abc");
        driver.findElement(By.name("pass")).sendKeys("abc");
        driver.findElement(By.name("login")).click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //url verified
        sft.assertTrue(driver.getCurrentUrl().contains("facebook.in"), "Verifying URL after wrong password entered: ");

        //Red color border verification
        sft.assertEquals(driver.findElement(By.name("email")).getCssValue("border"), "1px solid rgb(240, 40, 73)","Verifying border css: ");

        //Error message validation

        sft.assertTrue(driver.findElement(By.cssSelector("#email_container :nth-child(3)")).getText().contains("The email address or mobile number you entered isn't connected to an account."),"Error message");
        driver.quit();
        sft.assertAll();
    }
}
