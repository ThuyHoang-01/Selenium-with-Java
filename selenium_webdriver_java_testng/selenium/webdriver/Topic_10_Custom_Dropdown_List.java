package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Topic_10_Custom_Dropdown_List {

    WebDriver driver;
    // Wait tường mình: trạng thái cụ thể của element
    // Visible / Invisible / Presence / Number
    WebDriverWait explicitWait;

    FluentWait<WebDriver> fluentWait;

    @BeforeClass
    public void beforeClass() {
        driver = new ChromeDriver();

        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(30)); // set 30s cho trạng thai tường minh
        // Wait ngầm định: không rõ ràng cho 1 trạng thái cụ thể nào cura element hết
        // Cho việc tìm element - findElement(S)
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void TC_01_JQuery() {

        driver.get("http://jqueryui.com/resources/demos/selectmenu/default.html");
        // Select a speed
        selectItemDropdown("span#speed-button", "ul#speed-menu div" , "Fast");
        sleepInSeconds(3);
        // Select a File
        selectItemDropdown("span#files-button", "ul#files-menu div" , "jQuery.js");
        sleepInSeconds(3);
        // Select a number
        selectItemDropdown("span#number-button", "ul#number-menu div" , "15");
        sleepInSeconds(3);

        // Select a title
        selectItemDropdown("span#salutation-button", "ul#salutation-menu div" , "Mrs.");
        sleepInSeconds(3);

        //driver.navigate().refresh(); // làm mới trước khi lựa chọn khác
        // Verify sau khi đã chọn
        Assert.assertEquals(driver.findElement(By.cssSelector("span#speed-button>span.ui-selectmenu-text")).getText(),"Fast");
        Assert.assertEquals(driver.findElement(By.cssSelector("span#files-button>span.ui-selectmenu-text")).getText(),"jQuery.js");
        Assert.assertEquals(driver.findElement(By.cssSelector("span#number-button>span.ui-selectmenu-text")).getText(),"15");
        Assert.assertEquals(driver.findElement(By.cssSelector("span#salutation-button>span.ui-selectmenu-text")).getText(),"Mrs.");

    }

    @Test
    public void TC_02_ReactJS() {

        driver.get("https://react.semantic-ui.com/maximize/dropdown-example-selection/");
        driver.findElement(By.xpath("//i[@class='dropdown icon']")).click();
        selectItemDropdown("i.dropdown.icon]", "div.item>span.text", "Elliot Fu");
        Assert.assertEquals(driver.findElement(By.cssSelector("div.divider.text")).getText(),"Elliot Fu");

    }

    @Test
    public void TC_03_VueJS(){

        driver.get("https://mikerodham.github.io/vue-dropdowns/");
        driver.findElement(By.cssSelector("span.caret")).click();
        sleepInSeconds(2);

        selectItemDropdown("li.dropdown-toggle","ul.dropdown-menu a","Third Option");
        Assert.assertEquals(driver.findElement(By.cssSelector("li.dropdown-toggle")).getText(),"Third Option");
        sleepInSeconds(3);
    }
    @Test
    public void TC_04_Irace(){

        driver.get("https://ticket.irace.vn/");
        driver.findElement(By.cssSelector("select#filter-location.form-select")).click();
        sleepInSeconds(2);

        selectItemDropdown("div.dropdown-menu.show","li.selected.active a","Hồ Chí Minh");
        Assert.assertEquals(driver.findElement(By.cssSelector("div.dropdown.bootstrap-select.form-select>select#filter-location")).getText(),"Hồ Chí Minh");
        sleepInSeconds(3);

    }


    public void sleepInSeconds(long timeInSeconds){
        try {
            Thread.sleep(timeInSeconds * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


    public void selectItemDropdown( String parentCss, String childItemCss, String itemTextExpected ){
         /*
        1. Click vào 1 thẻ nó xổ hết các item bên trong dropdown
        2.1 Nó xổ ra chứa hết các item
        2.2 Xổ ra nhưng chỉ chứa 1 phần và đang load thêm
        */
        driver.findElement(By.cssSelector(parentCss)).click();
        sleepInSeconds(5);

        // allItems đang lưu trữ 19 item
        List<WebElement> allItems = explicitWait.until(ExpectedConditions.
                presenceOfAllElementsLocatedBy(By.cssSelector(childItemCss)));
        // For Each
        for(WebElement item : allItems) {
            String textItem =  item.getText();
            System.out.println("Text item = " + textItem);
            if (textItem.equals(itemTextExpected) ){
                item.click();
                break; // thoát vòng lặp (for/while/do-while/switch-case)
            }

        }

    }

    @AfterClass
    public void afterClass() {
        // driver.quit();
    }
}


