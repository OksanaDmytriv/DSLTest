package wrappers.forCollection;


import conditions.collection.CustomCollectionConditions;
import org.openqa.selenium.WebElement;

import java.util.List;


public class LazyFoundElements extends LazyCollection {

    CustomCollectionConditions condition;
    private LazyCollection parentCollection;

    public LazyFoundElements(LazyCollection parentCollection) {
        super(null);
        this.parentCollection = parentCollection;
    }

    public String getLocatorDescription() {
        return parentCollection.filter(condition).getLocatorDescription().concat(".filter(" + condition + ").get(0)");
    }

    public WebElement getWrappedEntity() {
        //тут нехорошо
        return parentCollection.getWrappedEntity();
    }

}
