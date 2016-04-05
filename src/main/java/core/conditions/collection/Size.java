package core.conditions.collection;

import org.openqa.selenium.WebElement;
import core.wrappers.LazyEntity;

import java.util.List;

public class Size extends CustomCollectionCondition {

    private int listSize;
    protected final int expectedSize;
    private LazyEntity lazyEntity;

    public Size(int expectedSize) {
        this.expectedSize = expectedSize;
    }

    @Override
    public Integer actual() {
        return listSize;
    }

    @Override
    public List<WebElement> apply(LazyEntity lazyEntity) {
        this.lazyEntity = lazyEntity;
        List<WebElement> results = (List<WebElement>) lazyEntity.getWrappedEntity();
        listSize = results.size();
        return (listSize == expectedSize) ? results : null;
    }

    @Override
    public String identity() {
        return "elements";
    }

    @Override
    public Integer expected() {
        return expectedSize;
    }

    @Override
    public LazyEntity entity() {
        return lazyEntity;
    }
}
