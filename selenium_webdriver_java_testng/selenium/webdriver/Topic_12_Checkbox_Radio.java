package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Topic_12_Checkbox_Radio {

    WebDriver driver;

    WebDriverWait explicitWait;


    @BeforeClass
    public void beforeClass() {
        driver = new ChromeDriver();

        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(30));
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void TC_01_Default_Telerik() {

        driver.get("https://demos.telerik.com/kendo-ui/checkbox/index");
        // Click on checkbox
        By dualZoneCheckbox = By.xpath("//label[text()='Dual-zone air conditioning']/preceding-sibling::span/input");
        driver.findElement(dualZoneCheckbox).click();
        sleepInSeconds(2);
        // Verify checkbox selected
        Assert.assertTrue(driver.findElement(dualZoneCheckbox).isSelected());


    }
    @Test
    public void TC_02_Checkbox() {

        driver.get("https://demos.telerik.com/kendo-ui/checkbox/index");
        // Click on checkbox
        By dualZoneCheckbox = By.xpath("//label[text()='Dual-zone air conditioning']/preceding-sibling::span/input");

        if (!driver.findElement(dualZoneCheckbox).isSelected()){
            driver.findElement(dualZoneCheckbox).click();
            sleepInSeconds(2);
        }
    }


    public void sleepInSeconds (long timeInSeconds){
        try {
            Thread.sleep(timeInSeconds * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
        @AfterClass
        public void afterClass () {
            // driver.quit();
        }


    }
