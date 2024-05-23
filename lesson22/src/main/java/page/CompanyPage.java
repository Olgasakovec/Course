package page;

import component.SearchResult;
import org.openqa.selenium.WebDriver;

public class CompanyPage {
    private WebDriver driver;


    public CompanyPage(WebDriver driver) {
        this.driver = driver;
    }

    public SearchResult getSearchResult() {
        return new SearchResult(driver);
    }
}