package sacovec.olga.page;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import sacovec.olga.components.Header;

public class HomePage {
    public HomePage navigateTo(String url){
        Selenide.open(url);
        WebDriverRunner.getWebDriver().manage().window().maximize();
        return this;
    }
    public Header getHeader(){
        return Selenide.page(Header.class);
    }
}
