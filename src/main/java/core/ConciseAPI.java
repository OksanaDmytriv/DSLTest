package core;

import conditions.CustomCondition;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import wrappers.LazyEntity;
import wrappers.forCollection.LazyCollection;
import wrappers.forElement.LazyElement;

import java.util.HashMap;
import java.util.Map;

import static core.Configuration.pollingIntervalInMillis;
import static javafx.scene.input.KeyCode.V;

public class ConciseAPI {

    private static Map<Thread, WebDriver> drivers = new HashMap<Thread, WebDriver>();

    public static WebDriver getDriver() {
        return drivers.get(Thread.currentThread());
    }

    public static void setDriver(WebDriver driver) {
        drivers.put(Thread.currentThread(), driver);
    }

    public static LazyElement $(By locator) {
        return new LazyElement(locator);
    }

    public static LazyElement $(String cssSelector) {
        return $(byCSS(cssSelector));
    }

    public static LazyCollection $$(By locator) {
        return new LazyCollection(locator);
    }

    public static LazyCollection $$(String cssSelector) {
        return $$(byCSS(cssSelector));
    }

    public static By byText(String text) {
        return By.xpath("//*[text()[contains(.,'" + text + "')]]");
    }

    public static By byCSS(String cssSelector) {
        return By.cssSelector(cssSelector);
    }

    public static void open(String URL) {
        getDriver().get(URL);
    }

    public static Actions actions() {
        return new Actions(getDriver());
    }

    public static void sleep(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }

    public static <V> V waitFor(LazyEntity lazyEntity, CustomCondition<V> condition) {
        return waitFor(lazyEntity, condition, Configuration.timeout);
    }

    public static <V> V waitFor(LazyEntity lazyEntity, CustomCondition<V>... conditions) {
        V result = null;
        for (CustomCondition<V> condition : conditions) {
            result = waitFor(lazyEntity, condition);
        }
        return result;
    }

    public static <V> V waitFor(LazyEntity lazyEntity, CustomCondition<V> condition, int timeoutMs) {
        V results = null;
        final long startTime = System.currentTimeMillis();
        do {
            results = condition.apply(lazyEntity);
            if (results == null) {
                sleep(pollingIntervalInMillis);
                continue;
            }
            return results;
        }
        while (System.currentTimeMillis() - startTime < timeoutMs);
        if(results == null){
        conditionFail();
        throw new AssertionError(toString());}
        return null;
    }

    public static <V> void conditionFail(){
    }

    public static <V> V apply(LazyEntity lazyEntity) {
        try {
            return CustomCondition.apply(lazyEntity);
        } catch (WebDriverException e) {
            return null;
        }  catch (IndexOutOfBoundsException e) {
            return null;
        }
    }
}