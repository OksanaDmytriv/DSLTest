package core.conditions.collection;

import core.conditions.CustomCondition;
import org.openqa.selenium.WebElement;

import java.util.List;

public abstract class CustomCollectionCondition extends CustomCondition<List<WebElement>> {

    public String identity() {
        return "elements";
    }
}
