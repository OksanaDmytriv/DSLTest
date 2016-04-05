package core;

import core.conditions.CustomCondition;
import core.conditions.collection.CustomCollectionCondition;
import core.wrappers.LazyEntity;
import core.wrappers.forCollection.LazyCollection;
import core.wrappers.forCollection.LazyCollectionByLocator;
import core.wrappers.forElement.LazyElement;
import core.wrappers.forElement.LazyElementByLocator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
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
        return new LazyElementByLocator(locator);
    }

    public static LazyElement $(String cssSelector) {
        return $(byCSS(cssSelector));
    }

    public static LazyCollection $$(By locator) {
        return new LazyCollectionByLocator(locator);
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
        V results = waitForWithoutException(lazyEntity, condition, timeoutMs);
        if (results == null) {
            throw new TimeoutException(condition, timeoutMs);
        }
        return results;
    }

    private static String getExceptionText(LazyEntity lazyEntity, CustomCondition condition) {
        return "\nFor " + ((condition instanceof CustomCollectionCondition) ? "elements" : "element") +
                " located by " + lazyEntity.toString() + "\n" +
                condition.toString() +
                (condition.actual() == "" ? "" : "\nwhile actual is: " + condition.actual());
    }

    public static <V> V waitForWithoutException(LazyEntity lazyEntity, CustomCondition<V> condition, int timeoutMs) {
        V result = null;
        final long startTime = System.currentTimeMillis();
        do {
            result = conditionApplyWithExceptionsCatching(lazyEntity, condition);
            if (result == null) {
                sleep(pollingIntervalInMillis);
                continue;
            }
            return result;
        }
        while (System.currentTimeMillis() - startTime < timeoutMs);
        return result;
    }

    public static <V> V conditionApplyWithExceptionsCatching(LazyEntity lazyEntity, CustomCondition<V> condition) {
        try {
            return condition.apply(lazyEntity);
        } catch (WebDriverException | IndexOutOfBoundsException e) {
            return null;
        }
    }

    public static void executeJavaScript(String script) {
        if (getDriver() instanceof JavascriptExecutor) {
            ((JavascriptExecutor) getDriver()).executeScript(script);
        }
    }
}