package core.conditions.element;

import org.openqa.selenium.WebElement;

public class Present extends ElementCondition {

    private Boolean currentState;

    protected WebElement check(WebElement element) {
        currentState = (element!=null);
        return element;
    }

    public String actual() {
        return currentState.toString();
    }

    @Override
    public String expected() {
        return "Present";
    }
}
