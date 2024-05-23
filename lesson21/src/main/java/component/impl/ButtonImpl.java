package component.impl;
import component.Button;
import org.openqa.selenium.WebElement;


public class ButtonImpl extends AbstractElement implements Button {

    public ButtonImpl(WebElement wrapperElement) {
        super(wrapperElement);
    }

    @Override
    public String getText() {
        return wrapperElement.getText();
    }

    @Override
    public Boolean isDisplayed() {
        return wrapperElement.isDisplayed();
    }
}
