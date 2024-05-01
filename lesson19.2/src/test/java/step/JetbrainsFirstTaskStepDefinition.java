package step;

import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class JetbrainsFirstTaskStepDefinition {
    @Then("Verify that {string} button text is displayed")
    public void verifyThatSDKDocsButtonTextIsDisplayed(String expectedText) {
        WebDriverWait wait = new WebDriverWait(BaseTest.getDriver(), Duration.ofSeconds(10));
        By sdkDocsLocator = By.xpath("//h1[contains(@text(), 'Write, test, build, and publish the best' and contains(text(), 'SDK docs')");

        wait.until(ExpectedConditions.textToBePresentInElementLocated(sdkDocsLocator, expectedText));

        WebElement sdkDocsElement = BaseTest.getDriver().findElement(sdkDocsLocator);
        String actualText = sdkDocsElement.getText();
        Assertions.assertEquals(expectedText, actualText);
    }
}
