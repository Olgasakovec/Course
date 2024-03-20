import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.webdriver.WebDriverBrowser;
import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;

public class Selenium {

    @BeforeAll
    static void openBrowser(){
        WebDriverManager.chromedriver().setup();

        ChromeDriver chromeDriver = new ChromeDriver();
        chromeDriver.get("https://google.com");
        chromeDriver.getCurrentUrl();
    }

    @AfterAll
    static void closeBrowser(){
        System.out.println("browser is close");
    }


    @Test
    void clearCookies(){
        System.out.println("clearCookies");
    }

    }


