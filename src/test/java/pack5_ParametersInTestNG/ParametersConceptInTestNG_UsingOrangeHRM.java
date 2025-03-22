package pack5_ParametersInTestNG;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class ParametersConceptInTestNG_UsingOrangeHRM {
    WebDriver driver;

    @Parameters("browserName")
    @BeforeTest
    public void initializeBrowser(String browser) {
        switch (browser.toLowerCase()){
            case "chrome":
                WebDriverManager.getInstance(DriverManagerType.CHROME).setup();
                driver = new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.getInstance(DriverManagerType.FIREFOX).setup();
                driver = new FirefoxDriver();
                break;
            case "edge":
                WebDriverManager.getInstance(DriverManagerType.EDGE).setup();
                driver = new EdgeDriver();
                break;
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Parameters("url")
    @Test
    public void navigateToApp(String url) {
        driver.get(url);
    }

    @Parameters({"username","password"})
    @Test
    public void loginToApp(String user, String password) {
        WebElement usernameElement = driver.findElement(By.xpath("//input[@name='username']"));
        usernameElement.sendKeys(user);
        WebElement passwordElement = driver.findElement(By.xpath("//input[@name='password']"));
        passwordElement.sendKeys(password, Keys.ENTER);
    }

    @Test
    public void verifyLogin() {
        String profileName = driver.findElement(By.cssSelector(".oxd-userdropdown-name")).getText();
        System.out.println(profileName);
    }

    @Parameters("sleepValue")
    @Test
    public void addEmployee(Long sleep) {
        driver.findElement(By.xpath("//li[@class='oxd-topbar-body-nav-tab']/a[text()='Add Employee']")).click();
        try {
            Thread.sleep(sleep);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(driver.findElement(By.cssSelector(".orangehrm-main-title")).getText());
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
