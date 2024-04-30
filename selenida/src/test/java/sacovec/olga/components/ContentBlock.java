package sacovec.olga.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class ContentBlock {

    private SelenideElement contentContainer = $x("//div[@class = 'td-content']");
    private SelenideElement image = $x(".//img[@alt='Selenium IDE Installation 1']");

    public SelenideElement getImage(){
        return image;
    }
}
