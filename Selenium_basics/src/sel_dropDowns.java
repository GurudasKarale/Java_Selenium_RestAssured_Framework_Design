import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class sel_dropDowns {

    public static void main(String [] args ) throws InterruptedException{

        System.setProperty("webdriver.chrome.driver","F:\\Soft\\chromedriver.exe");
        WebDriver driver =new ChromeDriver();
        driver.get("https://www.sugarcrm.com/au/request-demo/");
        driver.manage().window().maximize();
        WebElement ddown=driver.findElement(By.name("employees_c"));
        Select select=new Select(ddown);

        select.selectByIndex(5);
        Thread.sleep(2000);
        select.selectByValue("level1");
        Thread.sleep(2000);
        select.selectByVisibleText("51 - 100 employees");
        Thread.sleep(2000);
        driver.quit();

    }


}
