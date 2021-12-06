import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import java.io.*;
import java.util.*;

public class sel_radioButton {

    public static void main(String [] args ) throws InterruptedException{

        System.setProperty("webdriver.chrome.driver","F:\\Soft\\chromedriver.exe");
        WebDriver driver =new ChromeDriver();
        driver.get("https://www.singaporeair.com/en_UK/in/home#/book/bookflight");
        driver.manage().window().maximize();

//        WebElement radio = driver.findElement(By.id("doi0"));
//        Actions action = new Actions(driver);
//        action.moveToElement(radio);
//        action.perform();

        WebElement radio1= driver.findElement(By.id("redeemFlights"));
        radio1.click();
        System.out.println(radio1.isSelected());

        Thread.sleep(3000);

//        List<WebElement> noOfRadio
//                = new ArrayList<WebElement>();
//         noOfRadio=driver.findElements(By.xpath("//*[@name='book-flight-radio']"));
//         System.out.println(noOfRadio.size());

        driver.quit();

    }

}
