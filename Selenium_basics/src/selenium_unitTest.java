import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.*;

public class selenium_unitTest {

    static WebDriver driver;

    @BeforeClass
    public static void setUp(){

        System.setProperty("webdriver.chrome.driver","F:\\Soft\\chromedriver.exe");
        driver=new ChromeDriver();
        driver.get("https://www.tutorialspoint.com/index.htm");
        driver.manage().window().maximize();
    }

    @Test
    public void verifyTitle(){

        String title=driver.getTitle();
        assertTrue(title.contains("Biggest Online"));
    }

    @AfterClass
    public static void tearDown(){
        driver.quit();
    }
}
