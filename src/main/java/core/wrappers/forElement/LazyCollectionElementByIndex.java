package core.wrappers.forElement;

import core.wrappers.forCollection.LazyCollection;
import org.openqa.selenium.WebElement;

import static core.ConciseAPI.waitFor;
import static core.conditions.collection.CollectionConditions.minimumSize;

public class LazyCollectionElementByIndex extends LazyElement {

    private int index;
    private LazyCollection parentCollection;

    public LazyCollectionElementByIndex(LazyCollection parentCollection, int index) {
        this.parentCollection = parentCollection;
        this.index = index;
    }

    public String toString() {
        return parentCollection.toString() + "[" + index + "]";
    }

    public WebElement getWrappedEntity() {
        waitFor(parentCollection, minimumSize(index + 1));
        return parentCollection.getWrappedEntity().get(index);
    }

}
