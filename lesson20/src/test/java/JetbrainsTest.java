import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import page.MainPage;

public class JetbrainsTest extends BaseTest {

    @Test
    void checkThatLinkHaveText() {
        new MainPage(getDriver())
                .navigateTo("https://www.jetbrains.com/")
                .developerToolsClick()
                .

    }
}
