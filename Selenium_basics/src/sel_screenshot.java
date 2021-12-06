
import java.io.IOException;
import java.util.List;
import java.util.logging.FileHandler;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.File;
import org.apache.commons.io.FileUtils;

public class sel_screenshot {

    public static void main(String [] args) throws IOException {

        System.setProperty("webdriver.chrome.driver","F:\\Soft\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://demo.guru99.com/test/web-table-element.php");

        driver.manage().window().maximize();

        File screenshot= ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        FileUtils.copyFile(screenshot,new File(".//screenshot/screen.png"));

        driver.quit();

    }
}
