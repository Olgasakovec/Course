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
        WebDriverWait wait = new WebDriverWait(BaseTest.getDriver(), Duration.ofSeconds(20));
        By sdkDocsLocator = By.xpath("//span[@class='animated-list__item animated-list__item_shown']/span[text()='SDK docs']");

        boolean result = wait.until(ExpectedConditions.textToBePresentInElementLocated(sdkDocsLocator, expectedText));
        Assertions.assertTrue(result, "Expected text is not present in the element");
    }
}
