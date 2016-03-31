package core.conditions.element;

import org.openqa.selenium.WebElement;
import core.wrappers.LazyEntity;

public class Visible extends CustomElementConditions {

    private LazyEntity lazyEntity;

    @Override
    public String toString() {
        return String.format("element should be Visible");
    }

    @Override
    public String getActualValuesDescription() {
        return "";
    }

    @Override
    public WebElement apply(LazyEntity lazyEntity) {
        this.lazyEntity = lazyEntity;
        WebElement element = (WebElement) lazyEntity.getWrappedEntity();
        return element.isDisplayed() ? element : null;
    }
}