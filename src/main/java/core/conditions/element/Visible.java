package core.conditions.element;

import org.openqa.selenium.WebElement;

public class Visible extends ElementCondition {

    @Override
    protected WebElement check() {
        WebElement element = (WebElement) lazyEntity.getWrappedEntity();
        return element.isDisplayed() ? element : null;
    }

    @Override
    public String actual() {
        return "Not visible";
    }

    @Override
    public String expected() {
        return "Visible";
    }
}
