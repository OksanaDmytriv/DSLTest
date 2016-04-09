package core.conditions.collection;

import org.openqa.selenium.WebElement;

import java.util.List;

public class MinimumSize extends CollectionCondition {

    private int listSize;
    private final int minimumSize;

    public MinimumSize(int minimumSize) {
        if (minimumSize == 0) {
            throw new IllegalArgumentException("Minimum size of for element's list is 0.");
        }
        this.minimumSize = minimumSize;
    }

    @Override
    public List<WebElement> check(List<WebElement> elements) {
        listSize = elements.size();
        return (listSize >= minimumSize) ? elements : null;
    }

    @Override
    public String actual() {
        return Integer.toString(listSize);
    }

    @Override
    public String expected() {
        return Integer.toString(minimumSize);
    }
}
