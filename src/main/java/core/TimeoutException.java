package core;

import core.conditions.AbstractCondition;

public class TimeoutException extends RuntimeException {

    private AbstractCondition condition;
    private Integer timeoutMs;

    public TimeoutException(AbstractCondition condition, int timeoutMs){
        this.condition=condition;
        this.timeoutMs=timeoutMs;
    }

    public String toString(){
        return "\nfailed while waiting " + timeoutMs / 1000 + " seconds" +
                "\nto assert " + condition;
    }
}
