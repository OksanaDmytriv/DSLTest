package core.conditions.element;

public class ExactText extends Text {

    public ExactText(String text) {
        super(text);
    }

    public boolean checkList() {
        return currentText.equals(text);
    }
}
