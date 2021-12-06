import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class sel_dragAndDrop {

    public static void main(String [] args) throws InterruptedException{

        System.setProperty("webdriver.chrome.driver","F:\\Soft\\chromedriver.exe");
        WebDriver driver =new ChromeDriver();
        driver.get("https://jqueryui.com/droppable/");
        driver.manage().window().maximize();
        WebElement frame1= driver.findElement(By.xpath("//*[@id=\"content\"]/iframe"));
        driver.switchTo().frame(frame1);


        WebElement drag=driver.findElement(By.id("draggable"));
        WebElement drop=driver.findElement(By.id("droppable"));
        Actions action=new Actions(driver);

        action.dragAndDrop(drag,drop).perform();
        Thread.sleep(3000);
        driver.quit();
    }

}
