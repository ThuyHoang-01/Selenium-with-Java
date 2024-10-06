package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Topic_02_Selenium_Locator {

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
        //driver.manage().window().maximize();
        //driver.get("https://demo.nopcommerce.com/register");
        driver.get("https://terralogic.paxanimi.ai/login");
    }
    /* <input type="text" data-val="true" data-val-required="First name is required."
     id="FirstName" name="FirstName">
     */
    @Test
    public void TC_01_ID() {
        driver.findElement(By.id("basic_userEmail")).sendKeys("ava.hoang@terralogic.com");
        driver.findElement(By.id("basic_password")).sendKeys("Test@1234");
        WebElement loginButton = driver.findElement(By.className("button-content"));
        loginButton.click();
    }

    @Test
    public void TC_02_Class() {
        List<WebElement> elements = driver.findElements(By.className("button-content"));
        WebElement specificElement = elements.get(1); // Lấy phần tử số 2
        specificElement.click();
    }
    @Test
    public void TC_03_Name() {
        driver.findElement(By.name(""));

    }
    @Test
    public void TC_04_TagName() {
        driver.findElement(By.tagName(""));
    }
    @Test
    public void TC_05_LinkText() {
        // độ chính xác cao = tuyệt đối = tìm toàn bộ
        driver.findElement(By.linkText(""));
    }
    @Test
    public void TC_06_Partial_LinkText() {
        // độ chính xác không cao = tương đối = 1 phần (đầu/giữa/cuối)
        driver.findElement(By.partialLinkText(""));
    }
    @Test
    public void TC_07_Css() {
        //Css với ID
        driver.findElement(By.cssSelector("input[id='Firstname']"));
        driver.findElement(By.cssSelector("input#id='Firstname']"));
        driver.findElement(By.cssSelector("#Firstname'"));

        // Css với Class
        driver.findElement(By.cssSelector("div[class='page-title']"));
        driver.findElement(By.cssSelector("div.page-title"));
        driver.findElement(By.cssSelector(".page-title"));

        // Css với Name chỉ support viết đầy đủ
        driver.findElement(By.cssSelector("input[name='Firstname']"));

        // Css với Tagname
        driver.findElement(By.cssSelector("input"));

        // Css với Textlink
        driver.findElement(By.cssSelector("a[href='customer/address']"));

        // Css với partial Link
        driver.findElement(By.cssSelector("a[href*='address']"));
        //driver.findElement(By.cssSelector("a[href^='address']"));
        //driver.findElement(By.cssSelector("a[href$='address']"));
    }
    @Test
    public void TC_08_Xpath() {

        //Xpath với ID
        driver.findElement(By.cssSelector("//input[@id='Firstname']"));

        // Xpath với Class
        driver.findElement(By.cssSelector("//div[@class='page-title']"));

        // Xpath với Name chỉ support viết đầy đủ
        driver.findElement(By.cssSelector("//input[@name='Firstname']"));

        // Xpath với Tagname
        driver.findElement(By.cssSelector("//input"));

        // Xpath với Textlink
        driver.findElement(By.cssSelector("//a[@href='customer/address']"));
        driver.findElement(By.cssSelector("//a[text()='Address']"));

        // Xpath với partial Link
        driver.findElement(By.cssSelector("//a[contains(@href,'address']"));
        driver.findElement(By.cssSelector("//a[contains(text()='Address')]"));
    }


    @AfterClass
    public void afterClass() {
        //  driver.quit();
    }

}
