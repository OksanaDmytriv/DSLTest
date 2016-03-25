package conditions.collection;

import collection.LazyEntity;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ExactTextOf extends CustomConditionsCollection {

    private static List<String> currentTexts;
    private static String currentText;
    protected final String text;
    private LazyEntity lazyEntity;

    public ExactTextOf(String text) {
        this.text = text;
    }

    public String toString() {
        return String.format("\nFor elements located by %s\n actual texts are: %s\n while expected text contains: %s\n", lazyEntity.getLocatorDescription(), currentTexts, text);
    }

    protected WebElement check(LazyEntity lazyEntity) {
        int i;
        this.lazyEntity = lazyEntity;
        List<WebElement> elements = (List<WebElement>) lazyEntity.getWrappedEntity();
        currentTexts = new ArrayList<String>();
        for (i = 0; i < elements.size(); ++i) {
            currentTexts.add(i, elements.get(i).getText());
        }
        for (i = 0; i < elements.size(); ++i) {
            currentText = elements.get(i).getText();
            if (!currentText.equals(text)) {
                return null;
            }
        }
        return elements.get(i);
    }
}
