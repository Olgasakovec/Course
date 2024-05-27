package component;
import static com.codeborne.selenide.Selenide.$x;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import sacovec.olga.AuthPage;

public class Header {
    private SelenideElement openLoginPage = $x("//div[@class='header__login-enter js-header__login-enter']/div[@class='header__login-title']");

    public Header clickOpenLoginPage() {
        openLoginPage.click();
        return Selenide.page(Header.class);
    }

    public AuthPage getAuthPage() {
        return Selenide.page(AuthPage.class);
    }
}
