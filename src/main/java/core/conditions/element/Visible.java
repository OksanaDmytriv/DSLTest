package core.conditions.element;

import org.openqa.selenium.WebElement;

public class Visible extends ElementCondition {

    private Boolean currentState;

    @Override
    public WebElement check(WebElement element) {
        currentState = element.isDisplayed();
        return currentState ? element : null;
    }

    @Override
    public String actual() {
        return currentState.toString();
    }

    @Override
    public String expected() {
        return "Visible";
    }
}
