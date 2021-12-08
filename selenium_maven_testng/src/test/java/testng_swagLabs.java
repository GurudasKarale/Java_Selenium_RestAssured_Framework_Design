import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class testng_swagLabs {

    public String baseUrl = "https://www.saucedemo.com/";
    String driverPath = "F:\\Soft\\chromedriver.exe";
    public WebDriver driver ;

    @BeforeTest
    public void setup() {

        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
        driver.get(baseUrl);
    }

    @Test
    public void Title() {

        Assert.assertEquals(driver.getTitle(),"Swag Labs");
    }

    @AfterTest
    public void teardown(){
        driver.close();
    }

}
