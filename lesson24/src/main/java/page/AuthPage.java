package page;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$x;

public class AuthPage {
    private SelenideElement clickLoginButton = $x("//div[@class='form-button']/button[@class='btn']");

    public AuthPage clickLoginButton() {
        clickLoginButton.click();
        return Selenide.page(AuthPage.class);
    }
}
