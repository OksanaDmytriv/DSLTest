package conditions.element;


import org.openqa.selenium.WebElement;
import wrappers.LazyEntity;

public class ListElementWithCssClass extends CustomElementCondition {

    private LazyEntity lazyEntity;
    private String cssClass;

    public ListElementWithCssClass(String cssClass) {
        this.cssClass = cssClass;
    }

    @Override
    public String toString() {
        return String.format("should be cssClass", cssClass);
    }

    @Override
    public WebElement apply(LazyEntity lazyEntity) {
        this.lazyEntity = lazyEntity;
        WebElement element = (WebElement) lazyEntity.getWrappedEntity();
        String[] classes = element.getAttribute("class").split(" ");
        for (int i = 0; i < classes.length; i++) {
            if (classes[i].equals(cssClass)) {
                return element;
            }
        }
        return null;
    }

    @Override
    public String getActualValuesDescription() {
        return "";
    }
}
