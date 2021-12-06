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

    @Test
    public void login(){

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        System.out.println("Logged in successfully");

    }

//    @Test
//    public void addtoCartCheckout(){
//
//        driver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-backpack\"]")).click();
//        driver.findElement(By.id("checkout")).click();
//        driver.findElement(By.id("first-name")).sendKeys("a");
//        driver.findElement(By.id("last-name")).sendKeys("b");
//        driver.findElement(By.id("postal-code")).sendKeys("c");
//        driver.findElement(By.id("continue")).click();
//        System.out.println("proceed with checkout");
//
//    }
//
//    @Test
//    public void finishCheckout(){
//
//        //driver.findElement(By.xpath("//*[@id=\"checkout_summary_container\"]/div/div[2]/div[7]")).getText();
//        driver.findElement(By.className("medium")).click();
//        System.out.println(" checkout complete");
//
//    }

    @Test
    public void logout(){

        driver.findElement(By.id("react-burger-menu-btn")).click();
        driver.findElement(By.id("logout_sidebar_link")).click();
        System.out.println("Logged out!!!");

    }

    @AfterTest
    public void teardown(){
        driver.close();
    }
}