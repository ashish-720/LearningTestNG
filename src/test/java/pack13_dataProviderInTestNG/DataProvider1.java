package pack13_dataProviderInTestNG;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class DataProvider1 {
    //Why data provider?
    //When you do same operation with different sets of data
    WebDriver driver;

    @BeforeTest
    public void browserToBeLaunched() {
        WebDriverManager.getInstance(DriverManagerType.CHROME).setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }

    @Ignore
    @Test
    public void loginToApp() {
        //Problem1 - Here no matter we run the test thousand times it will run with same hardcoded data
        WebElement username = driver.findElement(By.xpath("//input[@name='username']"));
        username.sendKeys("Admin");
        WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
        password.sendKeys("admin123", Keys.ENTER);
        String profileName = driver.findElement(By.cssSelector(".oxd-userdropdown-name")).getText();
        Assert.assertEquals(profileName, "Paul Collings", "Validation of profile Name Failed: ");
    }

    @Test
    public void loginToApp_2() {
        //Problem1-solution - Using java(we can create a design like this)
        login("Admin", "admin123");
        login("Admin", "123");
        login("Ashish", "admin123");
        login("Ashish", "123");
        login("", "");
    }

    public void login(String username, String password) {
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys(username);
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password, Keys.ENTER);
        String profileName = driver.findElement(By.cssSelector(".oxd-userdropdown-name")).getText();
        Assert.assertEquals(profileName, "Paul Collings", "Validation of profile Name Failed: Username: "+username+" ,Password: "+password+" must be wrong");
    }
}
