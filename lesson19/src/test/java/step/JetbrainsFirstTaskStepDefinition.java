package step;

import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class JetbrainsFirstTaskStepDefinition {

    @Then("Verify that 'SDK docs' button text is displayed")
    public void verifyThatSDKDocsButtonTextIsDisplayed(String expectedText) {
        WebElement sdkDocsElement = BaseTest.getDriver().findElement(By.xpath("//span[contains(@class, 'animated-list__item_shown') and contains(text(), 'SDK docs')]"));

        WebDriverWait wait = new WebDriverWait(BaseTest.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.textToBePresentInElement(sdkDocsElement, expectedText));

        String actualText = sdkDocsElement.getText();
        Assertions.assertEquals(expectedText, actualText);
    }
}

