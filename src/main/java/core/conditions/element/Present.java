package core.conditions.element;

import core.wrappers.LazyEntity;
import org.openqa.selenium.WebElement;

public class Present extends CustomElementCondition {

    protected WebElement check(LazyEntity lazyEntity) {
        this.lazyEntity = lazyEntity;
        WebElement element = (WebElement) lazyEntity.getWrappedEntity();
        return element;
    }

    public String actual() {
        return "";
    }

    @Override
    public String expected() {
        return "";
    }
}
