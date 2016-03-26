package conditions.element;

import org.openqa.selenium.WebElement;
import wrappers.LazyEntity;

public class ElementVisible extends CustomElementCondition {

    private LazyEntity lazyEntity;

    @Override
    public String toString() {
        return String.format("For forElement located by %s\n should be visible", lazyEntity.getLocatorDescription());
    }

    @Override
    protected WebElement check(LazyEntity lazyEntity) {
        this.lazyEntity = lazyEntity;
        WebElement element = (WebElement) lazyEntity.getWrappedEntity();
        return element.isDisplayed() ? element : null;
    }
}
