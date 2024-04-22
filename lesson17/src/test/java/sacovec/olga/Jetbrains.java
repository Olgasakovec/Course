package sacovec.olga;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Jetbrains {
    static ChromeOptions options;
    static WebDriver driver;

    private By developerToolLocator = By.xpath("//button[@type='button' and @aria-label='Developer Tools: Open submenu']");
    private By teamToolsLocator = By.xpath("//button[@type='button' and @aria-label='Team Tools: Open submenu']");
    private By dataLoreLocator = By.xpath("//div[@data-test='main-submenu']//a[@href='/datalore/']//span[@data-test='main-submenu-item-description']");
    private By intellijIdeaLocator = By.xpath("//div[@data-test='main-submenu-item']//a[@href='/idea/']");
    private By watchOverviewLocator = By.xpath("//button[@data-test='button' and contains(text(), 'Watch overview')]");
    private By videoTitleLocator = By.xpath("//a[@class='ytp-title-link yt-uix-sessionlink' and text()='Datalore Overview (2024) – The Collaborative Data Science Platform for Teams']");
    private By iFrameLocator = By.xpath("//iframe[@class='wt-youtube-player__player']");
    private By aquaLocator = By.xpath("//div[@data-test='main-submenu-item']//a[@href='/aqua/']");
    private By documentationLocator = By.xpath("//div[@id='js-menu-second-desktop']//a[@href='/help/aqua']");
    private By overviewLocator = By.xpath("//section//a[@href='about-aqua-ide.html']");
    private By userInterfaceLocator = By.xpath("//li[@data-toc-scroll='Guided_Tour_Around_the_User_Interface']/a");
    private By pictureLocator = By.xpath("//div[@data-test='article']//img[@src='https://resources.jetbrains.com/help/img/idea/aqua_overview.png']");
    private By cookieValueLocator = By.xpath("//div[@class='jetbrains-cookies-banner-3__text-content']");

    @BeforeAll
    static void downloadDriver() {
        WebDriverManager.chromedriver().clearDriverCache().setup();
        options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
    }

    @BeforeEach
    void openBrowser() {
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
    }

    @AfterEach
    void closeBrowser() {
        driver.close();
    }

    @Test
    public void cookieTest() {
        driver.get("https://www.jetbrains.com/");

        WebElement developerTools = driver.findElement(developerToolLocator);
        developerTools.click();

        WebElement intellijIdeas = new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(intellijIdeaLocator));
        intellijIdeas.click();

        WebElement cookieValue = new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(cookieValueLocator));
        Assertions.assertTrue(cookieValue.isDisplayed());
        Assertions.assertEquals("Our website uses some cookies and records your IP address for the purposes of accessibility, security, and managing your access to the telecommunication network. You can disable data collection and cookies by changing your browser settings, but it may affect how this website functions. Learn more. With your consent, JetBrains may also use cookies and your IP address to collect individual statistics and provide you with personalized offers and ads subject to the Privacy Policy and the Terms of Use. JetBrains may use third-party services for this purpose. You can adjust or withdraw your consent at any time by visiting the Opt-Out page.", cookieValue.getText());
    }

    @Test
    public void pyCharm() {
        driver.get("https://www.jetbrains.com/");

        WebElement teamTools = driver.findElement(teamToolsLocator);
        teamTools.click();

        WebElement dataLore = driver.findElement(dataLoreLocator);
        dataLore.click();

        driver.get("https://www.jetbrains.com/datalore/");
        WebElement watchOverview = driver.findElement(watchOverviewLocator);
        watchOverview.click();

        WebElement iFrame = new WebDriverWait(driver, Duration.ofSeconds(15))
                .until(ExpectedConditions.elementToBeClickable(iFrameLocator));
        driver.switchTo().frame(iFrame);
        WebElement videoTitle = new WebDriverWait(driver, Duration.ofSeconds(15))
                .until(ExpectedConditions.elementToBeClickable(videoTitleLocator));
        Assertions.assertEquals("Datalore Overview (2024) – The Collaborative Data Science Platform for Teams", videoTitle.getText());
    }

    @Test
    public void userInterface() {
        driver.get("https://www.jetbrains.com/");

        WebElement developerTools = driver.findElement(developerToolLocator);
        developerTools.click();

        WebElement aqua = driver.findElement(aquaLocator);
        aqua.click();

        WebElement documentation = new WebDriverWait(driver, Duration.ofSeconds(15))
                .until(ExpectedConditions.elementToBeClickable(documentationLocator));
        documentation.click();

        WebElement overview = new WebDriverWait(driver, Duration.ofSeconds(15))
                .until(ExpectedConditions.elementToBeClickable(overviewLocator));
        overview.click();

        WebElement userInterface = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(userInterfaceLocator));
        userInterface.click();

        WebElement picture = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(pictureLocator));
        String naturalWidth = picture.getAttribute("naturalWidth");
        String naturalHeight = picture.getAttribute("naturalHeight");

        String expectedWidth = "3008";
        String expectedHeight = "1406";

        Assertions.assertEquals(expectedWidth,naturalWidth);
        Assertions.assertEquals(expectedHeight, naturalHeight);
    }
}
