import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.Assert.*;
import org.junit.Test;

public class sel_1 {

    public static void main(String []  args){
        System.setProperty("webdriver.chrome.driver","F:\\Soft\\chromedriver.exe");
        WebDriver driver =new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
        String currenturl=driver.getCurrentUrl();
        System.out.println(currenturl);
        System.out.println(driver.getTitle());
        System.out.println(driver.getPageSource());
        //driver.navigate().to("https://www.google.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();
        driver.navigate().to("https://www.google.com/");
        System.out.println(driver.getWindowHandle());
        driver.quit();

    }
}
