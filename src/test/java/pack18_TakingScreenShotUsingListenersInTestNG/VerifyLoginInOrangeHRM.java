package pack18_TakingScreenShotUsingListenersInTestNG;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;
@Listeners({ItestListenerImplementationClass.class})
public class VerifyLoginInOrangeHRM extends UtilityClass {

    @Test
    public void verifyLogin() {
        WebDriverManager.getInstance(DriverManagerType.CHROME).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        WebElement username;
        username = driver.findElement(By.xpath("//input[@name='username']"));
        username.sendKeys("Admin");
        WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
        password.sendKeys("admin123", Keys.ENTER);
        String profileName;
        profileName = driver.findElement(By.cssSelector(".oxd-userdropdown-name")).getText();
        Assert.assertEquals(profileName,"Ashish","Validating the profile name: ");
        driver.quit();
    }
}
