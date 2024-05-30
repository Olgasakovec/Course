package component;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$x;

public class Navigation {

    private SelenideElement navBar = $x("//a[@href='/bilety-v-teatr/']");

    public DropDown hoverNavBar() {
        navBar.hover();
        return Selenide.page(DropDown.class);
    }
}
