package conditions.collection;

import org.openqa.selenium.WebElement;
import wrappers.LazyEntity;

import java.util.Iterator;
import java.util.List;

public class ListVisible extends CustomCollectionCondition {

    private LazyEntity lazyEntity;

    @Override
    public String toString() {
        return String.format("For elements located by %s\n should be visible", lazyEntity.getLocatorDescription());
    }

    @Override
    protected List<WebElement> apply(LazyEntity lazyEntity) {
        this.lazyEntity = lazyEntity;
        List elements = (List<WebElement>) lazyEntity.getWrappedEntity();
        Iterator iterator = elements.iterator();
        WebElement element;

        do {
            if (!iterator.hasNext()) {
                return elements.size() > 0 ? elements : null;
            }
            element = (WebElement) iterator.next();
        }
        while (element.isDisplayed());
        return null;
    }
}
