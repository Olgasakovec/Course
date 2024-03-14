package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class GoogleTest {

    private static ChromeOptions options;
    private ChromeDriver chromeDriver;

    @BeforeAll
    static void downLoadDriver(){
        WebDriverManager.chromedriver().clearDriverCache().setup();

        options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
    }

    @BeforeEach
    void openBrowser() {
        chromeDriver = new ChromeDriver(options);
    }


    @Test
    void getCurrentUrlTest(){
        chromeDriver.get("https://yandex.by/");

        String url = chromeDriver.getCurrentUrl();

        Assertions.assertEquals(url, "https://yandex.by/" );
    }

    @AfterEach
    void closeBrowser(){
        chromeDriver.close();
    }
}
