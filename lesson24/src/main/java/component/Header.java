package component;

import static com.codeborne.selenide.Selenide.$x;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import page.AuthPage;
import page.OrganizatoramPage;

public class Header {
    private SelenideElement openLoginPage = $x("//div[@class='header__login-enter js-header__login-enter']/div[@class='header__login-title']");

    private SelenideElement promoyteri = $x("//a[@href='/organizatoram/']");

    public AuthPage clickOpenLoginPage() {
        openLoginPage.click();
        return Selenide.page(AuthPage.class);
    }

    public OrganizatoramPage clickPromoyteri() {
        promoyteri.click();
        return Selenide.page(OrganizatoramPage.class);
    }
}
