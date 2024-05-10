package component;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Header {
    private WebDriver driver;

    private By developerToolsLocator = By.xpath("//button[@type='button' and @aria-label='Developer Tools: Open submenu']");

    private By storeLocator = By.xpath("//button[@type='button' and @aria-label='Store: Open submenu']");

    public Header(WebDriver driver) {
        this.driver = driver;
    }

    public ToolsDropDown clickDeveloperTools() {
        driver.findElement(developerToolsLocator).click();
        return new ToolsDropDown(driver);
    }

    public StoreDropDown clickStore() {
        driver.findElement(storeLocator).click();
        return new StoreDropDown(driver);
    }
}