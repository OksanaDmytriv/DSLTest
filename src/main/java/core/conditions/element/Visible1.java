package core.conditions.element;

import org.openqa.selenium.WebElement;
import core.wrappers.LazyEntity;

public class Visible1 extends CustomElementCondition {

    private LazyEntity lazyEntity;

    @Override
    public String actual() {
        return "";
    }

    @Override
    public WebElement apply(LazyEntity lazyEntity) {
        this.lazyEntity = lazyEntity;
        WebElement element = (WebElement) lazyEntity.getWrappedEntity();
        return element.isDisplayed() ? element : null;
    }

    @Override
    public String identity() {
        return "element";
    }

    @Override
    public String expected() {
        return "";
    }

    @Override
    public LazyEntity entity() {
        return lazyEntity;
    }
}
