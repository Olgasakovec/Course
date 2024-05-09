package component;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import page.JetBrainsAiPage;


public class StoreDropDown {
    private WebDriver driver;

    private By jetBrainsAiLocator = By.xpath("//div[@data-test='main-submenu']//div[@class='wt-offset-top-12']//a[@href='/ai/']");


    public StoreDropDown(WebDriver driver) {
        this.driver = driver;
    }

    public JetBrainsAiPage clickJetBrainsAi() {
        driver.findElement(jetBrainsAiLocator).click();
        return new JetBrainsAiPage(driver);
    }
}
