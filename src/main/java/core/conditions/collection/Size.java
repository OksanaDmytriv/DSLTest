package core.conditions.collection;

import org.openqa.selenium.WebElement;

import java.util.List;

public class Size extends CollectionCondition {

    private int listSize;
    private final int expectedSize;

    public Size(int expectedSize) {
        this.expectedSize = expectedSize;
    }

    @Override
    public List<WebElement> check(List<WebElement> elements) {
        listSize = elements.size();
        return (listSize == expectedSize) ? elements : null;
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
