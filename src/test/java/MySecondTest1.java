import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MySecondTest1 {

@Test
    public void MyDrivers() {

    WebDriverManager.chromedriver().setup();
    WebDriver driver = new ChromeDriver();

        driver.get("http://redmine.testbase.ru/projects/test/issues");
        driver.findElement(By.id("username"))
                .sendKeys("TestUser");
        driver.findElement(By.id("password"))
                .sendKeys("12345678");
        driver.findElement(By.xpath("//*[@id=\"login-form\"]/form/table/tbody/tr[4]/td[2]/input")).click();
        driver.findElement(By.id("add_filter_select")).click();

    Actions builder = new Actions(driver);

        builder.moveToElement(driver.findElement(By.id("new-object")))
                .click(driver.findElement(By.xpath("//a[@accesskey='7']")));
        Action mouseoverAndClick = builder.build();
        mouseoverAndClick.perform();
        driver.findElement(By.id("issue_subject"))
                .sendKeys("Hello.This is my 2nd test");
        driver.findElement(By.id("issue_description"))
                .sendKeys("LOL KEK");
        driver.findElement(By.xpath("//*[@id=\"issue-form\"]/input[3]")).click();


    String URL = driver.getCurrentUrl();

        if(URL.contains("http://redmine.testbase.ru/issues")){
            System.out.println("TEST IS DONE. U R AMAZING  " + URL + "  CORRECT");
        }
        else {
            System.out.println("TI DOLBOEB, PEREDELIVAY");

        }

    driver.quit();
    }

}