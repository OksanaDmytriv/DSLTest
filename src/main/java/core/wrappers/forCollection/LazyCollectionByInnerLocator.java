package core.wrappers.forCollection;

import core.wrappers.forElement.LazyElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static core.ConciseAPI.waitFor;
import static core.conditions.element.ElementConditions.present;

public class LazyCollectionByInnerLocator extends LazyCollection{

    private By locator;
    private LazyElement parentElement;

    public LazyCollectionByInnerLocator(LazyElement parentElement, By locator) {
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
