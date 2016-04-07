package core.conditions.element;

import core.conditions.AbstractEntityCondition;
import org.openqa.selenium.WebElement;

public abstract class ElementCondition extends AbstractEntityCondition<WebElement> {

    public String identity() {
        return "element";
    }
}