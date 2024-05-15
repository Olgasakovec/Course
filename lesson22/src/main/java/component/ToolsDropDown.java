package component;

import Page.CompanyPage;
import Page.OProektePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ToolsDropDown {
    private WebDriver driver;

    private By companyLocator = By.xpath("//nav[@class = 'menu__body']//a[@href='https://companies.devby.io']");

    private By oProekteLocator = By.xpath("//div[@class='menu__footer']//a[@class='menu__footer-item' and @href='https://devby.io/pages/about']");
    public ToolsDropDown(WebDriver driver){
        this.driver = driver;
    }

    public CompanyPage clickCompany() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(companyLocator)).click();
        return new CompanyPage(driver);
    }

    public OProektePage clickOProekte() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(oProekteLocator)).click();
        return new OProektePage(driver);
    }
}
