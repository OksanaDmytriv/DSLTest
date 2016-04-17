package core.exceptions;


import org.openqa.selenium.WebDriverException;

public class ElementNotFoundException extends WebDriverException {

    private String text;

    public ElementNotFoundException(String text) {
        this.text = text;
    }
}
