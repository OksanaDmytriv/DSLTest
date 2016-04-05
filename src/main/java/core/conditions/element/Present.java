package core.conditions.element;

import core.wrappers.LazyEntity;
import org.openqa.selenium.WebElement;

public class Present extends CustomElementCondition {

    private LazyEntity lazyEntity;

    public String actual() {
        return "";
    }

    public WebElement apply(LazyEntity lazyEntity) {
        this.lazyEntity = lazyEntity;
        WebElement element = (WebElement) lazyEntity.getWrappedEntity();
        return element;
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
