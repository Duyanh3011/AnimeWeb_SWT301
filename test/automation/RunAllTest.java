package automation;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
    autoSignUp.class,
    testChangePass.class,
    testAuto.class, // UpdateVideoAutotest.class
})

public class RunAllTest {

}
