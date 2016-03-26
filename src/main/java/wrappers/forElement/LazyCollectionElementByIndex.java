package wrappers.forElement;

import org.openqa.selenium.WebElement;
import wrappers.forCollection.LazyCollection;

public class LazyCollectionElementByIndex extends LazyElement {

    private int index;
    private LazyCollection parentCollection;

    public LazyCollectionElementByIndex(LazyCollection parentCollection, int index) {
        super(null);
        this.parentCollection = parentCollection;
        this.index = index;
    }

    public String getLocatorDescription() {
        return parentCollection.getLocatorDescription().concat(":nth-child(" + index + ")");
    }

    public WebElement getWrappedEntity() {
        return parentCollection.getWrappedEntity().get(index);
    }

}
