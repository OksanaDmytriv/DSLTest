package core;

import core.conditions.CustomCondition;
import core.wrappers.LazyEntity;

public class TimeoutException extends RuntimeException {
    private LazyEntity lazyEntity;
    private CustomCondition condition;

    public TimeoutException(LazyEntity lazyEntity, CustomCondition condition, String text) {
        super(text);
        this.lazyEntity = lazyEntity;
        this.condition = condition;
    }
}
