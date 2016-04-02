package core.wrappers.forElement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static core.ConciseAPI.getDriver;

public class LazyElementByLocator extends LazyElement {

    private By locator;

    public LazyElementByLocator(By locator) {
        this.locator = locator;
    }

    public String toString() {
        return locator.toString();
    }

    public WebElement getWrappedEntity() {
        return getDriver().findElement(locator);
    }
}
