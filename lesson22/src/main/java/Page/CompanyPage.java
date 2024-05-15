package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CompanyPage {
    private WebDriver driver;

    private By inputCompanyLocator = By.xpath("//div[@class='dev-left']//input[@type='text' and @aria-controls='tablesort' and @placeholder='Название']");

    public CompanyPage(WebDriver driver) {
        this.driver = driver;
    }

    public SearchResultPage inputCompany(String companyShortName) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement searchField = wait.until(ExpectedConditions.visibilityOfElementLocated(inputCompanyLocator));
        searchField.sendKeys(companyShortName);
        return new SearchResultPage(driver);
    }
}