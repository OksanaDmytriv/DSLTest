package collection;

import org.openqa.selenium.WebElement;

import static core.ConciseAPI.byCSS;

public class LazyFoundElement extends LazyElement {

    private String innerLocator;
    private LazyElement parentElement;

    public LazyFoundElement(LazyElement parentElement, String innerLocator) {
        super(null);
        this.parentElement=parentElement;
        this.innerLocator=innerLocator;
    }

    public String getLocatorDescription() {
        return parentElement.getLocatorDescription().concat(" "+innerLocator+"");
    }

    public WebElement getWrappedEntity() {
        return parentElement.getWrappedEntity().findElement(byCSS(innerLocator));
    }

}
