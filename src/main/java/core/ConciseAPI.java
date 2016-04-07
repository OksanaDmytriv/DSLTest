package core;

import core.conditions.EntityCondition;
import core.wrappers.LazyEntity;
import core.wrappers.forCollection.LazyCollection;
import core.wrappers.forElement.LazyElement;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.HashMap;
import java.util.Map;

import static core.Configuration.pollingIntervalInMillis;

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

    public static <T> T waitFor(LazyEntity lazyEntity, EntityCondition<T>... conditions) {
        T result = null;
        for (EntityCondition<T> condition : conditions) {
            result = waitFor(lazyEntity, condition, Configuration.timeout);
        }
        return result;
    }

    public static <T> T waitFor(LazyEntity lazyEntity, EntityCondition<T> condition, int timeoutMs) {
        T result;
        final long startTime = System.currentTimeMillis();
        do {
            result = condition.apply(lazyEntity);
            if (result == null) {
                sleep(pollingIntervalInMillis);
                continue;
            }
            return result;
        }
        while (System.currentTimeMillis() - startTime < timeoutMs);
        if (result == null) {
            throw new TimeoutException("\nfailed while waiting " + timeoutMs / 1000 + " seconds \nto assert " + condition);
        }
        return result;
    }

    public static void executeJavaScript(String script) {
        if (getDriver() instanceof JavascriptExecutor) {
            ((JavascriptExecutor) getDriver()).executeScript(script);
        }
    }
}