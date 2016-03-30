package wrappers.forElement;

import conditions.element.CustomElementCondition;
import org.openqa.selenium.WebElement;
import wrappers.forCollection.LazyCollection;

import java.util.List;

import static core.ConciseAPI.conditionApplyWithExceptionsCatching;

public class LazyCollectionElementByCondition extends LazyElement {

    private LazyCollection parentCollection;
    private CustomElementCondition condition;

    public LazyCollectionElementByCondition(LazyCollection parentCollection, CustomElementCondition condition) {
        super(null);
        this.parentCollection = parentCollection;
        this.condition = condition;
    }

    public String toString() {
        return parentCollection.toString() + " filter(" + condition.toString() + ").get(0)";
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
