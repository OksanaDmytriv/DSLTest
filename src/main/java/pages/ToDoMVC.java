package pages;

import org.openqa.selenium.Keys;
import ru.yandex.qatools.allure.annotations.Step;
import wrappers.forCollection.LazyCollection;
import wrappers.forElement.LazyElement;

import static conditions.collection.CustomCollectionCondition.*;
import static conditions.element.CustomElementCondition.*;
import static core.ConciseAPI.*;

public class ToDoMVC {

    public static LazyCollection tasks = $$("#todo-list li");

    public static LazyElement counter = $("#todo-count>strong");

    @Step
    public static void add(String... taskTexts) {
        for (String text : taskTexts) {
            $(byCSS("#new-todo")).sendKeys(text + Keys.ENTER);
        }
    }

    @Step
    public static void assertItemsLeft(int number) {
        counter.shouldHave(textOf(Integer.toString(number)));
    }

    @Step
    public static void сlearCompleted() {
        $(byCSS("#clear-completed")).click();
    }

    @Step
    public static void toggle(String taskText) {
        tasks.find(exactTextOf(taskText)).find(".toggle").click();
    }

    @Step
    public static void toggleAll() {
        $(byCSS(("#toggle-all"))).click();
    }

    @Step
    public static LazyElement startEditing(String oldText, String newText) {
        tasks.find(exactTextOf(oldText)).find("label").doubleClick();
        return tasks.find(listElementWithCssClass("editing")).find(".edit").setValue(newText);
    }

    @Step
    public static void filterAll() {
        $(byCSS("[href='#/']")).click();
    }

    @Step
    public static void filterActive() {
        $(byCSS("[href='#/active']")).click();
    }

    @Step
    public static void filterCompleted() {
        $(byCSS("[href='#/completed']")).click();
    }

    @Step
    public static void delete(String taskText) {
        tasks.find(exactTextOf(taskText)).hover().find(".destroy").click();
    }

    @Step
    public static void assertTasks(String... taskTexts) {
        tasks.shouldHave(textsOf(taskTexts));
    }

    @Step
    public static void assertTasksEmpty() {
        tasks.shouldBe(empty);
    }

    @Step
    public static void assertVisibleTasks(String... taskTexts) {
        tasks.shouldHave(visibleTextsOf(taskTexts));
    }

    @Step
    public static void assertEmptyVisibleTasks() {
        tasks.shouldBe(listOfVisibleElementsIsEmpty);
    }
}