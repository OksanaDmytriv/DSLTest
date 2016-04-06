package core.conditions.collection;

import org.openqa.selenium.WebElement;

import java.util.List;

public class ListNthElementHasText extends CollectionCondition {

    private String currentText;
    protected final String text;
    protected final int index;

    public ListNthElementHasText(int index, String text) {
        this.index = index;
        this.text = text;
    }

    @Override
    protected WebElement check() {
        List<WebElement> elements = (List<WebElement>) lazyEntity.getWrappedEntity();
        WebElement element = elements.get(index);
        currentText = element.getText();
        return (currentText.contains(text)) ? element : null;
    }

    @Override
    public String actual() {
        return currentText;
    }

    @Override
    public String expected() {
        return text;
    }
}
