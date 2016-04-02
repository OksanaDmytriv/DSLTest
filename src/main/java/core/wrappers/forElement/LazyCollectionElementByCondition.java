package core.wrappers.forElement;

import core.conditions.element.CustomElementConditions;
import core.wrappers.forCollection.LazyCollection;
import org.openqa.selenium.WebElement;

import java.util.List;

import static core.ConciseAPI.conditionApplyWithExceptionsCatching;

public class LazyCollectionElementByCondition extends LazyElement {

    private LazyCollection parentCollection;
    private CustomElementConditions condition;

    public LazyCollectionElementByCondition(LazyCollection parentCollection, CustomElementConditions condition) {
        this.parentCollection = parentCollection;
        this.condition = condition;
    }

    public String toString() {
        return parentCollection.toString() + " find(" + condition + ")";
    }

    public WebElement getWrappedEntity() {
        int i;
        List<WebElement> elements = parentCollection.getWrappedEntity();
        for (i = 0; i < elements.size(); ++i) {
            if (conditionApplyWithExceptionsCatching(new LazyWrappedWebElement(parentCollection, elements.get(i)), condition)!= null) {
                return elements.get(i);
            }
        }
        return elements.get(i);
    }
}
