import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class sel_webtable {

    public static void main(String [] args){

        System.setProperty("webdriver.chrome.driver","F:\\Soft\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://demo.guru99.com/test/web-table-element.php");

        driver.manage().window().maximize();

        List<WebElement> rows= driver.findElements(By.xpath("//*[@id=\"leftcontainer\"]/table/tbody/tr"));
        System.out.println(rows.size());

        List<WebElement> columns= driver.findElements(By.xpath("//*[@id=\"leftcontainer\"]/table/tbody/tr[1]/td"));
        System.out.println(columns.size());

        for(int i=1;i< rows.size();i++){

            for(int j=1;j< columns.size();j++){
                String value=driver.findElement(By.xpath("//*[@id=\"leftcontainer\"]/table/tbody/tr["+ i +"]/td["+ j +"]")).getText();
                        System.out.println(value);
            }
        }
        driver.quit();

    }
}
