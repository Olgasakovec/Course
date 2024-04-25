package sacovec.olga.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import sacovec.olga.page.DocumentationPage;

public class Menu {

    private WebDriver driver;
    private By developerToolLocator = By.xpath("//button[@aria-label='Developer Tools: Open submenu']");
    public Menu(WebDriver driver) {
        this.driver = driver;
    }

    public DocumentationPage clickdeveloperTools(){
        driver.findElement(developerToolLocator).click();
        return new DocumentationPage(driver);
    }
}
