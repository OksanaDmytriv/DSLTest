package core.wrappers.forElement;

import core.conditions.element.ElementCondition;
import core.wrappers.forCollection.AbstractLazyCollection;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LazyCollectionFoundByConditionElement extends AbstractLazyElement {

    private AbstractLazyCollection parentCollection;
    private ElementCondition condition;

    public LazyCollectionFoundByConditionElement(AbstractLazyCollection parentCollection, ElementCondition condition) {
        this.parentCollection = parentCollection;
        this.condition = condition;
    }

    public String toString() {
        return parentCollection.toString() + " find(" + condition.getClass() + ")";
    }

    public WebElement getWrappedEntity() {
        List<WebElement> elements = parentCollection.getWrappedEntity();
        for (WebElement element : elements) {
            if (new LazyWrappedWebElement(this, element).is(condition)) {
                return element;
            }
        }
        return null;
    }
}
