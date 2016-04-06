package core.conditions.element;


import org.openqa.selenium.WebElement;

public class CSSClass extends ElementCondition {

    private String cssClass;
    private WebElement element;
    private String[] currentClasses;

    public CSSClass(String cssClass) {
        this.cssClass = cssClass;
    }

    @Override
    protected WebElement check() {
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
