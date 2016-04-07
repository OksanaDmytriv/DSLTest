package core.conditions.element;

import org.openqa.selenium.WebElement;

public class Visible extends ElementCondition {

    private WebElement element;

    @Override
    protected WebElement check() {
        element = (WebElement) lazyEntity.getWrappedEntity();
        return element.isDisplayed() ? element : null;
    }

    @Override
    public String actual() {
        return "Element is visible:" + element.isDisplayed();
    }

    @Override
    public String expected() {
        return "Visible";
    }
}
