package testconfigs;

import core.ConciseAPI;
import org.junit.Before;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Gmail extends BaseTest {

    @Before
    public void setUp(){
        ConciseAPI.setDriver(new FirefoxDriver());
    }
}
