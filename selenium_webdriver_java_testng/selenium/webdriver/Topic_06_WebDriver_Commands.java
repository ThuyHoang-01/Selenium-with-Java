package webdriver;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.logging.LogType;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Topic_06_WebDriver_Commands {

    // Các câu lệnh để thao tác vơ Browser
    // driver
    // Thường xuyên gặp lỗi NullPointerException
    WebDriver driver;

    // Các câu lệnh thao tác với Elements
    // Element
   @BeforeClass // khoi tao du lieu len
   public void beforeClass() {
       // Muon dung được phải khởi tạo
       // Tại sao hởi tạo lại đưa vào beforeClas
       driver = new ChromeDriver();

       // selenium ver 3
       driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
       driver.manage().window().maximize();

       // selenium ver 4
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));


   }
// anotation gán dữ liệu vào cho các hàm
    // Void khong can tra ve du lieu , thao tác lên browser
    // Khong phải void: lấy dữ liệu của web ra
    // Nguyen tắc: Tên hàm + tham số + trả về kiểu gì + có thuộc kiểu dữ liệu không
    @Test
    public void TC_01() {

        // Lý do dẫn đến việc getURL chậm:
        // 1- Do internet ( gói , mạng.v..v)
        // 2 - Do cấu hình máy tính ( CPU , Ram,V..V)
        // 3 - Do ứng dụng / hệ thống ( server đặt ở đâu, chức năng nhiều không)
        // 4 - Kiến trúc của hệ thống (  Số lượng truy cập tại 1 thười điểm)
       driver.get("https://www.facebook.com/");
       System.out.println("Win/ID" + driver.getWindowHandle());

       // Đóng driver không quan tâm có bao nhiêu tab
        driver.quit();

        // 2 hàm này sẽ bị ảnh hưởng timeout

        // Chỉ đóng tab mà đang mở , driver đang đứng ở đâu thì sẽ đóng tab đó
        driver.close();

        // By là một kiểu dữ liệu class
        // findElement trả về kiểu dữ liệu element , thì khai báo cũng phải là Webelement
        // Nếu không tìm thấy: Fail tại step này - throw exception: NuSuchElementException

       WebElement emailAddress =  driver.findElement(By.id(""));
       driver.findElement(By.cssSelector("button#login")).click();

       // Sẽ đi tìm và trả về 1 list Element được tìm thấy ( list Element)  => Phải khai báo là List<Element>
       List<WebElement>  checkboxs = driver.findElements(By.xpath("//input[ơ@type='class']"));
       // nếu muốn dùng click trong list

        checkboxs.get(1).click();

        // List cho phép lưu trùng lặp , còn Set<String> không cho phép lưu trùng lặp

        // ếu chỉ dùng 1 lần thì ko khai báo biến
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.facebook.com/");

        // Dùng lại nhiều lần khai báo biến
        String loginPageUrl = driver.getCurrentUrl(); // khai báo + khởi tạo
        Assert.assertEquals(loginPageUrl,"");
        // dùng lần tiếp theo
        driver.get(loginPageUrl); // gọi ra sử dụng


        driver.getCurrentUrl(); // Lấy ra URL mà hiện tại màn hình/page đang hiện
        driver.getPageSource(); // Lấy ra source HTML/CSS/CSS của màn hình hieejn tại
        //  Tại sao phải lấy ra PageSource -> Để verify tương đối
        // Verify 1 cách tương đôi
        driver.getPageSource();
        Assert.assertTrue(driver.getCurrentUrl().contains("ABC"));

        // Lấy ra title của page hiện tại
        driver.getTitle();

        // Lấy ra ID cửa sổ/tab hiện tại
        driver.getWindowHandle();
        driver.getWindowHandles();

        // Cookies - Framework
        driver.manage().getCookies();

        // Get ra những log ở Dev Tool - Framework
        driver.manage().logs().get(LogType.DRIVER);

        // Apply cho vic tìm elements
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        // Cho cho page được load xong
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

        // Set trước khi dùng với thư viện JsExecutor
        // Inject 1 đoạn code JS vào trong Browser/Element
        // Chờ thêm 30s trước khi nó bị failed
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(30));

        // Selenium 4 mới có - không dùng
        driver.manage().timeouts().getImplicitWaitTimeout();

        // Chạy test case full màn hình
        driver.manage().window().fullscreen();
        driver.manage().window().maximize();
        driver.manage().window().minimize();

        // Set trực tiếp chiều rộng và dài của màn hình windown
        driver.manage().window().setSize(new Dimension(1920, 1080));

        driver.manage().window().getSize();

        // It khi dùng - set browser ở vịt trí nào cho độ phân giải màn hình
        // ( run trên màn hình kích thước bao nhiêu)
        driver.manage().window().setPosition(new Point(2,5));
        driver.manage().window().getPosition();

        driver.navigate();

        driver.switchTo();


        // Tab Accesibility/ Properties trong Element
        driver.findElement(By.id("")).getAccessibleName();
        driver.findElement(By.id("")).getDomAttribute("checked");
        driver.findElement(By.id("")).getDomProperty("basURI");
        driver.findElement(By.id("")).getDomProperty("oter");


        // Verify font/size/color/background
        driver.findElement(By.id("")).getCssValue("background-color");

        // Vị trí của element so với độ phân giải màn hình
        Point nameTextbox = driver.findElement(By.id("")).getLocation();

        // Location + size( vị trí kích thước)
        Rectangle nameTextboxRect = driver.findElement(By.id("")).getRect();

        // Chiều cao + chiều rộng
        Point  namePoint = nameTextboxRect.getPoint();

        // Size
        Dimension nameSize = nameTextboxRect.getDimension();
        nameSize.getHeight();
        nameSize.getWidth();

        // Shadow Element (Javascript Executor )
        driver.findElement(By.id("")).getShadowRoot();

        Dimension address = driver.findElement(By.id("")).getSize();

        // Lấy ra cái thẻ chứ element
        driver.findElement(By.id("firstname")).getTagName();
        driver.findElement(By.cssSelector("#firstname")).getTagName();

        // get Tex message bị ârn
        driver.findElement(By.cssSelector("address.copyright")).getText();

        // Chụp hình bị lỗi và lưu dưới dạng nào
        // Byte , file , base64
        driver.findElement(By.cssSelector("address.copyright")).getScreenshotAs(OutputType.BASE64);

        // Fỏm ( element nào là thẻ form hoặc nằm trong thẻ form )
        driver.findElement(By.id("")).submit();


    }




}
