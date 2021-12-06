import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class sel_alertBox {

    public static void main(String [] args) throws InterruptedException{

        System.setProperty("webdriver.chrome.driver","F:\\Soft\\chromedriver.exe");
        WebDriver driver =new ChromeDriver();
        driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_prompt");
        driver.manage().window().maximize();
        WebElement frame1= driver.findElement(By.id("iframeResult"));
        driver.switchTo().frame(frame1);

        driver.findElement(By.xpath("/html/body/button")).click();
        driver.switchTo().alert().sendKeys("samsung");
        driver.switchTo().alert().accept();
        driver.switchTo().parentFrame();
        System.out.println(driver.getTitle());
        driver.quit();
    }
}
