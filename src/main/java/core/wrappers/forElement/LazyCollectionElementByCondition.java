package core.wrappers.forElement;

import core.conditions.element.CustomElementCondition;
import core.wrappers.forCollection.LazyCollection;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LazyCollectionElementByCondition extends LazyElement {

    private LazyCollection parentCollection;
    private CustomElementCondition condition;

    public LazyCollectionElementByCondition(LazyCollection parentCollection, CustomElementCondition condition) {
        this.parentCollection = parentCollection;
        this.condition = condition;
    }

    public String toString() {
        return parentCollection.toString() + " find(" + condition + ")";
    }

    public WebElement getWrappedEntity() {
        List<WebElement> elements = parentCollection.getWrappedEntity();
        for (WebElement element:elements) {
            if (condition.apply(new LazyWrappedWebElement(this, element))!= null) {
                return element;
            }
        }
        return null;
    }
}
