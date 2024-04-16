package sacovec.olga;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Jetbrains {
    static ChromeOptions options;
    static WebDriver driver;

    private By developerToolLocator = By.xpath("//button[@type='button' and @aria-label='Developer Tools: Open submenu']");
    private By teamToolsLocator = By.xpath("//button[@type='button' and @aria-label='Team Tools: Open submenu']");
    private By dataLoreLocator = By.xpath("//a[@href='/datalore/' and //span[@class='rs-text-2 rs-text-2_theme_light _mainSubmenuItem__title_3d77w']]");
    private By intellijIdeaLocator = By.xpath("//span[@class='_mainSubmenuItem__titlePart_oppnk'] /span[@class='rs-text-2 rs-text-2_theme_light _mainSubmenuItem__title_3d77w _mainSubmenuItem__titleWithLogo_3zbq8']");
    private By watchOverviewLocator = By.xpath("//button[@data-test='button' and contains(text(), 'Watch overview')]");
    private By videoTitleLocator = By.xpath("//div[@class='ytp-title-link yt-uix-sessionlink']//a[@href='https://www.youtube.com/watch?v=LFiINOnA2cY']");
    private  By videoAreaLocator = By.xpath("//div[@class='html5-video-container']//video[contains(@class, 'video-stream') and @src='blob:https://www.youtube.com/96ee3a0b-ef90-467b-a945-61aaab2fd162']");
    private By aquaLocator = By.xpath("//div[@class='_mainSubmenuItem_eh7nx _mainSubmenuItem_ldwkw _mainSubmenuItem_9vhph']");
    private By documentationLocator = By.xpath("//a[@class='wt-col-inline wt-text-2 menu-second__link wt-text-2_theme_dark _theme-dark wt-text-2_hardness_average menu-item']");
    private By overviewLocator = By.xpath("//a[@class='starting-page-card starting-page-title__card _card_1uu62mp_6 _themeLight_1uu62mp_30 _modeClassic_1uu62mp_43 _paddings24_1uu62mp_167 _bordersRadius0_1uu62mp_175']");
    private By userInterfaceLocator = By.xpath("//li[@data-toc-scroll='Guided_Tour_Around_the_User_Interface']/a");
    private By pictureLocator = By.cssSelector("img.article__img.article__bordered-element");
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
    }

    @AfterEach
    void closeBrowser() {
        driver.close();
    }

    @Test
    public void cookieTest() {
        driver.get("https://www.jetbrains.com/");
        driver.manage().window().maximize();

        WebElement developerTools = driver.findElement(developerToolLocator);
        developerTools.click();

        Actions actions = new Actions(driver);
        WebElement intellijIdeas = driver.findElement(intellijIdeaLocator);
        actions.moveToElement(intellijIdeas).perform();

        WebElement cookieValue = driver.findElement(cookieValueLocator);
        Assertions.assertTrue(cookieValue.isDisplayed());
    }

    @Test
    public void pyCharm() {
        driver.get("https://www.jetbrains.com/");
        driver.manage().window().maximize();

        WebElement teamTools = driver.findElement(teamToolsLocator);
        teamTools.click();

        Actions actions = new Actions(driver);
        WebElement dataLore = driver.findElement(dataLoreLocator);
        actions.moveToElement(dataLore).perform();

        driver.get("https://www.jetbrains.com/datalore/");
        WebElement watchOverview = driver.findElement(watchOverviewLocator);
        watchOverview.click();

        WebElement videoArea = new WebDriverWait(driver, Duration.ofSeconds(15))
                .until(ExpectedConditions.elementToBeClickable(videoAreaLocator));
        videoArea.click();

        WebElement videoTitle = new WebDriverWait(driver, Duration.ofSeconds(15))
                .until(ExpectedConditions.visibilityOfElementLocated(videoTitleLocator));
        Assertions.assertTrue(videoTitle.isDisplayed());
    }

    @Test
    public void userInterface() {
        driver.get("https://www.jetbrains.com/");
        driver.manage().window().maximize();

        WebElement developerTools = driver.findElement(developerToolLocator);
        developerTools.click();

        Actions actions = new Actions(driver);
        WebElement aqua = driver.findElement(aquaLocator);
        actions.moveToElement(aqua).perform();

        driver.get("https://www.jetbrains.com/aqua/");
        WebElement documentation = driver.findElement(documentationLocator);
        documentation.click();

        driver.get("https://www.jetbrains.com/help/aqua/getting-started-aqua.html");
        WebElement overview = driver.findElement(overviewLocator);
        overview.click();

        driver.get("https://www.jetbrains.com/help/aqua/about-aqua-ide.html");
        WebElement userInterface = driver.findElement(userInterfaceLocator);
        userInterface.click();

        WebElement picture = driver.findElement(pictureLocator);
        int naturalWidth = picture.nat;
        int naturalHeight = picture.getHeight();
        Assertions.assertEquals(3008, naturalWidth);
        Assertions.assertEquals(1406, naturalHeight);
    }
}
