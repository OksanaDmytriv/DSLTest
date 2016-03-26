package conditions.collection;

import conditions.CustomConditions;
import org.openqa.selenium.WebElement;

import java.util.List;

public abstract class CustomCollectionConditions extends CustomConditions<List<WebElement>> {

    public static CustomCollectionConditions textsOf(final String... texts) {
        return new TextsOf(texts);
    }

    public static CustomCollectionConditions sizeOf(final int expectedSize) {
        return new SizeOf(expectedSize);
    }

    public static CustomCollectionConditions minimumSizeOf(final int minimumSize) {
        return new MinimumSizeOf(minimumSize);
    }

    public static CustomCollectionConditions listVisible = new ListVisible();

    public static CustomCollectionConditions listNthElementHasText(
            final int index, final String text) {
        return new ListNthElementHasText(index, text);
    }

    public static CustomCollectionConditions presenceList = new PresenceList();

    public static CustomCollectionConditions listOfVisibleElementsIsEmpty = new ListOfVisibleElementsIsEmpty();

    public static CustomCollectionConditions visibleTextsOf(final String... texts) {
        return new VisibleTextsOf(texts);
    }

    public static CustomCollectionConditions empty = new SizeOf(0);
}
