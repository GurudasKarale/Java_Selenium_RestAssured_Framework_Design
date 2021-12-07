import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;


public class swag_labs {
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

    @Test(priority = 1)
    public void login()  throws InterruptedException{

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        System.out.println("Logged in successfully");
        Thread.sleep(2000);

    }

    @Test(priority = 2)
    public void addtoCartCheckout() throws InterruptedException{

        driver.findElements(By.className("btn_inventory")).get(1).click();
        driver.navigate().to("https://www.saucedemo.com/cart.html");
        Thread.sleep(2000);
        driver.findElement(By.id("checkout")).click();
        driver.findElement(By.id("first-name")).sendKeys("a");
        driver.findElement(By.id("last-name")).sendKeys("b");
        driver.findElement(By.id("postal-code")).sendKeys("c");
        driver.findElement(By.id("continue")).click();
        System.out.println("proceed with checkout");
        Thread.sleep(2000);

    }

    @Test(priority = 3)
    public void finishCheckout(){

        //driver.findElement(By.xpath("//*[@id=\"checkout_summary_container\"]/div/div[2]/div[7]")).getText();
        driver.findElement(By.id("finish")).click();
        System.out.println(" checkout complete");

    }

    @Test(priority = 4)
    public void logout() throws InterruptedException{

        driver.findElement(By.id("react-burger-menu-btn")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("logout_sidebar_link")).click();
        System.out.println("Logged out!!!");

    }

    @AfterTest
    public void teardown(){
        driver.close();
    }
}