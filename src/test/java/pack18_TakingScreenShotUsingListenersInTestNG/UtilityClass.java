package pack18_TakingScreenShotUsingListenersInTestNG;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UtilityClass {

    static WebDriver driver;

    public void takeScreeShotWithTimeStamp(String fileName) {
        TakesScreenshot screenShot = (TakesScreenshot) driver;
        File sourceFile = screenShot.getScreenshotAs(OutputType.FILE);
        Date date = new Date();
        SimpleDateFormat formatOfDate = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
        String formattedDate = formatOfDate.format(date);

        File destFile = new File(System.getProperty("user.dir") + "\\Screenshots\\" + fileName + "_" + formattedDate+".png");
        try {
            FileUtils.copyFile(sourceFile, destFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
