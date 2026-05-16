package pack1_CreateFirstTestNGTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class FirstTestNG {
    @Test
    public void testGoogle() {
        //System.setProperty("webdriver.chrome.driver", "path/to/chromedriver.exe");
        //System.setProperty("webdriver.gecko.driver", "path/to/chromedriver.exe");
        //System.setProperty("webdriver.edge.driver", "path/to/chromedriver.exe");
        WebDriverManager.getInstance(DriverManagerType.CHROME).setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com/");
        driver.findElement(By.cssSelector(".gLFyf")).sendKeys("TestNG", Keys.ENTER);
        driver.quit();
    }
    @Test
    public void testFacebook() {
        WebDriverManager.getInstance(DriverManagerType.CHROME).setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.facebook.com/");
        driver.findElement(By.name("email")).sendKeys("abc@720", Keys.ENTER);
        driver.quit();
    }
}
