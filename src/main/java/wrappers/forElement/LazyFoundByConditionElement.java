package wrappers.forElement;


import conditions.element.CustomElementCondition;
import org.openqa.selenium.WebElement;
import wrappers.forCollection.LazyCollection;

import java.util.List;


public class LazyFoundByConditionElement extends LazyElement {

    private LazyCollection parentCollection;
    private CustomElementCondition condition;

    public LazyFoundByConditionElement(LazyCollection parentCollection, CustomElementCondition condition) {
        super(null);
        this.parentCollection = parentCollection;
        this.condition = condition;
    }

    public String getLocatorDescription() {
        return parentCollection.getLocatorDescription().concat(".filter(" + condition + ").get(0)");
    }

    public WebElement getWrappedEntity() {
        int i;
        List<WebElement> elements = parentCollection.getWrappedEntity();
        for (i = 0; i < elements.size(); ++i) {
            if (new LazyWrappedWebElement(parentCollection, elements.get(i)).isValid(condition)) {
                return elements.get(i);
            }
        }
        return elements.get(i);
    }

}
