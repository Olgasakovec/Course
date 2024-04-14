package sacovec.olga;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Jetbrains {
    static ChromeOptions options;
    static WebDriver driver;

    private By developerToolLocator = By.xpath("//*[@id='wt-site-header']/div/div/div[2]/div[1]/div/nav/div[1]/button");
    private By intellijIdeaLocator = By.xpath("//*[@id='wt-site-header']/div/div/div[2]/div[1]/div/nav/div[1]/div/div/div/div[1]/div[1]/div[1]/div/div/div[2]/div/div[1]/a/span/span");
    private By pyCharmLocator = By.xpath("//*[@id='wt-site-header']/div/div/div[2]/div[1]/div/nav/div[1]/div/div/div/div[1]/div[1]/div[1]/div/div/div[2]/div/div[3]");
    private By takeVideoLocator = By.xpath("//*[@id='overview-content']/section[1]/div/div[2]/button");
    private By videoTitleLocator = By.xpath("//div[@class='c12b5a4e69860bc968b47223fd-history-item-container']//a[@href='https://www.jetbrains.com/pycharm/']");
    private By aquaLocator = By.xpath("//div[@class='_mainSubmenuItem_eh7nx _mainSubmenuItem_ldwkw _mainSubmenuItem_9vhph']");
    private By documentationLocator = By.xpath("//a[@class='wt-col-inline wt-text-2 menu-second__link wt-text-2_theme_dark _theme-dark wt-text-2_hardness_average menu-item']");
    private By overviewLocator = By.xpath("//a[@class='starting-page-card starting-page-title__card _card_1uu62mp_6 _themeLight_1uu62mp_30 _modeClassic_1uu62mp_43 _paddings24_1uu62mp_167 _bordersRadius0_1uu62mp_175']");
    private By userInterfaceLocator = By.xpath("//li[@data-toc-scroll='Guided_Tour_Around_the_User_Interface']/a");
    private By pictureLocator = By.cssSelector("img.article__img.article__bordered-element");

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

        String cookieValue = "Our website uses some cookies and records your IP address for the purposes of accessibility, security, and managing your access to the telecommunication network. You can disable data collection and cookies by changing your browser settings, but it may affect how this website functions. Learn more. With your consent, JetBrains may also use cookies and your IP address to collect individual statistics and provide you with personalized offers and ads subject to the Privacy Policy and the Terms of Use. JetBrains may use third-party services for this purpose. You can adjust or withdraw your consent at any time by visiting the Opt-Out page. [A]ccept All[M]anage Settings";
        Cookie cookie = new Cookie("jetbrains-cookies-banner-3", cookieValue);
        driver.manage().addCookie(cookie);
        System.out.println(driver.manage().getCookies());
    }

    @Test
    public void pyCharm() {
        driver.get("https://www.jetbrains.com/");
        driver.manage().window().maximize();

        WebElement developerTools = driver.findElement(developerToolLocator);
        developerTools.click();

        Actions actions = new Actions(driver);
        WebElement pyCharm = driver.findElement(pyCharmLocator);
        actions.moveToElement(pyCharm).perform();

        driver.get("https://www.jetbrains.com/pycharm/");
        WebElement takeVideo = driver.findElement(takeVideoLocator);
        takeVideo.click();

        WebElement videoTitle = new WebDriverWait(driver, java.time.Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(videoTitleLocator));
        Assertions.assertEquals("Getting Started with PyCharm: Quick Tour", videoTitle.getText());
    }

    @Test
    public void userInterface() {
        driver.get("https://www.jetbrains.com/");
        driver.manage().window().maximize();

        WebElement developerTools = driver.findElement(developerToolLocator);
        developerTools.click();

        Actions actions = new Actions(driver);
        WebElement aqua = driver.findElement(aquaLocator);

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
        int picWidth = picture.getSize().getWidth();
        int picHeight = picture.getSize().getHeight();
        Assertions.assertEquals(3008, picWidth);
        Assertions.assertEquals(1406, picHeight);
    }
}
