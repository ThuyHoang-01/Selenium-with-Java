package webdriver;

import common.TopicUtilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_08_Textbox_TextArea_Validations_Option1 {

    WebDriver driver;

    @BeforeClass
    public void beforeClass(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30)); // wait tìm elements
        driver.manage().window().maximize();
    }

    @Test
    public void TC_01_Empty_Email_And_Password(){

        driver.get("http://live.techpanda.org/");
        driver.findElement(By.xpath("//div[@class='footer-container']//a[@title='My Account']")).click();
        sleepInSeconds(2);
        driver.findElement(By.xpath("//button[@id='send2']")).click();
        sleepInSeconds(2);
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='advice-required-entry-email']")).getText(),"This is a required field.");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='advice-required-entry-pass']")).getText(),"This is a required field.");
    }

    public void sleepInSeconds(long timeInSeconds){
        try {
            Thread.sleep(timeInSeconds * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void TC_02_Invalid_Title(){
        driver.get("http://live.techpanda.org/");
        driver.findElement(By.xpath("//div[@class='footer-container']//a[@title='My Account']")).click();
        sleepInSeconds(2);
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("123434234@12312.123123");
        driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("123456");
        driver.findElement(By.xpath("//button[@id='send2']")).click();
        sleepInSeconds(2);
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='advice-validate-email-email']")).getText(),"Please enter a valid email address. For example johndoe@domain.com.");
    }

    @Test
    public void TC_03_Password_Less_than_6characters(){
        driver.get("http://live.techpanda.org/");
        driver.findElement(By.xpath("//div[@class='footer-container']//a[@title='My Account']")).click();
        sleepInSeconds(2);
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("automation@gmail.com");
        driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("123");
        driver.findElement(By.xpath("//button[@id='send2']")).click();
        sleepInSeconds(2);
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='advice-validate-password-pass']")).getText(),"Please enter 6 or more characters without leading or trailing spaces.");
    }

    @Test
    public void TC_04_Incorrect_Email_Password(){
        driver.get("http://live.techpanda.org/");
        driver.findElement(By.xpath("//div[@class='footer-container']//a[@title='My Account']")).click();
        sleepInSeconds(2);
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("automation@gmail.com");
        driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("123123123");
        driver.findElement(By.xpath("//button[@id='send2']")).click();
        sleepInSeconds(2);
        Assert.assertEquals(driver.findElement(By.xpath("//li[@class='error-msg']")).getText(),"Invalid login or password.");

    }

    @Test
    // Handle Textbox/Textarea
    public void TC_05_Register_New_Account(){
        driver.get("http://live.techpanda.org/");
        driver.findElement(By.xpath("//div[@class='footer-container']//a[@title='My Account']")).click();
        sleepInSeconds(2);
        driver.findElement(By.xpath("//a[@title='Create an Account']")).click();

        String firstName =  "Automation", lastName = "FC" , emailAddress = "automationfc@gamil.com", password = "123456789";
        String fullName = firstName + " " + lastName;

        String confirmPwValue = TopicUtilities.randomStringOfNumber(99999999);
        driver.findElement(By.xpath("//input[@id='firstname']")).sendKeys(TopicUtilities.randomString(5) );
        driver.findElement(By.xpath("//input[@id='lastname']")).sendKeys(TopicUtilities.randomString(10) );
        driver.findElement(By.xpath("//input[@id='email_address']")).sendKeys(TopicUtilities.randomString(20) +"@gmail.com");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys(confirmPwValue);
        driver.findElement(By.xpath("//input[@id='confirmation']")).sendKeys(confirmPwValue);
        driver.findElement(By.xpath("//input[@id='is_subscribed']")).click();
        sleepInSeconds(2);
        driver.findElement(By.xpath("//button[@title='Register']")).click();
        sleepInSeconds(2);

        Assert.assertEquals(driver.findElement(By.xpath("//li[@class='success-msg']")).
                getText(),"Thank you for registering with Main Website Store.");

        Assert.assertEquals(driver.findElement(By.cssSelector("div.welcom-msg strong")).getText(),"Hello, " +fullName);

        // Login





    }




    @AfterClass
    public void afterClass(){
        // driver.quit();
    }

}
