package conditions.element;

import conditions.CustomConditions;
import org.openqa.selenium.WebElement;

public abstract class CustomConditionsElement extends CustomConditions<WebElement> {

    public static CustomConditionsElement exactTextOf(final String text) {
        return new conditions.element.ExactTextOf(text);
    }
}
