package wrappers.forCollection;

import conditions.collection.CustomCollectionConditions;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LazyFilteringElements extends LazyCollection {

    CustomCollectionConditions condition;
    private LazyCollection parentCollection;

    public LazyFilteringElements(LazyCollection parentCollection, CustomCollectionConditions condition) {
        super(null);
        this.parentCollection = parentCollection;
        this.condition = condition;
    }

    public String getLocatorDescription() {
        return parentCollection.filter(condition).getLocatorDescription().concat(".filter(" + condition + ')');
    }

    public List<WebElement> getWrappedEntity() {
        return parentCollection.getWrappedEntity();
    }


}
