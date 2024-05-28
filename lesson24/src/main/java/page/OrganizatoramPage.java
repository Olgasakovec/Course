package page;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$x;

public class OrganizatoramPage {

    private SelenideElement logo = $x("//div[@class='description']//img[@alt='logo' and contains(@src, '.png')]");

    public SelenideElement checkLogo() {
        return logo;
    }
}
