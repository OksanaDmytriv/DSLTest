package core.conditions.element;

import org.openqa.selenium.WebElement;

public class Present extends ElementCondition {

    private boolean currentState;

    public WebElement check(WebElement element) {
        currentState = (element!=null);
        return element;
    }

    public String actual() {
        return String.valueOf(currentState);
    }

    @Override
    public String expected() {
        return "Present";
    }
}
