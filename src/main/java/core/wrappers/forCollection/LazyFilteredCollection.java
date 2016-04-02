package core.wrappers.forCollection;

import core.conditions.element.CustomElementConditions;
import org.openqa.selenium.WebElement;
import core.wrappers.forElement.LazyWrappedWebElement;

import java.util.ArrayList;
import java.util.List;

import static core.ConciseAPI.conditionApplyWithExceptionsCatching;

public class LazyFilteredCollection extends LazyCollection {

    private CustomElementConditions condition;
    private LazyCollection parentCollection;

    public LazyFilteredCollection(LazyCollection parentCollection, CustomElementConditions condition) {
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
            if (conditionApplyWithExceptionsCatching(new LazyWrappedWebElement(parentCollection, element), condition) != null) {
                newList.add(element);
            }
        }
        return newList;
    }
}
