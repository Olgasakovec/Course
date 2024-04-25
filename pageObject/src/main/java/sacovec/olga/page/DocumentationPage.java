package sacovec.olga.page;

import org.openqa.selenium.WebDriver;
import sacovec.olga.components.Menu;

public class DocumentationPage {
    private WebDriver driver;

    public DocumentationPage(WebDriver driver) {
        this.driver=driver;
    }

    public Menu getMenu(){
        return new Menu(driver);
    }
}
