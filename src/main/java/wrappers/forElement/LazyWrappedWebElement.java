package wrappers.forElement;


import conditions.element.CustomElementCondition;
import org.openqa.selenium.WebElement;
import wrappers.LazyEntity;

import static core.ConciseAPI.waitForWrapper;

public class LazyWrappedWebElement extends LazyElement {

    private LazyEntity parentElement;
    private WebElement element;
    private CustomElementCondition condition;

    public LazyWrappedWebElement(LazyEntity parentElement, WebElement element) {
        super(null);
        this.parentElement = parentElement;
        this.element = element;
    }

    public String getLocatorDescription() {
        return parentElement.getLocatorDescription();
    }

    public WebElement getWrappedEntity() {
        return element;
    }

    public boolean isValid(CustomElementCondition condition) {
        return waitForWrapper(this, condition, 0) != null ? true : false;
    }
}
