package core.wrappers.forCollection;

import core.conditions.element.ElementCondition;
import core.wrappers.forElement.LazyWrappedWebElement;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class LazyFilteredCollection extends LazyCollection {

    private ElementCondition condition;
    private LazyCollection parentCollection;

    public LazyFilteredCollection(LazyCollection parentCollection, ElementCondition condition) {
        this.parentCollection = parentCollection;
        this.condition = condition;
    }

    public String toString() {
        return parentCollection.toString() + " filter(" + condition + ')';
    }

    public List<WebElement> getWrappedEntity() {
        List<WebElement> newList = new ArrayList<WebElement>();
        List<WebElement> elements = parentCollection.getWrappedEntity();
        for (WebElement element:elements) {
            if (condition.apply(new LazyWrappedWebElement(this, element)) != null) {
                newList.add(element);
            }
        }
        return newList;
    }
}
