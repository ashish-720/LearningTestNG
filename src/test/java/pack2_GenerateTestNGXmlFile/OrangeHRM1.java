package pack2_GenerateTestNGXmlFile;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class OrangeHRM1 {
    WebDriver driver;


    @Test
    public void launchApp() {
        WebDriverManager.getInstance(DriverManagerType.CHROME).setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    @Test
    public void loginToApp() {
        WebElement username = driver.findElement(By.xpath("//input[@name='username']"));
        username.sendKeys("Admin");
        WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
        password.sendKeys("admin123", Keys.ENTER);
    }

    @Test
    public void verifyLogin() {
        String profileName = driver.findElement(By.cssSelector(".oxd-userdropdown-name")).getText();
        System.out.println(profileName);
        driver.quit();
    }

    @Test
    public void addEmployee() {
        driver.findElement(By.xpath("//li[@class='oxd-topbar-body-nav-tab']/a[text()='Add Employee']")).click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(driver.findElement(By.cssSelector(".orangehrm-main-title")).getText());
        driver.quit();
    }
}
