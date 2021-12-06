import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class sel_popUp {

    public static void main(String [] args ) throws InterruptedException{

        System.setProperty("webdriver.chrome.driver","F:\\Soft\\chromedriver.exe");
        WebDriver driver =new ChromeDriver();
        driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_alert");
        driver.manage().window().maximize();
        WebElement frame1= driver.findElement(By.id("iframeResult"));
        driver.switchTo().frame(frame1);

//        WebElement radio = driver.findElement(By.id("doi0"));
//        Actions action = new Actions(driver);
//        action.moveToElement(radio);
//        action.perform();

         driver.findElement(By.xpath("/html/body/button")).click();
         String alerText=driver.switchTo().alert().getText();
         System.out.println(alerText);
         driver.switchTo().alert().accept();
         driver.switchTo().parentFrame();
         System.out.println(driver.getTitle());

         Thread.sleep(2000);

//        List<WebElement> noOfRadio
//                = new ArrayList<WebElement>();
//         noOfRadio=driver.findElements(By.xpath("//*[@name='book-flight-radio']"));
//         System.out.println(noOfRadio.size());

        driver.quit();

    }
}
