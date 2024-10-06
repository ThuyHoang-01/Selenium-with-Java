package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Topic_03_Selenium_Relative {

    WebDriver driver;
    String projectPath = System.getProperty("user.dir");
    String osName = System.getProperty("os.name");

    @BeforeClass
    public void beforeClass() {
//        if (osName.contains("Windows")) {
//            System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
//        } else {
//            System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
//        }
//
//        driver = new FirefoxDriver();
//        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//        driver.manage().window().maximize();
//       // driver.get("https://www.facebook.com/");
    }

    // Tìm element mà không biết chính xác vị trí
    // Tìm relative
    @Test
    public void TC_01_Relative() {
        driver.get("https://demo.nopcommerce.com/login?returnUrl=%2F");

        WebElement loginButtonElement = driver.findElement(By.cssSelector("button.login-button"));
        WebElement rememberMeCheckboxBy = driver.findElement(By.cssSelector("RememberMe"));

        WebElement rememberMeTextElement =
                driver.findElement( RelativeLocator.with(By.tagName("label")).
                        above(loginButtonElement).toRightOf(rememberMeCheckboxBy));

        System.out.println(rememberMeTextElement.getText());
    }


    @AfterClass
    public void afterClass() {
        driver.quit();
    }


}
