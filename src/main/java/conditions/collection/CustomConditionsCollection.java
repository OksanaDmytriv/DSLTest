package conditions.collection;

import conditions.CustomConditions;
import org.openqa.selenium.WebElement;

import java.util.List;

public abstract class CustomConditionsCollection extends CustomConditions<List<WebElement>> {

    public static CustomConditionsCollection textsOf(final String... texts) {
        return new TextsOf(texts);
    }

    public static CustomConditionsCollection sizeOf(final int expectedSize) {
        return new SizeOf(expectedSize);
    }

    public static CustomConditionsCollection minimumSizeOf(final int minimumSize) {
        return new MinimumSizeOf(minimumSize);
    }

    public static CustomConditionsCollection listVisible = new ListVisible();

    public static CustomConditionsCollection listNthElementHasText(
            final int index, final String text) {
        return new ListNthElementHasText(index, text);
    }

    public static CustomConditionsCollection elementVisible = new ElementVisible();
}
