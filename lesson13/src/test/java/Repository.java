import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Repository {
    private static ChromeOptions options;
    private static ChromeDriver chromeDriver;
    private static final String baseUrl = "https://mvnrepository.com/";

    @BeforeAll
    static void downloadDriver(){
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void openBrowser(){
        options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        chromeDriver = new ChromeDriver(options);
        chromeDriver.get(baseUrl);
    }

    @Test
    void getCurrentUrlTest1(){
        MainPage mainPage = new MainPage(chromeDriver);
        mainPage.navigateTo(baseUrl);
        String url = chromeDriver.getCurrentUrl();
        Assertions.assertEquals(baseUrl, url);
    }

    @Test
    void getCurrentUrlTest2() {
        MainPage mainPage = new MainPage(chromeDriver);
        mainPage.navigateTo(baseUrl);
        String url = chromeDriver.getCurrentUrl();
        Assertions.assertEquals("https://google.com/", url);
    }

    @AfterEach
    void tearDown(){
        chromeDriver.close();
    }
}
