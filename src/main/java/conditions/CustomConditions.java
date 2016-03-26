package conditions;


import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import wrappers.LazyEntity;

import java.util.ArrayList;
import java.util.List;

public abstract class CustomConditions<V> {

    public void fail() {
        throw new AssertionError(toString());
    }

    public abstract String toString();

    protected abstract <V> V check(LazyEntity lazyEntity);

    public <V> V apply(LazyEntity lazyEntity) {
        try {
            return check(lazyEntity);
        } catch (StaleElementReferenceException e) {
            return null;
        } catch (ElementNotVisibleException e) {
            return null;
        } catch (IndexOutOfBoundsException e) {
            return null;
        } catch (NoSuchElementException e) {
            return null;
        }
    }

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
