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

public class Topic_11_Handle_button {

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
    public void TC_01_Button() {
        driver.get("https://egov.danang.gov.vn/reg");
        WebElement registerButton = driver.findElement(By.cssSelector("input.egov-button"));
        // Verify button is Disable
        Assert.assertFalse(registerButton.isEnabled());
        driver.findElement(By.cssSelector("input#chinhSach")).click();
        sleepInSeconds(3);

        // Verify button is Enable after click on Checkbox
        Assert.assertTrue(registerButton.isEnabled());

        // Get color for button
        String registerBackgroundRGB = registerButton.getCssValue("background-color");
        System.out.println("Background Color RGB =" + registerBackgroundRGB);
        // Verify colors backgrounds
        Color registerBackgroundColor = Color.fromString(registerBackgroundRGB);

        String registerBackgroundHexa = registerBackgroundColor.asHex();

        Assert.assertEquals(registerBackgroundHexa, "#ef5a00");

    }

    @Test
    public void TC_02_Fahasha_Button() {

        driver.get("https://www.fahasa.com/customer/account/create");
        driver.findElement(By.cssSelector("li.popup-login-tab-item.popup-login-tab-login")).click();
        // Verify that "Login" button disabled
        WebElement buttonLogin = driver.findElement(By.cssSelector("button.fhs-btn-login"));
        Assert.assertFalse(buttonLogin.isEnabled());
        // Verify that "Login" button with background color is Gray

        String buttonLoginBackgroundRgb = buttonLogin.getCssValue("background-color");
        System.out.println("Background Color Rgb =" + buttonLoginBackgroundRgb);
        Color buttonLoginBackgroundStore = Color.fromString(buttonLoginBackgroundRgb);

        String buttonLoginBackgroundHex = buttonLoginBackgroundStore.asHex();
        Assert.assertEquals(buttonLoginBackgroundHex, "#000000");


        // Enters email and password
        driver.findElement(By.cssSelector("input#login_username")).sendKeys("ava@yopmail.con");
        driver.findElement(By.cssSelector("input#login_password")).sendKeys("123456");
        // Verify that button is Enable after user enters username/password
        Assert.assertTrue(buttonLogin.isEnabled());
        Assert.assertEquals(Color.fromString(buttonLogin.getCssValue("background-color")).
                asHex().toUpperCase(), "#C92127");

    }

    @Test
    public void TC_03_Design_Wise_Self() {
        driver.get("https://play.goconsensus.com/u5d5156df");
// Button default disabled
        WebElement buttonContinue = driver.findElement(By.cssSelector("button.src-shared-ui-button--button-XQoY9.src-shared-ui-button--contained-J3hao" +
                ".src-app-providers-contact-form-ui-lead-form-ui--submit-oPwI0"));
        Assert.assertFalse(buttonContinue.isEnabled());
// Verify colors when button is disable
        Assert.assertEquals(Color.fromString(buttonContinue.getCssValue("background-color"))
                .asHex().toLowerCase(), "#673ab7");
        System.out.println("Background Color Rgb = " + Color.fromString(buttonContinue.getCssValue("background-color"))
                .asHex().toLowerCase());

// Enters data
        driver.findElement(By.cssSelector("input#firstName")).sendKeys("Ava");
        driver.findElement(By.cssSelector("input#lastName")).sendKeys("K03");
        driver.findElement(By.cssSelector("input#email")).sendKeys("automation@gmail.com");
        driver.findElement(By.cssSelector("input#confirmEmail")).sendKeys("automation@gmail.com");
        driver.findElement(By.cssSelector("input#phoneNumber")).sendKeys("034123123");
        driver.findElement(By.cssSelector("input#organization")).sendKeys("Automation");
        // Select Dropdown
        driver.findElement(By.cssSelector("input#downshift-0-input")).click();
        selectItemDropdown("input#downshift-0-input", "div.src-shared-ui-dropdown-select-ui-menu-menu--root-+DV6c.src-shared-ui-dropdown-select-ui-menu-menu--bottom-21KKU div", "VN");
        sleepInSeconds(3);
    }

    @Test
    public void TC_04_Register_Huawei() {

        driver.get("https://id5.cloud.huawei.com/CAS/portal/userRegister/regbyemail.html");

    }

    public void selectItemDropdown(String parentCss, String childItemCss, String itemTextExpected) {
        driver.findElement(By.cssSelector(parentCss)).click();
        sleepInSeconds(2);
        List<WebElement> allItems = explicitWait.until(ExpectedConditions.
                presenceOfAllElementsLocatedBy(By.cssSelector(childItemCss)));
        for (WebElement item : allItems) {
            String textItem = item.getText();
            System.out.println("Text item = " + textItem);
            if (textItem.equals(itemTextExpected)) {
                item.click();
                break; // thoát vòng lặp (for/while/do-while/switch-case)
            }
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
