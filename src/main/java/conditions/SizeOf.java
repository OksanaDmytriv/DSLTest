package conditions;

import collection.LazyEntity;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SizeOf extends CustomConditions<List<WebElement>> {

    private static int listSize;
    private static List<WebElement> results;
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
        this.lazyEntity=lazyEntity;
        results = (List<WebElement>) lazyEntity.getWrappedEntity();
        //results = ConciseAPI.getDriver().findElements(locator);
        listSize = results.size();
        return (listSize == expectedSize) ? results : null;
    }
}
