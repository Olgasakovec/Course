package sacovec.olga;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PageTitleTest {

    private static ChromeDriver chromeDriver;

    private static ChromeOptions options;

    @Test
    public void testPageTitle(){
        String companySite = ClientXmlAuto.getCompanySite();
        if (companySite != null){

            WebDriverManager.chromedriver().setup();
            options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            chromeDriver = new ChromeDriver(options);

            try{
                chromeDriver.get(companySite);
                String title = chromeDriver.getTitle();
                assertEquals ("EPAM | Software Engineering & Product Development Services", title);
            }
            finally {
                chromeDriver.quit();
            }
        }
    }
}
