package core.exceptions;

import org.openqa.selenium.WebDriverException;

public class LazyСollectionIndexOutOfBoundsException extends WebDriverException {

    private String text;

    public LazyСollectionIndexOutOfBoundsException(String text) {
        this.text = text;
    }
}
