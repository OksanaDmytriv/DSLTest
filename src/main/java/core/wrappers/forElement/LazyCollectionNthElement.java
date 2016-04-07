package core.wrappers.forElement;

import core.wrappers.forCollection.AbstractLazyCollection;
import org.openqa.selenium.WebElement;

import static core.ConciseAPI.waitFor;
import static core.conditions.collection.CollectionConditions.minimumSize;

public class LazyCollectionNthElement extends AbstractLazyElement {

    private int index;
    private AbstractLazyCollection parentCollection;

    public LazyCollectionNthElement(AbstractLazyCollection parentCollection, int index) {
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
