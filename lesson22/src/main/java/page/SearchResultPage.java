package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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

    public List<WebElement> getCompanyRows() {
        return driver.findElements(By.tagName("tr"));
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
        WebElement companyElement = driver.findElement(By.xpath("//td[@class='t-left' and @data='" + companyName + "']/following-sibling::tr/td[@class='t-left']"));
        int quantityPerson = Integer.parseInt(companyElement.getText());
        if (quantityPerson > 0) {
            System.out.println("Количество сотрудников" + companyName + " больше 0.");
        } else {
            System.out.println("Количество сотрудников" + companyName + " равно 0.");
        }
        return this;
    }

    public SearchResultPage belowQuantityMoreThanZero(String companyName) {
        WebElement companyElement = driver.findElement(By.xpath("//td[@class='t-left' and @data='" + companyName + "']"));
        int quantityPerson = Integer.parseInt(companyElement.getText());
        if (quantityPerson > 0) {
            System.out.println("Количество сотрудников" + companyName + " больше 0.");
        } else {
            System.out.println("Количество сотрудников" + companyName + " равно 0.");
        }
        return this;
    }
}


