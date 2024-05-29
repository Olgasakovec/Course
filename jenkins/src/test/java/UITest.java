import com.codeborne.selenide.WebDriverRunner;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import page.MainPage;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static com.codeborne.selenide.WebDriverRunner.url;

public class UITest {

    static ChromeOptions options;
    @BeforeAll
    static void driverDown(){
        WebDriverManager.chromedriver().clearDriverCache().setup();
        options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
    }

    @BeforeEach
    void setUpDriver() {
        WebDriverRunner.setWebDriver(new ChromeDriver(options));
    }

    @AfterEach
    void closeBrowser(){
        getWebDriver().close();
    }

    @Test
    void checkUrl() {
        new MainPage()
                .navigateTo("https://www.ticketpro.by/")
                .getHeader()
                .openKorzina()
                .clickLoginButton();
        Assertions.assertEquals("https://www.ticketpro.by/auth/login/?basked=1", url());
    }
}
