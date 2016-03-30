package conditions.element;

import org.openqa.selenium.WebElement;
import wrappers.LazyEntity;

public class ElementVisible extends CustomElementCondition {

    private LazyEntity lazyEntity;

    @Override
    public String toString() {
        return String.format("element should be visible");
    }

    @Override
    public WebElement apply(LazyEntity lazyEntity) {
        this.lazyEntity = lazyEntity;
        WebElement element = (WebElement) lazyEntity.getWrappedEntity();
        return element.isDisplayed() ? element : null;
    }

    @Override
    public String getActualValuesDescription() {
        return "";
    }
}
