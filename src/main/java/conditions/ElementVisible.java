package conditions;

import core.ConciseAPI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ElementVisible extends CustomConditions<WebElement> {

    private static By locator;

    @Override
    public String toString() {
        return String.format("Element located by %s\n should be visible", locator);
    }

    @Override
    protected WebElement check(By locator) {
        WebElement element = ConciseAPI.getDriver().findElement(locator);
        return element.isDisplayed() ? element : null;
    }
}
