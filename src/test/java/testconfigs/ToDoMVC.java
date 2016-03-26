package testconfigs;

import core.ConciseAPI;
import org.junit.Before;
import org.openqa.selenium.firefox.FirefoxDriver;

import static core.ConciseAPI.open;

public class ToDoMVC extends BaseTest {

    @Before
    public void setUp() {
        ConciseAPI.setDriver(new FirefoxDriver());
        open("https://todomvc4tasj.herokuapp.com/");
    }
}