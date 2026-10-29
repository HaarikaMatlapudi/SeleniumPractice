import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.time.Duration;

public class SelectDropdown {
    public static void main(String args[]){

        WebDriver driver=new ChromeDriver();
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/dropdown");

        //1)Locate the dropdown
        WebElement dropdown=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("dropdown")));

        //2)Select the option
        Select select=new Select(dropdown);
        select.selectByVisibleText("Option 2");

        //3)Verfication

        String selectedOption=select.getFirstSelectedOption().getText();
        Assert.assertEquals(selectedOption,"Option 2", "Both are not matching");
        if(selectedOption.equals("Option 2")){
            System.out.println("Selected option 2 only, PASS");
        }else{
            System.out.println("FAIL");
        }

        driver.quit();
    }
}
