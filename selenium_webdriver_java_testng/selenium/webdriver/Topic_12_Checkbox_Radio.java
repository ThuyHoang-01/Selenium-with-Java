package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
    public void TC_01_Default_Telerik_Checkbox() {

        driver.get("https://demos.telerik.com/kendo-ui/checkbox/index");
        sleepInSeconds(3);
        // Click on checkbox
        By dualZoneCheckbox = By.xpath("//label[text()='Dual-zone air conditioning']/preceding-sibling::span/input");
        checkToElement(dualZoneCheckbox);
        Assert.assertTrue(driver.findElement(dualZoneCheckbox).isSelected());
        // Uncheck
        uncheckToElement(dualZoneCheckbox);
        Assert.assertFalse(driver.findElement(dualZoneCheckbox).isSelected());
    }

    @Test
    public void TC_02_Default_Telerik_RadioButton() {

        driver.get("https://demos.telerik.com/kendo-ui/radiobutton/index");
        By twoPetrolRadiobutton = By.xpath("//label[text()='2.0 Petrol, 147kW']/preceding-sibling::span/input");
        By twoDieselRadiobutton = By.xpath("//label[text()='2.0 Diesel, 103kW']/preceding-sibling::span/input");

        checkToElement(twoPetrolRadiobutton);
        //Verify
        Assert.assertTrue(driver.findElement(twoPetrolRadiobutton).isSelected());
        Assert.assertFalse(driver.findElement(twoDieselRadiobutton).isSelected());

        checkToElement(twoPetrolRadiobutton);
        Assert.assertFalse(driver.findElement(twoDieselRadiobutton).isSelected());
        Assert.assertFalse(driver.findElement(twoDieselRadiobutton).isSelected());
    }
    @Test
    public void TC_03_Material_Radio() {

        // Radio
        driver.get("https://material.angular.io/components/radio/examples");
        By summerRadioButton = By.xpath("//label[text()='Summer']/preceding-sibling::div/input");

        checkToElement(summerRadioButton);
    }
    @Test
    public void TC_031_Material_Checkbox() {

        // Checkbox
        driver.get("https://material.angular.io/components/checkbox/examples");
        By checkedCheckbox = By.xpath("//label[text()='Checked']/preceding-sibling::div/input");
        By indeterminateCheckbox = By.xpath("//label[text()='Indeterminate']/preceding-sibling::div/input");

        checkToElement(checkedCheckbox);
        checkToElement(indeterminateCheckbox);
        Assert.assertTrue(driver.findElement(checkedCheckbox).isSelected());
        Assert.assertTrue(driver.findElement(indeterminateCheckbox).isSelected());

        uncheckToElement(checkedCheckbox);
        uncheckToElement(indeterminateCheckbox);
        Assert.assertFalse(driver.findElement(checkedCheckbox).isSelected());
        Assert.assertFalse(driver.findElement(indeterminateCheckbox).isSelected());

    }

    @Test
    public void TC_04_Select_All_Checkbox() {

        driver.get("https://automationfc.github.io/multiple-fields/");
        List<WebElement> allCheckbox = driver.findElements(By.cssSelector("div.form-single-column input[type='checkbox']"));
        // Select All
        for(WebElement checkbox : allCheckbox) {
            if (!checkbox.isSelected()){
                checkbox.click();
                sleepInSeconds(1);
            }
        }
        // Verify all
        for (WebElement checkbox : allCheckbox) {
            Assert.assertTrue(checkbox.isSelected());
        }
        driver.manage().deleteAllCookies();
        driver.navigate().refresh();
        allCheckbox = driver.findElements(By.cssSelector("div.form-single-column input[type='checkbox']"));
        // Choose one from all checkbox
        for (WebElement checkbox : allCheckbox) {
            if (checkbox.getAttribute("value").equals("Heart Attack") && !checkbox.isSelected()) {
                checkbox.click();
                sleepInSeconds(3);
            }
        }
        //
        for (WebElement checkbox : allCheckbox) {
            if (checkbox.getAttribute("value").equals("Heart Attack")){
                Assert.assertTrue(checkbox.isSelected());
            }else{
                Assert.assertFalse(checkbox.isSelected());
            }
        }
    }


    @Test
    public void TC_05_Custom_Checkbox_RadioButton() {
        driver.get("https://login.ubuntu.com/");;
        By radioButton = By.xpath("//label[@class='new-user']");
        checkToElement(radioButton);
        sleepInSeconds(2);

        By checkboxTerm = By.xpath("//label[@for='id_accept_tos']");
        checkToElement(checkboxTerm);

    }

    @Test
    public void TC_06_Docs() {

        driver.get("https://docs.google.com/forms/d/e/1FAIpQLSfiypnd69zhuDkjKgqvpID9kwO29UCzeCVrGGtbNPZXQok0jA/viewform");
        By canThoRadio = By.xpath("//div[@aria-label='Cần Thơ']");
        By quangNamCheckbox = By.xpath("//div[@aria-label='Quảng Nam']");
        By quangBinhCheckbox = By.xpath("//div[@aria-label='Quảng Bình']");


        // Radio is not selected
        Assert.assertEquals(driver.findElement(canThoRadio).getAttribute("aria-checke"),"false");
        Assert.assertTrue(driver.findElement(By.xpath("//div[@aria-label='Cần Thơ' and @aria-checked= 'false']")).isDisplayed());

        driver.findElement(canThoRadio).click();
        sleepInSeconds(3);

        // Verify radio is selected
        Assert.assertEquals(driver.findElement(canThoRadio).getAttribute("aria-checke"),"false");
        Assert.assertTrue(driver.findElement(By.xpath("//div[@aria-label='Cần Thơ' and @aria-checked= 'true']")).isDisplayed());


        // Radio is not selected - Quảng Nam
        Assert.assertEquals(driver.findElement(quangNamCheckbox).getAttribute("aria-checke"),"false");
        Assert.assertTrue(driver.findElement(By.xpath("//div[@aria-label='Quảng Nam' and @aria-checked= 'false']")).isDisplayed());

        driver.findElement(quangNamCheckbox).click();
        driver.findElement(quangBinhCheckbox).click();
        sleepInSeconds(3);

        // Verify radio is selected
        Assert.assertEquals(driver.findElement(quangNamCheckbox).getAttribute("aria-checke"),"false");
        Assert.assertTrue(driver.findElement(By.xpath("//div[@aria-label='Quảng Nam' and @aria-checked= 'true']")).isDisplayed());
        


    }
    @Test
    public void JS(){

        By registerRadio = By.xpath("");

        ((JavascriptExecutor)driver).executeScript("arguments[0].click();",
        driver.findElement(registerRadio));
        sleepInSeconds(3);
        Assert.assertTrue(driver.findElement(registerRadio).isSelected());

        //[0]: đại diện cho tham số
//        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
//        jsExecutor.executeScript("");


    }

    // Check box doesn't select -> Click action
    public void checkToElement(By byXpath) {
        if (!driver.findElement(byXpath).isSelected()) {
            driver.findElement(byXpath).click();
            sleepInSeconds(2);
        }
    }

    // Check box selected -> Do not allow Click action
    public void uncheckToElement(By byXpath) {
        if (driver.findElement(byXpath).isSelected()) {
            sleepInSeconds(2);
            driver.findElement(byXpath).click();
        }
    }


    public void sleepInSeconds(long timeInSeconds){
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
