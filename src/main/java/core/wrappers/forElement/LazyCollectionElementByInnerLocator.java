package core.wrappers.forElement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LazyCollectionElementByInnerLocator extends LazyElement {

    private By innerLocator;
    private LazyElement parentElement;

    public LazyCollectionElementByInnerLocator(LazyElement parentElement, By innerLocator) {
        this.parentElement=parentElement;
        this.innerLocator=innerLocator;
    }

    public String toString() {
        return parentElement.toString() + " " + innerLocator + "";
    }

    public WebElement getWrappedEntity() {
        //waitFor(this, visible());
        return parentElement.getWrappedEntity().findElement(innerLocator);
    }

}
