package core;

import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class Helpers {

    public static String getUniqueText(String prefix) {
        return (prefix + " " + System.currentTimeMillis());
    }

    public static List<String> getTexts(List<WebElement> elements) {
        List<String> currentTexts = new ArrayList<String>();
        for (int i = 0; i < elements.size(); ++i) {
            currentTexts.add(i, elements.get(i).getText());
        }
        return currentTexts;
    }

    public static Boolean listHasTexts(final List<String> currentTexts, final String...
            expectedTexts) {
        if (currentTexts.size() != expectedTexts.length) {
            return null;
        } else {
            for (int i = 0; i < expectedTexts.length; ++i) {
                if (!currentTexts.get(i).contains(expectedTexts[i])) {
                    return false;
                }
            }
        }
        return true;
    }

    public static Boolean listHasExactTexts(List<String> currentTexts, final String...
            expectedTexts) {
        if (currentTexts.size() != expectedTexts.length) {
            return null;
        } else {
            for (int i = 0; i < expectedTexts.length; ++i) {
                if (!currentTexts.get(i).equals(expectedTexts[i])) {
                    return false;
                }
            }
        }
        return true;
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
