package tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;


/**
 * This is a JUnit test suite for the FunctionalityTest and ExperimentalTest classes.
 *
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
        FunctionalityTests.class,
        ExperimentalTests.class
})
public class Tests {
}
