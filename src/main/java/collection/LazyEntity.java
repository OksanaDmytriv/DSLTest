package collection;

import conditions.CustomConditions;
import core.Configuration;
import org.openqa.selenium.interactions.Actions;

import static core.ConciseAPI.getDriver;
import static core.Configuration.pollingIntervalInMillis;

public abstract class LazyEntity<TypeOfWrappedEntity> {

    public LazyEntity lazyEntity;

    public LazyEntity(LazyEntity lazyEntity) {
        this.lazyEntity = lazyEntity;
    }

    protected <V> V assertThat(CustomConditions<V> condition, int timeout) {
        return waitUntil(condition, timeout);
    }

    protected <V> V assertThat(CustomConditions<V> condition) {
        return assertThat(condition, Configuration.timeout);
    }

    protected <V> V assertThat(CustomConditions<V>... conditions) {
        V result = null;
        for (CustomConditions<V> condition : conditions) {
            result = assertThat(condition);
        }
        return result;
    }

    public abstract <TypeOfWrappedEntity> TypeOfWrappedEntity getWrappedEntity();

    public abstract String getLocatorDescription();

    public Actions getActions() {
        return new Actions(getDriver());
    }

    private void sleep(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }

    private <V> V waitUntil(CustomConditions<V> condition, int timeoutMs) {
        final long startTime = System.currentTimeMillis();
        do {
            V results = condition.apply(lazyEntity);
            if (results == null) {
                sleep(pollingIntervalInMillis);
                continue;
            }
            return results;
        }
        while (System.currentTimeMillis() - startTime < timeoutMs);
        condition.fail();
        return null;
    }
}
