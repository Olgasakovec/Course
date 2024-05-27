import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import component.Header;

public class HomePage {

    public HomePage navigateTo(String url) {
        Selenide.open(url);
        WebDriverRunner.getWebDriver().manage().window().maximize();
        return this;
    }

    public Header getHeder() {
        return Selenide.page(Header.class);
    }
}
