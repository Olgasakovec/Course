package component;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import page.AuthPage;
import static com.codeborne.selenide.Selenide.$x;

public class Header {

    private SelenideElement openKorzina = $x("//a[@href='/korzina/']");

        public AuthPage openKorzina() {
        openKorzina.click();
        return Selenide.page(AuthPage.class);
    }
}