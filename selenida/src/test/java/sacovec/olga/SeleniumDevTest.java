package sacovec.olga;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import sacovec.olga.page.HomePage;

public class SeleniumDevTest {

    @Test
    void checkImageFormat(){
        SelenideElement image = new HomePage()
                .navigateTo("https://www.selenium.dev/")
                .getHeader()
                .clickDocumentTab()
                .getLeftMenuClass()
                .clickLegacyItem()
                .getLeftMenuClass()
                .clickSeleniumIdeSubItem()
                .getContentBlock()
                .getImage();

        image.shouldHave(Condition.visible);
                Assertions.assertTrue(image.getAttribute("src").endsWith("png"));



    }
}
