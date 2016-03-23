package conditions;

import core.ConciseAPI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ExactTextOf extends CustomConditions<WebElement> {

    private static String currentText;
    private static List<WebElement> elements;
    protected final String text;

    public ExactTextOf(String text) {
        this.text = text;
    }

    public String toString() {
        return String.format("\nFor elements %s\n actual text is: %s\n while expected text contains: %s\n", elements, currentText, text);
    }

    protected WebElement check(By locator) {
        int i;
        elements = ConciseAPI.getDriver().findElements(locator);
        for (i = 0; i < elements.size(); ++i) {
            currentText = elements.get(i).getText();
            if (!currentText.contains(text)) {
                return null;
            }
        }
        return elements.get(i);
    }
}
