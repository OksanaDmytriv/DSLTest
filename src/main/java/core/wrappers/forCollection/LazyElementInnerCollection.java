package core.wrappers.forCollection;

import core.wrappers.forElement.AbstractLazyElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static core.ConciseAPI.waitFor;
import static core.conditions.element.ElementConditions.present;

public class LazyElementInnerCollection extends AbstractLazyCollection {

    private By locator;
    private AbstractLazyElement parentElement;

    public LazyElementInnerCollection(AbstractLazyElement parentElement, By locator) {
        this.parentElement=parentElement;
        this.locator = locator;
    }

    public String toString() {
        return parentElement.toString() + " " + locator + "";
    }

    public List<WebElement> getWrappedEntity() {
        waitFor(parentElement, present());
        return parentElement.getWrappedEntity().findElements(locator);
    }
}
