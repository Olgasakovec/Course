package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class SearchResultPage {

    private WebDriver driver;

    public SearchResultPage(WebDriver driver) {
        this.driver = driver;
    }

    public SearchResultPage isCompanyFound(String companyName) {
        WebElement companyElement = driver.findElement(By.xpath("//tbody[@role='alert' and @aria-live='polite' and contains(., '" + companyName + "')]"));
        if (companyElement.isDisplayed()) {
            System.out.println("Компания " + companyName + " найдена.");
        } else {
            System.out.println("Компания " + companyName + " не найдена.");
        }
        return this;
    }

    public List<String> getCompanyNames() {
        List<WebElement> companyRows = driver.findElements(By.xpath("//tbody[@role='alert']/tr"));
        List<String> companyNames = new ArrayList<>();
        for (WebElement row : companyRows) {
            WebElement companyNameElement = row.findElement(By.xpath("./td[@data]"));
            String companyName = companyNameElement.getAttribute("data");
            companyNames.add(companyName);
        }
        return companyNames;
    }

    public SearchResultPage findCompanyNames(String expectedCompany) {
        List<String> companyNames = getCompanyNames();
        int index = 0;
        int targetIndex = -1;
        for (String companyName : companyNames) {
            index++;
            System.out.println("Company: " + companyName + " найденный индекс " + index);
            if (companyName.equals(expectedCompany)) {
                targetIndex = index;
            }
        }

        if (targetIndex != -1) {
            System.out.println("Компания найдена: " + targetIndex);
            isQuantityMoreThanZero(expectedCompany);
        } else {
            System.out.println("Компания не найдена.");
        }
        return this;
    }

    public SearchResultPage isQuantityMoreThanZero(String companyName) {
        WebElement companyElement = driver.findElement(By.xpath("//td[@class='t-left' and @data='" + companyName + "']/preceding-sibling::tr/td[@class='t-left']"));
        int quantityPerson = Integer.parseInt(companyElement.getText());
        if (quantityPerson > 0) {
            System.out.println("Количество сотрудников" + companyName + " больше 0.");
        } else {
            System.out.println("Количество сотрудников" + companyName + " равно 0.");
        }
        return this;
    }

    public SearchResultPage aboveQuantityMoreThanZero(String companyName) {
        List<String> companyNames = getCompanyNames();
        int currentIndex = companyNames.indexOf(companyName);
        if (currentIndex > 0) {
            String aboveCompany = companyNames.get(currentIndex - 1);
        }
        return this;
    }

    public SearchResultPage belowQuantityMoreThanZero(String companyName) {
        List<String> companyNames = getCompanyNames();
        int currentIndex = companyNames.indexOf(companyName);
        if (currentIndex < companyNames.size() - 1) {
            String belowCompany = companyNames.get(currentIndex + 1);
        }
        return this;
    }
}


