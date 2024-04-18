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

import static javax.xml.bind.JAXBIntrospector.getValue;

public class Jetbrains {
    static ChromeOptions options;
    static WebDriver driver;

    private By developerToolLocator = By.xpath("//button[@type='button' and @aria-label='Developer Tools: Open submenu']");
    private By teamToolsLocator = By.xpath("//button[@type='button' and @aria-label='Team Tools: Open submenu']");
    private By dataLoreLocator = By.xpath("//a[@href='/datalore/' and //span[@class='rs-text-2 rs-text-2_theme_light _mainSubmenuItem__title_3d77w']]");
    private By intellijIdeaLocator = By.xpath("//span[@class='_mainSubmenuItem__titlePart_oppnk'] /span[@class='rs-text-2 rs-text-2_theme_light _mainSubmenuItem__title_3d77w _mainSubmenuItem__titleWithLogo_3zbq8')// and text()= 'IntelliJ IDEA']");
    private By watchOverviewLocator = By.xpath("//button[@data-test='button' and contains(text(), 'Watch overview')]");
    private By videoTitleLocator = By.xpath("//div[@class='ytp-title-link yt-uix-sessionlink']//a[@href='https://www.youtube.com/watch?v=LFiINOnA2cY']");
    private By iFrameLocator = By.xpath("//iframe[@class='wt-youtube-player__player']");
    private By aquaLocator = By.xpath("//div[@class='_mainSubmenuItem_eh7nx _mainSubmenuItem_ldwkw _mainSubmenuItem_9vhph']");
    private By documentationLocator = By.xpath("//a[@class='wt-col-inline wt-text-2 menu-second__link wt-text-2_theme_dark _theme-dark wt-text-2_hardness_average menu-item']");
    private By overviewLocator = By.xpath("//a[@class='starting-page-card starting-page-title__card _card_1uu62mp_6 _themeLight_1uu62mp_30 _modeClassic_1uu62mp_43 _paddings24_1uu62mp_167 _bordersRadius0_1uu62mp_175']");
    private By userInterfaceLocator = By.xpath("//li[@data-toc-scroll='Guided_Tour_Around_the_User_Interface']/a");
    private By pictureLocator = By.xpath("//img[@src='https://resources.jetbrains.com/help/img/idea/aqua_locators_evaluator.png']");
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

        WebElement iFrame = new WebDriverWait(driver, Duration.ofSeconds(15))
                .until(ExpectedConditions.elementToBeClickable(iFrameLocator));
        driver.switchTo().frame(iFrame);

        WebElement videoTitle = new WebDriverWait(driver, Duration.ofSeconds(15))
                .until(ExpectedConditions.elementToBeClickable(videoTitleLocator));
        Assertions.assertEquals("Video title", videoTitle.getText());
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

        driver.get("https://www.jetbrains.com/help/aqua/guided-tour-around-the-user-interface.html");
        WebElement picture = driver.findElement(pictureLocator);
        String naturalWidth = picture.getAttribute("naturalWidth");
        String naturalHeight = picture.getAttribute("naturalHeight");


        String expectedWidth = "3008";
        String expectedHeight = "1406";

        Assertions.assertEquals(expectedWidth,naturalWidth);
        Assertions.assertEquals(expectedHeight, naturalHeight);
    }
}
