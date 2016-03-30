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

    public String toString() {
        return parentCollection.toString() + "[" + index + "]";
    }

    public WebElement getWrappedEntity() {
        return parentCollection.getWrappedEntity().get(index);
    }

}
