package core.exceptions;


import org.openqa.selenium.WebDriverException;

public class WebDriverAssertionException extends WebDriverException {

    private String text;

    public WebDriverAssertionException(String text) {
        this.text = text;
    }
}
