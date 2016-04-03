package core.wrappers.forCollection;

import core.wrappers.forElement.LazyElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LazyCollectionByElementLocator extends LazyCollection{

    private By locator;
    private LazyElement parentElement;

    public LazyCollectionByElementLocator(LazyElement parentElement, By locator) {
        this.parentElement=parentElement;
        this.locator = locator;
    }

    public String toString() {
        return parentElement.toString() + " " + locator + "";
    }

    public List<WebElement> getWrappedEntity() {
        return parentElement.getWrappedEntity().findElements(locator);
    }
}
