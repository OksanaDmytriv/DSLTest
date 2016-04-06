package core.conditions.element;

import org.openqa.selenium.WebElement;

public class Present extends ElementCondition {

    protected WebElement check() {
        WebElement element = (WebElement) lazyEntity.getWrappedEntity();
        return element;
    }

    public String actual() {
        return "Absent";
    }

    @Override
    public String expected() {
        return "Present";
    }
}
