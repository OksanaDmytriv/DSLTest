package conditions;

import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class Helpers {

    public static List<String> getTexts(List<WebElement> elements) {
        List<String> currentTexts = new ArrayList<String>();
        for (int i = 0; i < elements.size(); ++i) {
            currentTexts.add(i, elements.get(i).getText());
        }
        return currentTexts;
    }

    public static List<WebElement> listHasTexts(final List<WebElement> elements, final String...
            expectedTexts) {
        List<String> currentTexts = getTexts(elements);
        if (currentTexts.size() != expectedTexts.length) {
            return null;
        } else {
            for (int i = 0; i < expectedTexts.length; ++i) {
                if (!currentTexts.get(i).contains(expectedTexts[i])) {
                    return null;
                }
            }
            return elements;
        }
    }

    public static List<WebElement> listOfVisibleElements(List<WebElement> elements) {
        List<WebElement> visibleElements = new ArrayList<WebElement>();
        for (WebElement element : elements) {
            if (element.isDisplayed()) {
                visibleElements.add(element);
            }
        }
        return visibleElements;
    }
}
