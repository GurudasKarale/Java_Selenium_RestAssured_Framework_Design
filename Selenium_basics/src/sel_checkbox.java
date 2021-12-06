import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import javax.swing.*;

public class sel_checkbox {

    public static void main(String [] args ) throws InterruptedException{

        System.setProperty("webdriver.chrome.driver","F:\\Soft\\chromedriver.exe");
        WebDriver driver =new ChromeDriver();
        driver.get("https://www.sugarcrm.com/au/request-demo/");
        driver.manage().window().maximize();

        WebElement radio = driver.findElement(By.id("doi0"));
        Actions action = new Actions(driver);
        action.moveToElement(radio);
        action.perform();

        driver.findElement(By.id("interest_market_c0")).click();
        Thread.sleep(3000);
        driver.quit();

    }
}
