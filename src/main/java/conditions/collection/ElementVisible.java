package conditions.collection;

import collection.LazyEntity;
import org.openqa.selenium.WebElement;

public class ElementVisible extends CustomConditionsCollection {

    private LazyEntity lazyEntity;

    @Override
    public String toString() {
        return String.format("For element located by %s\n should be visible", lazyEntity.getLocatorDescription());
    }

    @Override
    protected WebElement check(LazyEntity lazyEntity) {
        this.lazyEntity = lazyEntity;
        WebElement element = (WebElement) lazyEntity.getWrappedEntity();
        return element.isDisplayed() ? element : null;
    }
}
