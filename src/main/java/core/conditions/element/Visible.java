package core.conditions.element;

import org.openqa.selenium.WebElement;

public class Visible extends ElementCondition {

    private boolean currentState;

    @Override
    public WebElement check(WebElement element) {
        currentState = element.isDisplayed();
        return element.isDisplayed() ? element : null;
    }

    @Override
    public String actual() {
        return String.valueOf(currentState);
    }

    @Override
    public String expected() {
        return "Visible";
    }
}
