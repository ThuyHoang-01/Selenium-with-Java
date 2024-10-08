package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Topic_05_Selenium_Text {

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
        driver.get("");

        // 1. Truyền text vào trong locator để check hiển thị( display)
        // Nên sử dụng tuyệt đối
        driver.findElement(By.xpath("//h1[text()='Selenium WebDriver API']")).isDisplayed();

        // Hạn chê vì nó tương đối
        driver.findElement(By.xpath("//p[contains(text(),\"Mail Personal or Business Check\")]")).isDisplayed();

        // 2. Get Text rồi verify sau
        String text =  driver.findElement(By.xpath("//p[contains(text(),'Mail Personal or Business Check')]")).getText();

        // Confirm câu text,
        // Nếu xác nhận câu text thì dùng asserEquals , nếu dùng xác nhận đúng/sai dùng assertTrue
        Assert.assertTrue(text.contains("Mail Personal or Business Check"));

        String nestedText = driver.findElement(By.xpath("//h5[@id='nested']")).getText();
        System.out.println(nestedText);
        Assert.assertEquals(nestedText, "Hello Word! (Ignore Me) @04:50");

        // Click Mobile
        driver.findElement(By.xpath("//a[text()='Mobile']")).click();


    }


    @AfterClass
    public void afterClass() {
        driver.quit();
    }

}
