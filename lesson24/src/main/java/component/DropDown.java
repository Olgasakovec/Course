package component;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import page.IntertamentPage;

import static com.codeborne.selenide.Selenide.$x;

public class DropDown {

    public IntertamentPage clickIntertament(String intertament) {
        $x("//a[contains(text(), '" + intertament + "')]").should(Condition.visible).click();
        return Selenide.page(IntertamentPage.class);
    }
}
