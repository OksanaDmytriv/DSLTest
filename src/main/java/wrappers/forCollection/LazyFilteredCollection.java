package wrappers.forCollection;

import conditions.collection.CustomCollectionCondition;
import conditions.element.CustomElementCondition;
import org.openqa.selenium.WebElement;
import wrappers.forElement.LazyWrappedWebElement;

import java.util.List;

public class LazyFilteredCollection extends LazyCollection {

    private CustomCollectionCondition condition;
    private CustomElementCondition conditionElement;
    private LazyCollection parentCollection;

    public LazyFilteredCollection(LazyCollection parentCollection, CustomCollectionCondition condition) {
        super(null);
        this.parentCollection = parentCollection;
        this.condition = condition;
    }

    public String getLocatorDescription() {
        return parentCollection.filter(condition).getLocatorDescription().concat(".filter(" + condition + ')');
    }

    public List<WebElement> getWrappedEntity() {
        List<WebElement> newList = null;
        List<WebElement> elements = parentCollection.getWrappedEntity();
        for (int i=0; i<elements.size(); ++i){
            if(condition.apply(new LazyWrappedWebElement(parentCollection, elements.get(i))) != null)
                newList.add(i, elements.get(i));
            }

        return newList;
    }


}
