package conditions.collection;

import collection.LazyEntity;
import org.openqa.selenium.WebElement;

import java.util.Iterator;
import java.util.List;

public class ListVisible extends CustomConditionsCollection {

    private LazyEntity lazyEntity;
    private List elements;

    @Override
    public String toString() {
        return String.format("For elements located by %s\n should be visible", lazyEntity.getLocatorDescription());
    }

    @Override
    protected List<WebElement> check(LazyEntity lazyEntity) {
        this.lazyEntity = lazyEntity;
        elements = (List<WebElement>) lazyEntity.getWrappedEntity();
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
