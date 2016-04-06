package core.conditions.element;


import core.wrappers.LazyEntity;
import org.openqa.selenium.WebElement;

public class CSSClass extends CustomElementCondition {

    private LazyEntity lazyEntity;
    private String cssClass;
    private WebElement element;
    private String[] currentClasses;

    public CSSClass(String cssClass) {
        this.cssClass = cssClass;
    }

    @Override
    protected WebElement check(LazyEntity lazyEntity) {
        this.lazyEntity = lazyEntity;
        element = (WebElement) lazyEntity.getWrappedEntity();
        currentClasses = element.getAttribute("class").split(" ");
        for (int i = 0; i < currentClasses.length; i++) {
            if (currentClasses[i].equals(cssClass)) {
                return element;
            }
        }
        return null;
    }

    @Override
    public String actual() {
        return currentClasses.toString();
    }

    @Override
    public String expected() {
        return cssClass;
    }
}
