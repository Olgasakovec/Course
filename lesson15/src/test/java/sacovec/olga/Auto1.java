package sacovec.olga;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Auto1 {

    private static ChromeOptions options;
    private ChromeDriver chromeDriver;

    @BeforeAll
    static void downloadDriver(){
        WebDriverManager.chromedriver().setup();

        options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
    }

    @BeforeEach
    void openBrowser(){
        chromeDriver = new ChromeDriver(options);
        chromeDriver.manage().window().maximize();
    }

    @AfterEach
    void closeBrowser() {
        chromeDriver.close();
    }

    @Test
    void getCurrentUrlTest() {
        chromeDriver.get("https://auto1.by/");
        String url= chromeDriver.getCurrentUrl();
        Assertions.assertEquals("https://auto1.by/", url);

        WebElement banner = chromeDriver.findElement(By.className("fotorama__wrap fotorama__wrap--css3 fotorama__wrap--slide fotorama__wrap--no-controls"));
        String bannerLink = banner.getAttribute("href");
        banner.click();
        String currentUrl = chromeDriver.getCurrentUrl();
        Assertions.assertEquals(bannerLink, currentUrl);

        WebElement catalogItem = chromeDriver.findElement(By.cssSelector("a.catalog-item[href='/masla-motornye-i-industrialnye']"));
        System.out.println("Найден элемент каталога: " + catalogItem.getText());

        WebElement filterBlock = chromeDriver.findElement(By.id("vinFilterBlock"));
        String filterBlockVin = "123456789";
        filterBlock.sendKeys(filterBlockVin);

        WebElement search = chromeDriver.findElement(By.id("microSearch"));
        String searchBlock = "ПНЕВМОШЛИФМАШИНА";
        search.sendKeys(searchBlock);
        search.submit();

        WebElement clickable = chromeDriver.findElement(By.id("showDropdown"));
        Actions actions = new Actions(chromeDriver);
                actions.click(clickable).perform();

        chromeDriver.navigate().to("https://auto1.by/news");
        chromeDriver.navigate().refresh();
        chromeDriver.navigate().back();

        chromeDriver.navigate().to("https://auto1.by/News");
        WebElement image = chromeDriver.findElement(By.className("col-sm-4 col-xs-4 news-image-item"));
        String imageSrc = image.getAttribute("src");
        Assertions.assertTrue(imageSrc.endsWith(".png"));

        chromeDriver.get("https://auto1.by/");
        WebElement menuElement = chromeDriver.findElement(By.name("Быстрый выбор авто"));
        menuElement.click();
        WebElement dropDownMenu = chromeDriver.findElement(By.id("collapseForm"));
        Assertions.assertTrue(dropDownMenu.isDisplayed());

        WebElement testCheck = chromeDriver.findElement(By.name("Акции"));
        Assertions.assertTrue(testCheck.isDisplayed());

        chromeDriver.navigate().to("https://auto1.by/masla-motornye-i-industrialnye/motornoe-maslo");
        WebElement buyButton = chromeDriver.findElement(By.className("buy_btn_title"));
        buyButton.click();
        WebDriverWait wait = new WebDriverWait(chromeDriver, Duration.ofSeconds(10));
        WebElement loginFormMail = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginFormMail")));
        Assertions.assertTrue(loginFormMail.isDisplayed());
    }
}
