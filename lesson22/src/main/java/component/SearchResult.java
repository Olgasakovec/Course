package component;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class SearchResult {

    private WebDriver driver;

    private By inputCompanyLocator = By.xpath("//div[@class='dev-left']//input[@type='text' and @aria-controls='tablesort' and @placeholder='Название']");

    public SearchResult(WebDriver driver) {
        this.driver = driver;
    }

    public SearchResult inputCompany(String companyShortName) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement searchField = wait.until(ExpectedConditions.visibilityOfElementLocated(inputCompanyLocator));
        searchField.sendKeys(companyShortName);
        return this;
    }

    public SearchResult isCompanyFound(String companyName) {
        try {
            WebElement companyElement = driver.findElement(By.xpath("//tbody[@role='alert' and @aria-live='polite' and contains(., '" + companyName + "')]"));
            if (companyElement.isDisplayed()) {
                System.out.println("Компания " + companyName + " найдена.");
            } else {
                System.out.println("Компания " + companyName + " не найдена.");
            }
        } catch (NoSuchElementException e) {
            System.out.println("Компания " + companyName + " не найдена.");
        }
        return this;
    }

    private List<String> getCompanyNames() {
        List<WebElement> companyRows = driver.findElements(By.xpath("//tbody[@role='alert']/tr"));
        List<String> companyNames = new ArrayList<>();
        for (WebElement row : companyRows) {
            WebElement companyNameElement = row.findElement(By.xpath("./td[@data]"));
            String companyName = companyNameElement.getAttribute("data");
            companyNames.add(companyName);
        }
        return companyNames;
    }
    public int getCompanyCount() {
        List<WebElement> companyRows = driver.findElements(By.xpath("//div[@id='tablesort_wrapper']//table//tbody//tr"));
        return companyRows.size();
    }

    public int findCompanyRowIndex(String expectedCompany) {
        List<String> companyNames = getCompanyNames();
        int targetIndex = -1;
        for (String companyName : companyNames) {
            targetIndex++;
            System.out.println("Company: " + companyName + " найденный индекс " + targetIndex);
            if (companyName.equals(expectedCompany)) {
                targetIndex = targetIndex;
                break;
            }
        }

        if (targetIndex != -1) {
            System.out.println("Компания найдена: " + targetIndex);
        } else {
            System.out.println("Компания не найдена.");
        }
        return targetIndex;
    }

     public int getEmployeeCount(int targetIndex) {
        WebElement companyRow = driver.findElements(By.xpath("//div[@id='tablesort_wrapper']//table//tbody//tr")).get(targetIndex);
        String employeeCountText = companyRow.findElement(By.xpath(".//td[@class='t-left ']")).getText();
        return Integer.parseInt(employeeCountText);
    }
}


