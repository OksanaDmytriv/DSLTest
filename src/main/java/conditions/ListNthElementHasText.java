package conditions;

import core.ConciseAPI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ListNthElementHasText extends CustomConditions<WebElement> {

    private static String currentText;
    private static List<WebElement> elements;
    protected final String text;
    protected final int index;

    public ListNthElementHasText(int index, String text) {
        this.index = index;
        this.text = text;
    }

    @Override
    public String toString() {
        return String.format("\nFor element actual text is: %s\n while expected text contains: %s\n", currentText, text);
    }

    @Override
    protected WebElement check(By locator) {
        elements = ConciseAPI.getDriver().findElements(locator);
        WebElement element = elements.get(index);
        currentText = element.getText();
        return (currentText.contains(text)) ? element : null;
    }
}
