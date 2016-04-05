package core.conditions.collection;

import org.openqa.selenium.WebElement;
import core.wrappers.LazyEntity;

import java.util.List;

public class MinimumSize extends CustomCollectionCondition {

    private int listSize;
    protected final int minimumSize;

    public MinimumSize(int minimumSize) {
        if (minimumSize == 0) {
            throw new IllegalArgumentException("Minimum size of for element's list is 0.");
        }
        this.minimumSize = minimumSize;
    }

    @Override
    public List<WebElement> apply(LazyEntity lazyEntity) {
        this.lazyEntity = lazyEntity;
        List<WebElement> results = (List<WebElement>) lazyEntity.getWrappedEntity();
        listSize = results.size();
        return (listSize >= minimumSize) ? results : null;
    }

    @Override
    public String actual() {
        return Integer.toString(listSize);
    }

    @Override
    public String expected() {
        return Integer.toString(minimumSize);
    }

    @Override
    public LazyEntity entity() {
        return lazyEntity;
    }
}
