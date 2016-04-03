package core.conditions.element;


import org.openqa.selenium.WebElement;
import core.wrappers.LazyEntity;

public class CSSClass extends CustomElementCondition {

    private LazyEntity lazyEntity;
    private String cssClass;
    private WebElement element;

    public CSSClass(String cssClass) {
        this.cssClass = cssClass;
    }

    @Override
    public String toString() {
        return String.format("should be element with CSSClass", cssClass);
    }

    @Override
    public String getActualValuesDescription() {
        return element.getAttribute("class");
    }

    @Override
    public WebElement apply(LazyEntity lazyEntity) {
        this.lazyEntity = lazyEntity;
        element = (WebElement) lazyEntity.getWrappedEntity();
        String[] classes = element.getAttribute("class").split(" ");
        for (int i = 0; i < classes.length; i++) {
            if (classes[i].equals(cssClass)) {
                return element;
            }
        }
        return null;
    }
}
