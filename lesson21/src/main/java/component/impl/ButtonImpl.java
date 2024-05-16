package component.impl;

import component.Button;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ButtonImpl extends AbstractElement implements Button {

    public ButtonImpl(WebElement wrapperElement) {
        super(wrapperElement);
    }

    @Override
    public void click() {

    }

    @Override
    public void hover(WebDriver driver) {
        new Actions(driver).moveToElement(wrapperElement).perform();
    }
}
