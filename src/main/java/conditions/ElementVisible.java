package conditions;

import collection.LazyEntity;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ElementVisible extends CustomConditions<WebElement> {

    private static By locator;
    private static WebElement element;
    private LazyEntity lazyEntity;

    @Override
    public String toString() {
        return String.format("Element located by %s\n should be visible", locator);
    }

    @Override
    protected WebElement check(LazyEntity lazyEntity) {
        this.lazyEntity = lazyEntity;
        element = (WebElement) lazyEntity.getWrappedEntity();
        //WebElement element = ConciseAPI.getDriver().findElement(lazyEntity);
        return element.isDisplayed() ? element : null;
    }
}
