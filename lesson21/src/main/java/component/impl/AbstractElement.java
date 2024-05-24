package component.impl;

import component.Element;
import org.openqa.selenium.WebElement;

public class AbstractElement implements Element {

    protected WebElement wrapperElement;

    protected AbstractElement(WebElement wrapperElement) {
        this.wrapperElement = wrapperElement;
    }
}
