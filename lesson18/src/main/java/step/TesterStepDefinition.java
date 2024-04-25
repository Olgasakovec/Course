package step;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;

public class TesterStepDefinition {
    private String string1;
    private String string2;

    @Then("Verify that length of {string} greater length <length> than {string}")
    public void compareStringLengths(String str1, String str2) {
        string1 = str1;
        string2 = str2;
    }

    @And("Check the lenght comparison")
    public void checkTheLenghtComparison() {
        Assertions.assertTrue(string1.length() > string2.length(), "Length of " + string1 + " should be greater than length of " + string2);
    }
}
