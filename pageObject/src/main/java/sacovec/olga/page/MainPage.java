package sacovec.olga.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {

    private WebDriver driver;
    private By developerToolLocator = By.xpath("//button[@type='button' and @aria-label='Developer Tools: Open submenu']");
    private By allPluginsLocator = By.xpath("//div[@class='wt-offset-top-12']//a[@href='/https://plugins.jetbrains.com/");
    private By roboPoJoGeneratorLocator = By.xpath("//div[@data-testid='autocomplete']");
    private By searchIconLocator = By.xpath("//div[@data-test='input__inner']");
    private By cardRobo = By.xpath("//div[@data-testid='plugin-card']//a[@href='/plugin/8634-robopojogenerator']");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public MainPage navigateTo(String url) {
        driver.get(url);
        return this;
    }

    public void clickDeveloperTools() {
        driver.findElement(developerToolsButton).click();
    }

    public void clickallPlugins(){
        driver.findElement(allPlugins).click();
    }
    public void inputroboPoJoGenerator(){
        driver.findElement(roboPoJoGenerator).sendKeys();
    }
    public void clicksearchIcon(){
        driver.findElement(searchIcon).click();
    }
}
