package step;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TestOrgStepDefinition {

    private WebDriver driver;

    @After
    public void closeDriver(){
        driver.quit();
    }

    @Given("Navigate to the webpage {string} url")
    public void navigateToThePageUrl(String url){
        WebDriverManager.chromedriver().clearDriverCache().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        driver.get(url);
    }

    @When("Window maximize")
    public void WindowMaximize(){
        driver.manage().window().maximize();
    }

    @And("Click to the link in the left menu '13. The TestNG TextBook: Next Generation Java Testing'")
    public void clickToTheLinkInTheLeft (){
        driver.findElement(By.xpath("//div[@id='tocbot']//a[@href='#_the_testng_textbook_next_generation_java_testing']")).click();
    }

    @Then("Check that image format is .jpg")
    public void checkThatImageFormatIsJpg(){
        WebElement image = driver.findElement(By.xpath("//div[@class='imageblock']//img[@src='pics/book-cover.jpg']"));
        String imageSource = image.getAttribute("src");
        Assertions.assertTrue(imageSource.endsWith(".jpg"));
    }
}
