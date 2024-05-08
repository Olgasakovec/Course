package page;

import component.Button;
import component.Video;
import org.openqa.selenium.WebDriver;


public class JetBrainsAiPage {

    private WebDriver driver;

    public JetBrainsAiPage(WebDriver driver) {
        this.driver = driver;
    }

    public Button getButton() {
        return new Button(driver);
    }

    public Video getVideo() {
        return new Video(driver);
    }
}
