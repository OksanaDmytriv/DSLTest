package core.conditions.element;


import core.wrappers.LazyEntity;
import org.openqa.selenium.WebElement;

public class CSSClass1 extends CustomElementCondition {

    private LazyEntity lazyEntity;
    private String cssClass;
    private WebElement element;
    private String[] currentClasses;

    public CSSClass1(String cssClass) {
        this.cssClass = cssClass;
    }

    @Override
    public String actual() {
        return currentClasses.toString();
    }

    @Override
    public WebElement apply(LazyEntity lazyEntity) {
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
    public String identity() {
        return "element";
    }

    @Override
    public String expected() {
        return cssClass;
    }

    @Override
    public LazyEntity entity() {
        return lazyEntity;
    }
}
