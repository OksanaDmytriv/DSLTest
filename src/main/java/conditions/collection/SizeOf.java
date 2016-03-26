package conditions.collection;

import org.openqa.selenium.WebElement;
import wrappers.LazyEntity;

import java.util.List;

public class SizeOf extends CustomCollectionConditions {

    private int listSize;
    protected final int expectedSize;
    private LazyEntity lazyEntity;

    public SizeOf(int expectedSize) {
        this.expectedSize = expectedSize;
    }

    @Override
    public String toString() {
        return String.format("\n For elements located by %s\n actual size is: %s\n while expected size contains: %s\n", lazyEntity.getLocatorDescription(), listSize, expectedSize);
    }

    @Override
    protected List<WebElement> check(LazyEntity lazyEntity) {
        this.lazyEntity = lazyEntity;
        List<WebElement> results = (List<WebElement>) lazyEntity.getWrappedEntity();
        listSize = results.size();
        return (listSize == expectedSize) ? results : null;
    }
}
