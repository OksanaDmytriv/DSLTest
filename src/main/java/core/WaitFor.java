package core;

import core.conditions.Condition;
import core.wrappers.LazyEntity;
import org.openqa.selenium.TimeoutException;

import static core.Configuration.pollingInterval;

public class WaitFor {

    public static <T> T until(LazyEntity lazyEntity, Condition<T>... conditions) {
        T result = null;
        for (Condition<T> condition : conditions) {
            result = until(lazyEntity, condition, Configuration.timeout);
        }
        return result;
    }

    public static <T> T until(LazyEntity lazyEntity, Condition<T> condition, int timeoutMs) {
        T result;
        final long startTime = System.currentTimeMillis();
        do {
            result = condition.apply(lazyEntity);
            if (result == null) {
                sleep(pollingInterval);
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

    private static void sleep(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }
}
