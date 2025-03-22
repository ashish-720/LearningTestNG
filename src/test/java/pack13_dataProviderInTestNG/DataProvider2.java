package pack13_dataProviderInTestNG;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class DataProvider2 {
    //Performing same operation with different data sets

    WebDriver driver;

    @Test(dataProvider = "LoginDataProvider")
    public void loginToApp(String[] eachRowData) {
        WebDriverManager.getInstance(DriverManagerType.CHROME).setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        WebElement username = driver.findElement(By.xpath("//input[@name='username']"));
        username.sendKeys(eachRowData[0]);
        WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
        password.sendKeys(eachRowData[1], Keys.ENTER);
        String profileName = driver.findElement(By.cssSelector(".oxd-userdropdown-name")).getText();
        Assert.assertEquals(profileName, "Paul Collings", "Validation of profile Name Failed: ");
    }

    @AfterMethod
    public void tearDown(){
        System.out.println("In After Method");
        driver.quit();
    }

    @DataProvider(name = "LoginDataProvider")
    public Object[][] passLoginData() {
        Object[][] dataContainer = new Object[4][2];
        dataContainer[0][0] = "Admin";
        dataContainer[0][1] = "admin123";
        dataContainer[1][0] = "Admin";
        dataContainer[1][1] = "123";
        dataContainer[2][0] = "Ashish";
        dataContainer[2][1] = "admin123";
        dataContainer[3][0] = "Ashish";
        dataContainer[3][1] = "123";
        return dataContainer;
    }
}
