package pack13_dataProviderInTestNG;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class DataProvider6 {
    //If we want to feed the sets of data from Dataprovider parallel to the test method instead of sequentially
    //if we give parallel=true as an arg to @DataProvider, It will start running the all individual set parallelly.
    //sYSTEM will stuck if there are 100 sets of data are there and 100 browser instances got open, So there should be some mechanism
    //to rectrict that. Data provider thread count concept came. We need to declare it in testNG xml file at suite level
    WebDriver driver;

    @DataProvider(parallel = true)
    public Object[][] loginDataContainer() {
        return new Object[][]{
                {"Admin", "admin123"},
                {"Admin", "admin"},
                {"Admin", "123"},
                {"wer", "123"}
        };
    }

    @Test(dataProvider = "loginDataContainer")
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
        driver.quit();
    }
}
