package page;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import component.Header;

public class MainPage {

    public MainPage navigateTo(String url) {
        Selenide.open(url);
        WebDriverRunner.getWebDriver().manage().window().maximize();
        return this;
    }

    public Header getHeader() {
        return Selenide.page(Header.class);
    }
}
