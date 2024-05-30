package sacovec.olga;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import sacovec.olga.page.HomePage;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class SeleniumDevTest {

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
    void checkImageFormat(){
        SelenideElement image = new HomePage()
                .navigateTo("https://www.selenium.dev/")
                .getHeader()
                .clickDocumentTab()
                .getLeftMenuClass()
                .clickLegacyItem()
                .getLeftMenuClass()
                .clickSeleniumIdeSubItem()
                .getContentBlock()
                .getImage();

        image.shouldHave(Condition.visible);
                Assertions.assertTrue(image.getAttribute("src").endsWith("png"));



    }
}
