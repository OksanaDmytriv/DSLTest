package core.conditions.element;

import org.openqa.selenium.WebElement;

public class Present extends ElementCondition {

    private WebElement element;

    protected WebElement check() {
        element = (WebElement) lazyEntity.getWrappedEntity();
        return element;
    }

    public String actual() {
        return "Element is present:" + element.isDisplayed();
    }

    @Override
    public String expected() {
        return "Present";
    }
}
