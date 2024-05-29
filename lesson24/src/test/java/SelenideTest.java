import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import page.HomePage;
import java.util.stream.Stream;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static com.codeborne.selenide.WebDriverRunner.url;

@Execution(ExecutionMode.CONCURRENT)
public class SelenideTest {

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

    public static final String ticketProURL = "https://www.ticketpro.by/";

    static Stream<Arguments> intertamentData() {
        return Stream.of(
                Arguments.of("Драма", "Драматические спектакли"),
                Arguments.of("Комедия", "Комедийные спектакли"),
                Arguments.of("Балет", "Балет и танцевальные спектакли")
        );
    }

    @ParameterizedTest
    @MethodSource("intertamentData")
    public void theaterIntertamentTest(String intertament, String expectedTitle) {
        SelenideElement title = new HomePage()
                .navigateTo(ticketProURL)
                .getNavigation()
                .hoverNavBar()
                .clickIntertament(intertament)
                .getTitle();

        title.shouldBe(Condition.visible).shouldHave(Condition.text(expectedTitle));
    }

    @Test
    void promouteriTest() {
        SelenideElement logo = new HomePage()
                .navigateTo(ticketProURL)
                .getHeader()
                .clickPromoyteri()
                .checkLogo();

        logo.shouldHave(Condition.visible);
        Assertions.assertTrue(logo.getAttribute("src").endsWith(".png"));
    }

    @Test
    void authTest() {
        new HomePage()
                .navigateTo(ticketProURL)
                .getHeader()
                .clickOpenLoginPage()
                .clickLoginButton();

        Assertions.assertEquals("https://www.ticketpro.by/auth/login/", url());
    }
}


