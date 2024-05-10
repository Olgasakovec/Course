package sacovec.olga.components;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import sacovec.olga.page.DocumentationPage;

import static com.codeborne.selenide.Selenide.$x;

public class LeftMenuClass {
    private SelenideElement menuContainer = $x(".[@id='td-section-nav']");
    private SelenideElement legacyItem = $x(".//a[@href='/documentation/legacy/']");
    private SelenideElement seleniumIdeSubItem = $x(".//a[@href='/documentation/legacy/selenium_ide/']");

    public DocumentationPage clickLegacyItem(){
        legacyItem.click();
        return Selenide.page(DocumentationPage.class);
    }

    public DocumentationPage clickSeleniumIdeSubItem(){
        seleniumIdeSubItem.click();
        return Selenide.page(DocumentationPage.class);
    }
}
