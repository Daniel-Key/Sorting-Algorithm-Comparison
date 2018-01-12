package tests;

import common.Main;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

//Tests used to ensure functionality of each of the sorting algorithms
public class FunctionalityTests {

    /**
     * Tests that the Main runAlgorithm method returns an error message when run with an unknown algorithm
     */
    @Test
    public void runAlgorithmUnknownAlgorithm() {
        Main main = new Main();
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        main.runAlgorithm("NotAnAlgorithm", false);
        assertEquals("Unknown Algorithm Name", outContent.toString());
    }

    /**
     * Tests that the Basic algorithm can be run, and returns a time taken greater than zero
     * Also prints out the ordered list of the nearest beacons
     */
    @Test
    public void basicFunctionalityTest() {
        Main main = new Main();
        main.setTotalBeaconNo(100);
        main.setNearestBeaconNo(10);
        double time = main.runAlgorithm("Basic", true);
        assertTrue(time != 0);
    }

    /**
     * Tests that the SortOnce algorithm can be run, and returns a time taken greater than zero
     * Also prints out the ordered list of the nearest beacons
     */
    @Test
    public void sortOnceFunctionalityTest() {
        Main main = new Main();
        main.setTotalBeaconNo(100);
        main.setNearestBeaconNo(10);
        double time = main.runAlgorithm("SortOnce", true);
        assertTrue(time != 0);
    }

    /**
     * Tests that the DontSort algorithm can be run, and returns a time taken greater than zero
     * Also prints out the ordered list of the nearest beacons
     */
    @Test
    public void dontSortFunctionalityTest() {
        Main main = new Main();
        main.setTotalBeaconNo(100);
        main.setNearestBeaconNo(10);
        double time = main.runAlgorithm("DontSort", true);
        assertTrue(time != 0);
    }

    /**
     * Tests that the DontSortAlternative algorithm can be run, and returns a time taken greater than zero
     * Also prints out the ordered list of the nearest beacons
     */
    @Test
    public void dontSortAlternativeFunctionalityTest() {
        Main main = new Main();
        main.setTotalBeaconNo(100);
        main.setNearestBeaconNo(10);
        double time = main.runAlgorithm("DontSortAlternative", true);
        assertTrue(time != 0);
    }

    /**
     * Tests that the function to calculate standard deviation in the
     * calculateAverageAlgorithmTime method returns the correct standard deviation.
     * See report for worked example
     */
    @Test
    public void standardDeviationTest() {
        Main main = new Main();
        main.setTotalBeaconNo(100);
        main.setNearestBeaconNo(3);
        main.calculateAverageAlgorithmTime(3, "Basic", true);
    }

}
