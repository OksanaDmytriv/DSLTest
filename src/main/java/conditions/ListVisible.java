package conditions;

import collection.LazyEntity;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Iterator;
import java.util.List;

public class ListVisible extends CustomConditions<List<WebElement>> {

    private static By locator;
    private LazyEntity lazyEntity;
    private List elements;

    @Override
    public String toString() {
        return String.format("Elements located by %s\n should be visible", locator);
    }

    @Override
    protected List<WebElement> check(LazyEntity lazyEntity) {
        this.lazyEntity = lazyEntity;
        elements = (List<WebElement>) lazyEntity.getWrappedEntity();
        //List elements = ConciseAPI.getDriver().findElements(locator);
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
