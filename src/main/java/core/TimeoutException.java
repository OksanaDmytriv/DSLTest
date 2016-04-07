package core;

public class TimeoutException extends RuntimeException {

    private String text;

    public TimeoutException(String text){
        this.text=text;
    }
}
