package javaTester;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_04_Scope {

    // Các biến được khai báo ở ngoài hàm -> Phạm vi class
    // Biến Global ( toàn cục)
    // Có thể dùng cho tất cả các hàm trong 1 Clas đó

    WebDriver driver;

    String homePageUrl = "";

    String fullName = "Testing";

    @BeforeClass
    public void beforeClass() {
        driver = new ChromeDriver();
    }

    @Test
    public void TC_01() {
        // Các bin được khai báo ở trong 1 hàm -> Ohạm vi cục bộ ( local)
        // Dùng trong hàm nó được khai báo / ược sinh ra
        String homePage = "https://chat.zalo";

        // TRong 1 hàm nếu có 2 biến cùng tên (global/ local) thì nó sẽ được ưu tiên ấy local
        // 1 biến local nếu như gọi tới dùng mà chưa được khởi tạo sẽ bị ỗi
        // Biển local chưa được khởi to mà gọi là sẽ lọi ngay
        driver.get(homePageUrl);

        // Nếu trong 1 hàm có 2 bin cùng tên (global/ local) muốn laays biến floabl ra dùng
        // dùng từ khóa this
        // Biến global chưa khởi tạo mà gọi ra dùng thì ko báo lỗi ở level (compile code)
        // level runtime sẽ lỗi
    }



}
