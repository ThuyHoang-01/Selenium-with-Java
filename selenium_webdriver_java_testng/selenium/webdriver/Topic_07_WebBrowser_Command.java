package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Topic_07_WebBrowser_Command {

    WebDriver driver;



    @BeforeClass
    public void beforeClass(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30)); // wait tìm elements
        driver.manage().window().maximize();
    }

    @Test
    public void TC_01_Url(){
        driver.get("http://live.techpanda.org/");
        driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
        // wait cho page -> Sleep
        sleepInSeconds(3);

        driver.getCurrentUrl();
        Assert.assertEquals(driver.getCurrentUrl(), "http://live.techpanda.org/index.php/customer/account/login/");

        driver.findElement(By.xpath("//a[@title='Create an Account']")).click();
        sleepInSeconds(3);

        driver.getCurrentUrl();
        Assert.assertEquals(driver.getCurrentUrl(), "http://live.techpanda.org/index.php/customer/account/create/");

    }

    public void sleepInSeconds(long timeInSeconds){
        try {
            Thread.sleep(timeInSeconds * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void TC_02_Page_Title(){

        driver.get("http://live.techpanda.org/");
        driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
        sleepInSeconds(3);
        Assert.assertEquals(driver.getTitle(),"Customer Login");

        driver.findElement(By.xpath("//a[@title='Create an Account']")).click();
        Assert.assertEquals(driver.getTitle(),"Create New Customer Account");
    }

    @Test
    public void TC_03_Page_Navigation(){

        driver.get("http://live.techpanda.org/");
        WebElement btnClickLogin = driver.findElement(By.xpath("//div[@class='footer-container']//a[@title='My Account']"));
        btnClickLogin.click();
        sleepInSeconds(3);

        driver.findElement(By.xpath("//a[@title='Create an Account']")).click();

        driver.getCurrentUrl();
        Assert.assertEquals(driver.getCurrentUrl(),"http://live.techpanda.org/index.php/customer/account/create/");

        driver.navigate().back();

        driver.getCurrentUrl();
        Assert.assertEquals(driver.getCurrentUrl(),"http://live.techpanda.org/index.php/customer/account/login/");

        driver.navigate().forward();
        Assert.assertEquals(driver.getTitle(),"Create New Customer Account");

    }

    @Test
    public void TC_04_Page_Source(){

        driver.get("http://live.techpanda.org/");
        driver.findElement(By.xpath("//div[@class='footer-container']//a[@title='My Account']")).click();
//
//        Assert.assertEquals(driver.findElement(By.xpath("//div[@class='page-title']")).getText(),"LOGIN OR CREATE AN ACCOUNT");
//        sleepInSeconds(3);

        Assert.assertEquals(driver.getTitle(),"Customer Login");
        Assert.assertTrue(driver.getPageSource().contains("Login or Create an Account"));

        driver.findElement(By.xpath("//a[@title='Create an Account']")).click();
        sleepInSeconds(3);

        Assert.assertTrue(driver.getPageSource().contains("Create an Account"));

    }
    @AfterClass
    public void afterClass(){
        // driver.quit();
    }

}
