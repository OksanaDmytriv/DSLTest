package core;

import core.conditions.CustomCondition;

public class TimeoutException extends RuntimeException {

    private CustomCondition condition;
    private Integer timeoutMs;

    public TimeoutException(CustomCondition condition, int timeoutMs){
        this.condition=condition;
        this.timeoutMs=timeoutMs;
    }

    public String toString(){
        return "\nfailed while waiting " + timeoutMs / 1000 + " seconds" +
                "\nto assert " + condition;
    }
}
