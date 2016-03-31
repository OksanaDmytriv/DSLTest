package core.wrappers.forElement;


import org.openqa.selenium.WebElement;
import core.wrappers.LazyEntity;

public class LazyWrappedWebElement extends LazyElement {

    private LazyEntity parentElement;
    private WebElement element;

    public LazyWrappedWebElement(LazyEntity parentElement, WebElement element) {
        super(null);
        this.parentElement = parentElement;
        this.element = element;
    }

    public String toString() {
        return parentElement.toString();
    }

    public WebElement getWrappedEntity() {
        return element;
    }
}
