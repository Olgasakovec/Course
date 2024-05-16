package component;

import org.openqa.selenium.WebDriver;

public interface Button extends Element {

    void click();

    void hover(WebDriver driver);
}