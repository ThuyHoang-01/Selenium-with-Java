package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverInfo;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Topic_06_Register {

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
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");
    }

    @Test
    public void TC_01_RegisterSuccess() {



        WebElement fullNameInput = driver.findElement(By.id("txtFirstname"));
        fullNameInput.sendKeys("Ava Hoang");

        WebElement emailAddressInput = driver.findElement(By.id("txtEmail"));
        emailAddressInput.sendKeys("ava01@gmail.com");

        WebElement emailAddressConfirm = driver.findElement(By.id("txtCEmail"));
        emailAddressConfirm.sendKeys("ava01@gmail.com");

        WebElement passwordInput = driver.findElement(By.id("txtPassword"));
        passwordInput.sendKeys("Qaz@123456");

        WebElement passwordConfirm = driver.findElement(By.id("txtCPassword"));
        passwordConfirm.sendKeys("Qaz@123456");

        WebElement phoneNumberInput = driver.findElement(By.id("txtPhone"));
        phoneNumberInput.sendKeys("0342123123");

        WebElement termCondition = driver.findElement(By.id("chkRight"));
        termCondition.click();

        //Register Button
        WebElement registerButton = driver.findElement(By.xpath("//button[@class='btn_pink_sm fs16']"));
        registerButton.click();

    }
    @Test
    public void TC_02_RegisterWithEmpty() {

        WebElement registerButton = driver.findElement(By.xpath("//button[@class='btn_pink_sm fs16']"));
        registerButton.click();

        Assert.assertEquals(driver.findElement(By.id("txtFirstname-error")).getText(), "Vui lòng nhập họ tên");
        Assert.assertEquals(driver.findElement(By.id("txtEmail-error")).getText(), "Vui lòng nhập email");
        Assert.assertEquals(driver.findElement(By.id("txtCEmail-error")).getText(), "Vui lòng nhập lại địa chỉ email");
        Assert.assertEquals(driver.findElement(By.id("txtPassword-error")).getText(), "Vui lòng nhập mật khẩu");
        Assert.assertEquals(driver.findElement(By.id("txtCPassword-error")).getText(), "Vui lòng nhập lại mật khẩu");
        Assert.assertEquals(driver.findElement(By.id("txtPhone-error")).getText(), "Vui lòng nhập số điện thoại.");

    }

    @Test
    public void TC_03_RegisterInvalidEmail() {



        WebElement fullNameInput = driver.findElement(By.id("txtFirstname"));
        fullNameInput.sendKeys("Ava Hoang");

        WebElement emailAddressInput = driver.findElement(By.id("txtEmail"));
        emailAddressInput.sendKeys("ava01@gmail@1234");

        WebElement emailAddressConfirm = driver.findElement(By.id("txtCEmail"));
        emailAddressConfirm.sendKeys("ava01@gmail@1234");

        WebElement passwordInput = driver.findElement(By.id("txtPassword"));
        passwordInput.sendKeys("Qaz@1234567");

        WebElement passwordConfirm = driver.findElement(By.id("txtCPassword"));
        passwordConfirm.sendKeys("Qaz@1234567");

        WebElement phoneNumberInput = driver.findElement(By.id("txtPhone"));
        phoneNumberInput.sendKeys("0342123128");

        WebElement termCondition = driver.findElement(By.id("chkRight"));
        termCondition.click();

        //Register Button
        WebElement registerButton = driver.findElement(By.xpath("//button[@class='btn_pink_sm fs16']"));
        registerButton.click();

        // Verify
        Assert.assertEquals(driver.findElement(By.id("txtEmail-error")).getText(), "Vui lòng nhập email hợp lệ");
        Assert.assertEquals(driver.findElement(By.id("txtCEmail-error")).getText(), "Email nhập lại không đúng");


    }



    @AfterClass
    public void afterClass() {
       // driver.quit();
    }
}
