import org.junit.Test;
import testconfigs.ToDoMVC;

import static pages.ToDoMVC.*;

public class TodoMVCTest extends ToDoMVC {

    @Test
    public void testEdit() {
        //given
        add("a");

        startEditing("a", "a edited").pressEnter();
        assertTasks("a edited");
        assertItemsLeft(1);
    }

    @Test
    public void testCancelEdit() {
        //given
        add("a");

        startEditing("a", "a edited").pressEscape();
        assertTasks("a");
        assertItemsLeft(1);
    }

    @Test
    public void testActivateAllOnCompletedFilter() {
        //given - completed tasks
        add("a", "b");
        toggleAll();
        filterCompleted();

        toggleAll();
        assertEmptyVisibleTasks();
        assertItemsLeft(2);
    }

    @Test
    public void testTasksCommonFlow() {

        add("a");
        assertVisibleTasks("a");
        toggleAll();

        filterActive();
        assertEmptyVisibleTasks();

        add("b");
        toggle("b");
        assertEmptyVisibleTasks();

        filterCompleted();
        assertVisibleTasks("a", "b");

        //activate task
        toggle("a");
        assertVisibleTasks("b");

        сlearCompleted();
        assertEmptyVisibleTasks();
        assertItemsLeft(1);

        filterAll();
        delete("a");
        assertTasksEmpty();
    }


}
