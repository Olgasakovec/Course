package step;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class UserGuideStepDefinition {
    private WebDriver driver;

    @After
    public void closeDrive() {
        driver.quit();
    }

    @Given("Open browser and maximize window")
    public void openBrowserAndMaximizeWindow(){
        WebDriverManager.chromedriver().clearDriverCache().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
    }
    @When("Navigate to the {string} url")
    public void navigateToUrl(String url){
       driver.get(url);
    }

    @Then("Verify that User Guide button text is {string}")
    public void verifyThatUserGuideButtonTextIsUserGuide(String expectedText){
        String actualText = driver.findElement(By.xpath("//div[@id='toc']//a[@href='#_testng_documentation']")).getText();
        Assertions.assertEquals(expectedText, actualText);
    }
}
