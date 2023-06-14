package webauto.controls;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import webauto.singletonSession.Session;

public class ControlBase {
    protected By locator;
    protected WebElement control;

    public ControlBase(By locator) {
        this.locator = locator;
    }

    protected void findControl() {
        control = Session.getInstance().getBrowser().findElement(locator);
    }

    public void click() {
        this.findControl();
        this.control.click();
    }

    public boolean isControlDisplayed() {
        try {
            this.findControl();
            return this.control.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public String getTextValue() {
        this.findControl();
        return this.control.getText();
    }

    public String getTextValueByAttribute(String attr) {
        this.findControl();
        return this.control.getAttribute(attr);
    }
}
