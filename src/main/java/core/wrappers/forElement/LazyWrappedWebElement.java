package core.wrappers.forElement;


import org.openqa.selenium.WebElement;
import core.wrappers.LazyEntity;

public class LazyWrappedWebElement extends AbstractLazyElement {

    private LazyEntity parentElement;
    private WebElement element;

    public LazyWrappedWebElement(LazyEntity parentElement, WebElement element) {
        this.parentElement = parentElement;
        this.element = element;
    }

    public String toString() {
        return parentElement.toString() + element.toString();
    }

    public WebElement getWrappedEntity() {
        return element;
    }
}
