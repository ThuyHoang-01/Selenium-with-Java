package webdriver;

import com.beust.ah.A;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Topic_09_Default_Dropdown {

    WebDriver driver;

    String firstName = "John" , lastName = "Wick" , email= getEmailAddress();
    String companyName = "SDET", passWord = "123456";
    String day ="15", month="November", year="1958";

    @BeforeClass
    public void beforeClass() {

        driver = new ChromeDriver(  );
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    public String getEmailAddress() {
        Random rand = new Random();
        return "johnwick" + rand.nextInt(9999) + "@gmail.net";
    }

    @Test
    public void TC_01_Register() {

        driver.get("https://demo.nopcommerce.com/register");
        driver.findElement(By.xpath("//a[@class='ico-register']")).click();
        sleepInSeconds(3);

        driver.findElement(By.xpath("//input[@id='gender-male']")).click();
        driver.findElement(By.id("FirstName")).sendKeys(firstName);
        driver.findElement(By.id("LastName")).sendKeys(lastName);

        Select dayDropdown = new Select(driver.findElement(By.name("DateOfBirthDay")));
        dayDropdown.selectByVisibleText(day);
        // Verify dropdown là Single
        Assert.assertFalse(dayDropdown.isMultiple());
        // Verify số lượng item trong dropdown  là 32
//        List<WebElement> dayOptions = day.getOptions();
//        Assert.assertEquals(dayOptions.size(), 32);
        Assert.assertEquals(dayDropdown.getOptions().size(),32);

        Select monthDropdown = new Select(driver.findElement(By.name("DateOfBirthMonth")));
        monthDropdown.selectByVisibleText(month);

        Select yearDropdown = new Select(driver.findElement(By.name("DateOfBirthYear")));
        yearDropdown.selectByVisibleText(year);

        driver.findElement(By.id("Email")).sendKeys(email);
        driver.findElement(By.id("Company")).sendKeys(companyName);
        driver.findElement(By.id("Password")).sendKeys(passWord);
        driver.findElement(By.id("ConfirmPassword")).sendKeys(passWord);

        driver.findElement(By.cssSelector("button#register-button")).click();
        sleepInSeconds(10);

       // Assert.assertEquals(driver.findElement(By.cssSelector("div.result")).getText(),"Your registration completed");

    }

    @Test
    public void TC_02_Login() {


        // Login
        driver.findElement(By.cssSelector("a.ico-login")).click();
        driver.findElement(By.cssSelector("input#Email")).click();
        driver.findElement(By.cssSelector("input#Password")).click();
        driver.findElement(By.cssSelector("button.login-button")).click();
        sleepInSeconds(2);
        // Verify
        driver.findElement(By.cssSelector("a.ico-login")).click();
        sleepInSeconds(2);

        Assert.assertEquals(driver.findElement(By.cssSelector("input#FistName")).getAttribute("value"),firstName);
        Assert.assertEquals(driver.findElement(By.cssSelector("input#LastName")).getAttribute("value"),lastName);

        Assert.assertEquals(new Select(driver.findElement(By.name("DateOfBirthDay"))).getFirstSelectedOption().getText(),day);
        Assert.assertEquals(new Select(driver.findElement(By.name("DateOfBirthMonth"))).getFirstSelectedOption().getText(),month);
        Assert.assertEquals(new Select(driver.findElement(By.name("DateOfBirthYear"))).getFirstSelectedOption().getText(),year);

        Assert.assertEquals(driver.findElement(By.cssSelector("input#Email")).getAttribute("value"),email);
        Assert.assertEquals(driver.findElement(By.cssSelector("input#Company")).getAttribute("value"),companyName);


    }
    public void sleepInSeconds(long timeInSeconds) {
        try {
            Thread.sleep(timeInSeconds * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @AfterClass
    public void afterClass() {

    }
}
