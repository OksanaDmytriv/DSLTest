package core.wrappers.forCollection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static core.ConciseAPI.getDriver;

public class LazyCollectionByLocator extends LazyCollection {

    private By locator;

    public LazyCollectionByLocator(By locator) {
        this.locator = locator;
    }

    public String toString() {
        return locator.toString();
    }

    public List<WebElement> getWrappedEntity() {
        return getDriver().findElements(locator);
    }
}


