package conditions.collection;


import org.openqa.selenium.WebElement;
import wrappers.LazyEntity;

import java.util.List;

public class ListOfVisibleElementsIsEmpty extends CustomCollectionCondition {

    private LazyEntity lazyEntity;

    @Override
    public String toString() {
        return String.format("\n For visible elements located by %s\n list should be empty", lazyEntity.getLocatorDescription());
    }
    @Override
    public List<WebElement> apply(LazyEntity lazyEntity) {
        this.lazyEntity = lazyEntity;
        List<WebElement> elements = (List<WebElement>) lazyEntity.getWrappedEntity();
        List<WebElement> visibleElements = listOfVisibleElements(elements);
        int listSize = visibleElements.size();
        return (listSize == 0) ? visibleElements : null;
    }
}
