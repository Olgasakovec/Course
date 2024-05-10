package sacovec.olga.components;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import sacovec.olga.page.DocumentationPage;

import static com.codeborne.selenide.Selenide.$x;

public class Header {

    private SelenideElement headerContainer = $x(".//header//nav");
    private SelenideElement documentationTab = $x("//a[@href='/documentation']");

    public DocumentationPage clickDocumentTab() {
        documentationTab.click();
        return Selenide.page(DocumentationPage.class);
    }

}
