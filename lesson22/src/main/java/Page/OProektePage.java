package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OProektePage {
    private WebDriver driver;

    private By oProekteTitleLocator = By.xpath("//h1[@class='article__title' and text()='О проекте']");

    public OProektePage(WebDriver driver) {
        this.driver = driver;
    }

    public String checkTitleOProekte() {
        String title = driver.findElement(oProekteTitleLocator).getText();
        return title;
    }
}
