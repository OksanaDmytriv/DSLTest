package collection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static conditions.CustomConditions.elementVisible;
import static core.ConciseAPI.getDriver;

public class LazyCollectionElementByIndex extends LazyElement {

    private int index;

    public LazyCollectionElementByIndex(By locator, int index) {
        super(locator);
        this.index = index;
    }

    public LazyCollectionElementByIndex get(int index) {
        assertThat(elementVisible);
        getDriver().findElements(locator).get(index);
        return this;
    }

    public LazyCollectionElementByIndex findLazyElementByIndex(int index) {
        get(index);
        return this;
    }

    public WebElement getWrappedEntity() {
        return getDriver().findElements(locator).get(index);
    }
}
