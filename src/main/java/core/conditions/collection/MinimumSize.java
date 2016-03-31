package core.conditions.collection;

import org.openqa.selenium.WebElement;
import core.wrappers.LazyEntity;

import java.util.List;

public class MinimumSize extends CustomCollectionConditions {

    private int listSize;
    protected final int minimumSize;
    private LazyEntity lazyEntity;

    public MinimumSize(int minimumSize) {
        if (minimumSize == 0) {
            throw new IllegalArgumentException("Minimum size of for element's list is 0.");
        }
        this.minimumSize = minimumSize;
    }

    @Override
    public String toString() {
        return String.format("minimum size contains: %s", minimumSize);
    }

    @Override
    public Integer getActualValuesDescription() {
        return listSize;
    }

    @Override
    public List<WebElement> apply(LazyEntity lazyEntity) {
        this.lazyEntity = lazyEntity;
        List<WebElement> results = (List<WebElement>) lazyEntity.getWrappedEntity();
        listSize = results.size();
        return (listSize >= minimumSize) ? results : null;
    }
}
