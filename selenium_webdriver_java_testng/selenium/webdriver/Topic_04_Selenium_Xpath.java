package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Topic_04_Selenium_Xpath {

    WebDriver driver;
    String projectPath = System.getProperty("user.dir");
    String osName = System.getProperty("os.name");

    @BeforeClass
    public void beforeClass() {
        if (osName.contains("Windows")) {
            System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
        } else {
            System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
        }

        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        // driver.get("https://www.facebook.com/");
    }
    @Test
    public void TC_01() {

        driver.get("http://live.techpanda.org/index.php/checkout/cart/");
        // driver.findElement(By.xpath("//div[@class='footer-container']//a[@title='My Account']")).click();

        String successMessgeText = driver.findElement(By.xpath("//div[@class='main-container col1-layout']//span")).getText();
        // confirm đã hien thi dung msg
        Assert.assertEquals(successMessgeText,"Samsung Galaxy was added to your shopping cart." );



    }


    @AfterClass
    public void afterClass() {
        //driver.quit();
    }


}
