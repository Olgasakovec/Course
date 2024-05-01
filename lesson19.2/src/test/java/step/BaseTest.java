package step;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseTest {

    public static WebDriver getDriver() {
        return driver.get();
    }

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    @Before
    public void downloadDriver() {
        WebDriverManager.chromedriver().clearDriverCache().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver.set(new ChromeDriver(options));
        driver.get().manage().window().maximize();
    }

    @Given("Navigate to the {string} url")
    public void navigateToUrl(String url) {
        getDriver().get(url);
    }

    @When("Click to the menu 'Developer Tools'")
    public void clickToTheDeveloperTools() {
        WebElement developerToolsMenu = BaseTest.getDriver().findElement(By.xpath("//button[@type='button' and @aria-label='Developer Tools: Open submenu']"));
        developerToolsMenu.click();
    }

    @And("Choose 'Writerside' and click")
    public void chooseWritersideAndClick() {
        WebDriverWait wait = new WebDriverWait(BaseTest.getDriver(), Duration.ofSeconds(10));
        WebElement writersideMenuItem = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@data-test='main-submenu']//a[@href=/writerside/']")));
        writersideMenuItem.click();
    }

    @After
    public void closeBrowser() {
        driver.get().close();
    }
}

