package page;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class IntertamentPage {
    private SelenideElement title = $x("//h1");

    public SelenideElement getTitle() {
        return title;
    }
}
