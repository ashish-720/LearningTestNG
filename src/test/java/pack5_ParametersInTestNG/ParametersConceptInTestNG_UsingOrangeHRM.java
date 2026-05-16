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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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
        WebElement usernameElement = driver.findElement(By.xpath("//input[@name='txtUsername']"));
        usernameElement.sendKeys(user);
        WebElement passwordElement = driver.findElement(By.xpath("//input[@name='txtPassword']"));
        passwordElement.sendKeys(password, Keys.ENTER);
    }

    @Test
    public void verifyLogin() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#sidebar-profile-picture a.name")));
        String profileName = driver.findElement(By.cssSelector("#sidebar-profile-picture a.name")).getText();
        System.out.println(profileName);
    }

    @Parameters("sleepValue")
    @Test
    public void addEmployee(Long sleep) {
        driver.findElement(By.xpath("//div[@id='top-ribbon-menu']//a[contains(text(),'Employee List')]")).click();
        try {
            Thread.sleep(sleep);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebDriverWait webDriverWait = new WebDriverWait(driver, 4);
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.className("pim-container")));
        System.out.println(driver.findElement(By.cssSelector(".pim-container #addEmployeeButton i")).getText());
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
