import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.w3c.dom.html.HTMLInputElement;

public class Junit5 {
    private static ChromeOptions options;
    private static ChromeDriver chromeDriver;
    private static String baseurl = "https://junit.org/";
    private HTMLInputElement buttonElement;

    @BeforeAll
    static void downloadDriver(){
        WebDriverManager.chromedriver().setup();
        options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
    }

    @BeforeEach
    void openBrowser(){
        chromeDriver = new ChromeDriver(options);
    }

    @Test
    void getCurrentUrlTest(){
        chromeDriver.get(baseurl);
        String url = chromeDriver.getCurrentUrl();
        Assertions.assertEquals(baseurl);
    }

    @Test
    void clickbutton(){
        WebElement button = chromeDriver.findElement(By.id("btn btn-primary btn-lg",[QA]);
        buttonElement.click();
    }

    @Test
    void checktag(){
        WebElement checkTagButton = chromeDriver.findElement(By.xpath(//button[contains(text(),'Watch tag')]"))
    }

    @AfterEach
    void tearDown(){
        chromeDriver.close();
    }
}
