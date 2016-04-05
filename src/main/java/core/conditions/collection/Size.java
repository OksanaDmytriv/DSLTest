package core.conditions.collection;

import org.openqa.selenium.WebElement;
import core.wrappers.LazyEntity;

import java.util.List;

public class Size extends CustomCollectionCondition {

    private int listSize;
    protected final int expectedSize;

    public Size(int expectedSize) {
        this.expectedSize = expectedSize;
    }

    @Override
    public List<WebElement> apply(LazyEntity lazyEntity) {
        this.lazyEntity = lazyEntity;
        List<WebElement> results = (List<WebElement>) lazyEntity.getWrappedEntity();
        listSize = results.size();
        return (listSize == expectedSize) ? results : null;
    }

    @Override
    public String actual() {
        return Integer.toString(listSize);
    }

    @Override
    public String expected() {
        return Integer.toString(expectedSize);
    }

    @Override
    public LazyEntity entity() {
        return lazyEntity;
    }
}
