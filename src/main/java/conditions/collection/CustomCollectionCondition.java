package conditions.collection;

import conditions.CustomCondition;
import org.openqa.selenium.WebElement;

import java.util.List;

public abstract class CustomCollectionCondition extends CustomCondition<List<WebElement>> {

    public static CustomCollectionCondition textsOf(final String... texts) {
        return new TextsOf(texts);
    }

    public static CustomCollectionCondition sizeOf(final int expectedSize) {
        return new SizeOf(expectedSize);
    }

    public static CustomCollectionCondition minimumSizeOf(final int minimumSize) {
        return new MinimumSizeOf(minimumSize);
    }

    public static CustomCollectionCondition listVisible = new ListVisible();

    public static CustomCollectionCondition listNthElementHasText(
            final int index, final String text) {
        return new ListNthElementHasText(index, text);
    }

    public static CustomCollectionCondition presenceList = new PresenceList();

    public static CustomCollectionCondition listOfVisibleElementsIsEmpty = new ListOfVisibleElementsIsEmpty();

    public static CustomCollectionCondition visibleTextsOf(final String... texts) {
        return new VisibleTextsOf(texts);
    }

    public static CustomCollectionCondition empty = new SizeOf(0);
}
