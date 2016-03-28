package conditions.collection;

import org.openqa.selenium.WebElement;
import wrappers.LazyEntity;

import java.util.List;

public class MinimumSizeOf extends CustomCollectionCondition {

    private int listSize;
    protected final int minimumSize;
    private LazyEntity lazyEntity;

    public MinimumSizeOf(int minimumSize) {
        if (minimumSize == 0) {
            throw new IllegalArgumentException("Minimum size of forElement's list is 0.");
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
        List<WebElement> results = (List<WebElement>) lazyEntity.getWrappedEntity();
        listSize = results.size();
        return (listSize >= minimumSize) ? results : null;
    }
}
