package testconfigs;

import core.ConciseAPI;
import core.Configuration;
import org.junit.After;

public class BaseTest {

    static {
        Configuration.timeout = 20000;
    }

    @After
    public void teardown() {
        ConciseAPI.getDriver().quit();
    }

}
