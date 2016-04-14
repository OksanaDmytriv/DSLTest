package core.conditions.element;

import core.conditions.ElementCondition;
import org.openqa.selenium.WebElement;

public class Present extends ElementCondition {

    private boolean currentState;

    public WebElement check(WebElement element) {
        currentState = (element != null);
        return element;
    }

    public String actual() {
        return currentState ? "Present" : "Not present";
    }

    @Override
    public String expected() {
        return "Present";
    }
}
