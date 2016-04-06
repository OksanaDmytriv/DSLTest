package core.conditions.collection;

import org.openqa.selenium.WebElement;

import java.util.List;

public class Size extends CollectionCondition {

    private int listSize;
    protected final int expectedSize;

    public Size(int expectedSize) {
        this.expectedSize = expectedSize;
    }

    @Override
    protected List<WebElement> check() {
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
}
