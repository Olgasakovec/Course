package step;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PyCharmStepDefinition {

    public PyCharmStepDefinition() {
    }

    @And("Choose 'PyCharm' and click")
    public void choosePyCharmAndClick() {
        WebElement pyCharmClick = BaseTest.getDriver().findElement(By.xpath("//a[@href='/pycharm']"));
        WebDriverWait wait = new WebDriverWait(BaseTest.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(pyCharmClick));
        pyCharmClick.click();
    }

    @Then("Verify that 'Download' tittle is displayed")
    public void verifyThatGettingStartedWithWritersideTittle() {
        WebElement downloadButton = BaseTest.getDriver().findElement(By.xpath("//a[@data-test='button' and @href='/pycharm/download/' and @type='button')]"));
        WebDriverWait wait = new WebDriverWait(BaseTest.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(downloadButton));
        if (downloadButton.isEnabled()) {
            System.out.println("The 'Download' button is enabled. Proceeding to click.");
            downloadButton.click();
        } else {
            System.out.println("The 'Download' button is disabled. Cannot proceed.");
        }
    }
}
