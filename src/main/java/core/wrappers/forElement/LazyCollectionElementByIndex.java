package core.wrappers.forElement;

import core.wrappers.forCollection.LazyCollection;
import org.openqa.selenium.WebElement;

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
        //waitFor(this, minimumSize(index + 1));
        return parentCollection.getWrappedEntity().get(index);
    }

}
