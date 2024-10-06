package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Topic_07_Element_Command {

    WebDriver driver;

    @BeforeClass
    public void beforeClass(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30)); // wait tìm elements
        driver.manage().window().maximize();
    }


    @Test
    public void TC_01_isDisplayed(){
        // không hien thị - html gray
        driver.get("https://automationfc.github.io/basic-form/index.html");

        // Nếu như mong đọ 1 element hiển thị thì verifyTrue
        // Nếu như mong đợi 1 element không hiển thị verifyFalse
        // isDisplayed() = true | false
        if( driver.findElement(By.cssSelector("input#mail")).isDisplayed()){
            driver.findElement(By.cssSelector("input#mail")).sendKeys("Automation Testing");
            System.out.println("Email textbox is displayed");
        } else {
            System.out.println("Email textbox is not displayed");
        }

        if (driver.findElement(By.cssSelector("textarea#edu")).isDisplayed()){
            driver.findElement(By.cssSelector("textarea#edu")).sendKeys("Automation Testing");
            System.out.println(" Education textarea is displayed");
        } else {
            System.out.println("Education textarea is not displayed");
        }

        if (driver.findElement(By.cssSelector("input#under_18")).isDisplayed()){
            driver.findElement(By.cssSelector("input#under_18")).click();
            System.out.println("Radio is displayed");
        } else {
            System.out.println("Radio is not displayed");
        }

        if (driver.findElement(By.xpath("//h5[text()='Name: User5']")).isDisplayed()){
            System.out.println("Name User 5 is displayed");
        } else {
            System.out.println("Name User 5 is not displayed");
        }

    }

    @Test
    public void TC_02_isEnable(){

        driver.get("https://automationfc.github.io/basic-form/index.html");
        // Check some elements is enable
        // Email
        if (driver.findElement(By.cssSelector("input#mail")).isEnabled()){
            System.out.println("Email textbox is enable");
        } else {
            System.out.println("Email textbox is not enable");
        }
        // Age (Under 18)
        if (driver.findElement(By.cssSelector("input#under_18")).isEnabled()){
            System.out.println("Under 18 is enable");
        } else {
            System.out.println(" Under 18 is not enable");
        }
        // Education Textarea
        if(driver.findElement(By.cssSelector("textarea#edu")).isEnabled()){
            System.out.println("Education textarea is enable");
        } else{
            System.out.println("Education textarea is not enable");
        }
        // Cách 1 Job Role 01 / Job Role 02
        if (driver.findElement(By.cssSelector("select#job1")).isEnabled()) {
            System.out.println("Job role 1 is enable");
        }else {
            System.out.println("Job role 1 is not enable");
        }
        if (driver.findElement(By.cssSelector("select#job2")).isEnabled() )   {
            System.out.println("Job role 2 is enable");
        }else {
            System.out.println("Job role 2 is not enable");
        }
        // Interests Checkbox
        if (driver.findElement(By.xpath("//input[@id='development']")).isEnabled() )   {
            System.out.println("Interests Development is enable");
        }else {
            System.out.println("Interests Development is not enable");
        }
        // Slider 01
        if (driver.findElement(By.xpath("//input[@id='slider-1']")).isEnabled() )   {
            System.out.println("Slider 01 is enable");
        }else {
            System.out.println("Slider 01 is not enable");
        }

        // Check the elements isDisable
        // Password
        if (driver.findElement(By.cssSelector("input#disable_password")).isEnabled() )   {
            System.out.println("Password is disable");
        }else {
            System.out.println("Password is enable");
        }
        // Age ( Radiobutton is disable )

    }
    @Test
    public void TC_03_isSelected(){

        driver.get("https://automationfc.github.io/basic-form/index.html");

    }
    @Test
    public void TC_04_MailChimp(){

        driver.get("https://login.mailchimp.com/signup/");

    }



    @AfterClass
    public void afterClass(){

    }

}
