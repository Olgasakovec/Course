package step;

import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

import static step.CommonStep.getDriver;

public class UserGuideStepDefinition {

    @Then("Verify that User Guide button text is {string}")
    public void verifyThatUserGuideButtonTextIsUserGuide(String expectedText) {
        String actualText = getDriver().findElement(By.xpath("//div[@class='jumbotron']//a[@href='/junit5/docs/current/user-guide']")).getText();
        Assertions.assertEquals(expectedText, actualText);
    }
}
