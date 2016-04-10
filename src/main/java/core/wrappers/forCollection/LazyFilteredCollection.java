package core.wrappers.forCollection;

import core.conditions.element.ElementCondition;
import core.wrappers.forElement.LazyWrappedWebElement;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class LazyFilteredCollection extends AbstractLazyCollection {

    private ElementCondition condition;
    private AbstractLazyCollection parentCollection;

    public LazyFilteredCollection(AbstractLazyCollection parentCollection, ElementCondition condition) {
        this.parentCollection = parentCollection;
        this.condition = condition;
    }

    public String toString() {
        return parentCollection.toString() + " filter(" + condition.getClass() + ')';
    }

    public List<WebElement> getWrappedEntity() {
        List<WebElement> newList = new ArrayList<WebElement>();
        List<WebElement> elements = parentCollection.getWrappedEntity();
        for (WebElement element : elements) {
            if (new LazyWrappedWebElement(this, element).is(condition)) {
                newList.add(element);
            }
        }
        return newList;
    }
}
