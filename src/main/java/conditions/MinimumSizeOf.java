package conditions;

import collection.LazyEntity;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MinimumSizeOf extends CustomConditions<List<WebElement>> {

    private static int listSize;
    private static List<WebElement> results;
    protected final int minimumSize;
    private LazyEntity lazyEntity;

    public MinimumSizeOf(int minimumSize) {
        if (minimumSize == 0) {
            throw new IllegalArgumentException("Minimum size of element's list is 0.");
        }
        this.minimumSize = minimumSize;
    }

    @Override
    public String toString() {
        return String.format("\n For elements located by %s\n actual size is: %s\n while expected minimum size contains: %s\n", lazyEntity.getLocatorDescription(), listSize, minimumSize);
    }

    @Override
    protected List<WebElement> check(LazyEntity lazyEntity) {
        this.lazyEntity = lazyEntity;
        results = (List<WebElement>) lazyEntity.getWrappedEntity();
        //results = ConciseAPI.getDriver().findElements(locator);
        listSize = results.size();
        return (listSize >= minimumSize) ? results : null;
    }
}
