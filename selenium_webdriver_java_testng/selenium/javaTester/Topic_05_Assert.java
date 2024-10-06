package javaTester;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Topic_05_Assert {
 WebDriver driver;

    @Test
    public void verifyTestNG() {

        driver = new ChromeDriver();

        // Trong Java có nhiều thư viện verify dữ liệu
        // Testing Framework
        // JUnit 4/ TestNG/ JUnit 5/ AssertJ/ ...

        // Assert True kiểu dl boolean(true/false)
        // Khi mà mong mốn đk trả về là  đúng thì dùng Assert
        // contains là tương đối

        Assert.assertTrue(driver.getPageSource().contains("Hello World"));

        Assert.assertFalse(driver.getPageSource().contains("Hello World"));

        // Các hàm trả về dữ liệu là boolean
        // Quy tắc: Bắt đầu với tiền tố là isxxxx
        // WebElement
        driver.findElement(By.id("")).isDisplayed();
        driver.findElement(By.id("")).isEnabled();
        driver.findElement(By.id("")).isSelected();

        new Select(driver.findElement(By.id(""))).isMultiple();

        // Mong đợi 1 điều  kiện giống với thực tế( tuyệt đối)
        Assert.assertEquals(driver.getCurrentUrl(),"");
        Assert.assertEquals(driver.findElement(By.id("")).getText(),"");

        // Unit Test
        Object name = null;
        Assert.assertNull(name);

        name = "Testing";
        Assert.assertNotNull(name);







    }

}
