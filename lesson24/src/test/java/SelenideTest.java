import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.WebDriverRunner.url;

@Execution(ExecutionMode.CONCURRENT)
public class SelenideTest {

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
        Selenide.open("https://www.ticketpro.by/");
        WebDriverRunner.getWebDriver().manage().window().maximize();
        $x("//a[@href='/bilety-v-teatr/']").should(Condition.visible).hover();
        $x("//a[contains(text(), '" + intertament + "')]").should(Condition.visible).click();
        $x("//h1").shouldHave(Condition.text(expectedTitle));
    }

    @Test
    void promouteriTest() {
        Selenide.open("https://www.ticketpro.by/");
        WebDriverRunner.getWebDriver().manage().window().maximize();
        $x("//a[@href='/organizatoram/']").click();
        $x("//div[@class='description']//img[@alt='logo' and contains(@src, '.png')]")
                .shouldHave(attributeMatching("src", ".*png.*"));
    }

    @Test
    void authTest() {
        new HomePage()
                .navigateTo("https://www.ticketpro.by/")
                .getHeder()
                .clickOpenLoginPage()
                .getAuthPage()
                .clickLoginButton();

        Assertions.assertEquals("https://www.ticketpro.by/auth/login/", url() );
        }
}