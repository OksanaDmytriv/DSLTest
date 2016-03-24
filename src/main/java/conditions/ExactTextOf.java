package conditions;

import collection.LazyEntity;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ExactTextOf extends CustomConditions<WebElement> {

    private static String currentText;
    private static List<WebElement> elements;
    protected final String text;
    private LazyEntity lazyEntity;

    public ExactTextOf(String text) {
        this.text = text;
    }

    public String toString() {
        return String.format("\nFor elements located by %s\n actual text is: %s\n while expected text contains: %s\n", lazyEntity.getLocatorDescription(), currentText, text);
    }

    protected WebElement check(LazyEntity lazyEntity) {
        int i;
        this.lazyEntity = lazyEntity;
        elements = (List<WebElement>) lazyEntity.getWrappedEntity();
        //elements = ConciseAPI.getDriver().findElements(locator);
        for (i = 0; i < elements.size(); ++i) {
            currentText = elements.get(i).getText();
            if (!currentText.contains(text)) {
                return null;
            }
        }
        return elements.get(i);
    }
}
