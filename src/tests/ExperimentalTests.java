package tests;

import common.Main;
import org.junit.Test;

//Tests used to produce experimental data about the sorting algorithms
//Running all of these will take a long time because of the inefficiency of the basic algorithm,
//it's recommended to run specific tests
public class ExperimentalTests {

    /**
     * The data sets tested below can be found in the report under the heading Algorithm Comparison
     * Testing data set A for all three algorithms
     */
    @Test
    public void testDataSetA() {
        Main main = new Main();
        main.setMaxCoordinate(10);
        main.setTotalBeaconNo(100);
        main.setNearestBeaconNo(10);
        main.calculateAverageAlgorithmTime(100, "Basic", false);
        main.calculateAverageAlgorithmTime(100, "SortOnce", false);
        main.calculateAverageAlgorithmTime(100, "DontSort", false);
    }

    /**
     * Testing data set B for all three algorithms
     */
    @Test
    public void testDataSetB() {
        Main main = new Main();
        main.setMaxCoordinate(100);
        main.setTotalBeaconNo(1000);
        main.setNearestBeaconNo(10);
        main.calculateAverageAlgorithmTime(100, "Basic", false);
        main.calculateAverageAlgorithmTime(100, "SortOnce", false);
        main.calculateAverageAlgorithmTime(100, "DontSort", false);
    }

    /**
     * Testing data set C for all three algorithms
     */
    @Test
    public void testDataSetC() {
        Main main = new Main();
        main.setMaxCoordinate(100);
        main.setTotalBeaconNo(1000);
        main.setNearestBeaconNo(100);
        main.calculateAverageAlgorithmTime(100, "Basic", false);
        main.calculateAverageAlgorithmTime(100, "SortOnce", false);
        main.calculateAverageAlgorithmTime(100, "DontSort", false);
    }

    /**
     * Testing data set D for all three algorithms
     */
    @Test
    public void testDataSetD() {
        Main main = new Main();
        main.setMaxCoordinate(1000);
        main.setTotalBeaconNo(10000);
        main.setNearestBeaconNo(100);
        main.calculateAverageAlgorithmTime(100, "Basic", false);
        main.calculateAverageAlgorithmTime(100, "SortOnce", false);
        main.calculateAverageAlgorithmTime(100, "DontSort", false);
    }

    /**
     * Testing data set E for all three algorithms
     */
    @Test
    public void testDataSetE() {
        Main main = new Main();
        main.setMaxCoordinate(1000);
        main.setTotalBeaconNo(10000);
        main.setNearestBeaconNo(1000);
        main.calculateAverageAlgorithmTime(100, "Basic", false);
        main.calculateAverageAlgorithmTime(100, "SortOnce", false);
        main.calculateAverageAlgorithmTime(100, "DontSort", false);
    }

    /**
     * Tests the variance in time taken for the Basic algorithm as the range of coordinates increases
      */
    @Test
    public void increaseCoordinatesBasic() {
        Main main = new Main();
        main.setMaxCoordinate(10);
        System.out.println("Dummy process, ignore output:");
        main.calculateAverageAlgorithmTime(5, "Basic", false);
        System.out.println();
        for (int i = 0; i < 5; i++) {
            main.calculateAverageAlgorithmTime(100, "Basic", false);
            int newMaxCoordinate = main.getMaxCoordinate() * 10;
            main.setMaxCoordinate(newMaxCoordinate);
        }
    }

    /**
     * Tests the variance in time taken for the SortOnce algorithm as the range of coordinates increases
     */
    @Test
    public void increaseCoordinatesSortOnce() {
        Main main = new Main();
        main.setMaxCoordinate(10);
        System.out.println("Dummy process, ignore output:");
        main.calculateAverageAlgorithmTime(5, "SortOnce", false);
        System.out.println();
        for (int i = 0; i < 5; i++) {
            main.calculateAverageAlgorithmTime(100, "SortOnce", false);
            int newMaxCoordinate = main.getMaxCoordinate() * 10;
            main.setMaxCoordinate(newMaxCoordinate);
        }
    }

    /**
     * Tests the variance in time taken for the DontSort algorithm as the range of coordinates increases
     */
    @Test
    public void increaseCoordinatesDontSort() {
        Main main = new Main();
        main.setMaxCoordinate(10);
        System.out.println("Dummy process, ignore output:");
        main.calculateAverageAlgorithmTime(5, "DontSort", false);
        System.out.println();
        for (int i = 0; i < 5; i++) {
            main.calculateAverageAlgorithmTime(100, "DontSort", false);
            int newMaxCoordinate = main.getMaxCoordinate() * 10;
            main.setMaxCoordinate(newMaxCoordinate);
        }
    }

    /**
     * Tests the variance in time taken for the Basic algorithm as the total number of beacons increases
     */
    @Test
    public void increaseTotalBeaconsBasic() {
        Main main = new Main();
        main.setTotalBeaconNo(10);
        main.setNearestBeaconNo(10);
        System.out.println("Dummy process, ignore output:");
        main.calculateAverageAlgorithmTime(5, "Basic", false);
        System.out.println();
        //Using 10 tests for the basic algorithm as otherwise it's too slow
        for (int i = 0; i < 5; i++) {
            main.calculateAverageAlgorithmTime(10, "Basic", false);
            int newTotalBeaconNo = main.getTotalBeaconNo() * 10;
            main.setTotalBeaconNo(newTotalBeaconNo);
        }
    }

    /**
     * Tests the variance in time taken for the SortOnce algorithm as the total number of beacons increases
     */
    @Test
    public void increaseTotalBeaconsSortOnce() {
        Main main = new Main();
        main.setTotalBeaconNo(10);
        main.setNearestBeaconNo(10);
        System.out.println("Dummy process, ignore output:");
        main.calculateAverageAlgorithmTime(10, "SortOnce", false);
        System.out.println();
        for (int i = 0; i < 5; i++) {
            main.calculateAverageAlgorithmTime(100, "SortOnce", false);
            int newTotalBeaconNo = main.getTotalBeaconNo() * 10;
            main.setTotalBeaconNo(newTotalBeaconNo);
        }
    }

    /**
     * Tests the variance in time taken for the DontSort algorithm as the total number of beacons increases
     */
    @Test
    public void increaseTotalBeaconsDontSort() {
        Main main = new Main();
        main.setTotalBeaconNo(10);
        main.setNearestBeaconNo(10);
        System.out.println("Dummy process, ignore output:");
        main.calculateAverageAlgorithmTime(10, "DontSort", false);
        System.out.println();
        for (int i = 0; i < 5; i++) {
            main.calculateAverageAlgorithmTime(100, "DontSort", false);
            int newTotalBeaconNo = main.getTotalBeaconNo() * 10;
            main.setTotalBeaconNo(newTotalBeaconNo);
        }
    }

    /**
     * Tests the variance in time taken for the Basic algorithm as the number of nearest beacons increases
     */
    @Test
    public void increaseNearestBeaconsBasic() {
        Main main = new Main();
        main.setTotalBeaconNo(10000);
        main.setNearestBeaconNo(1);
        System.out.println("Dummy process, ignore output:");
        main.calculateAverageAlgorithmTime(10, "SortOnce", false);
        System.out.println();
        for (int i = 0; i < 5; i++) {
            main.calculateAverageAlgorithmTime(100, "Basic", false);
            int newNearestBeaconNo = main.getNearestBeaconNo() * 10;
            main.setNearestBeaconNo(newNearestBeaconNo);
        }
    }

    /**
     * Tests the variance in time taken for the SortOnce algorithm as the number of nearest beacons increases
     */
    @Test
    public void increaseNearestBeaconsSortOnce() {
        Main main = new Main();
        main.setTotalBeaconNo(10000);
        main.setNearestBeaconNo(1);
        System.out.println("Dummy process, ignore output:");
        main.calculateAverageAlgorithmTime(10, "SortOnce", false);
        System.out.println();
        for (int i = 0; i < 5; i++) {
            main.calculateAverageAlgorithmTime(100, "SortOnce", false);
            int newNearestBeaconNo = main.getNearestBeaconNo() * 10;
            main.setNearestBeaconNo(newNearestBeaconNo);
        }
    }

    /**
     * Tests the variance in time taken for the DontSort algorithm as the number of nearest beacons increases
     */
    @Test
    public void increaseNearestBeaconsDontSort() {
        Main main = new Main();
        main.setTotalBeaconNo(10000);
        main.setNearestBeaconNo(1);
        System.out.println("Dummy process, ignore output:");
        main.calculateAverageAlgorithmTime(10, "DontSort", false);
        System.out.println();
        for (int i = 0; i < 5; i++) {
            main.calculateAverageAlgorithmTime(100, "DontSort", false);
            int newNearestBeaconNo = main.getNearestBeaconNo() * 10;
            main.setNearestBeaconNo(newNearestBeaconNo);
        }
    }

    /**
     * The following tests were used to make the graph in the extension
     * Tests the variance in time taken between the DontSort and DontSortAlternative algorithms
     */
    @Test
    public void compareDontSortAndDontSortAlternative() {
        Main main = new Main();
        main.setTotalBeaconNo(10000);
        main.setNearestBeaconNo(10);
        System.out.println("Dummy process, ignore output:");
        main.calculateAverageAlgorithmTime(10, "DontSort", false);
        System.out.println();
        for (int i = 0; i < 5; i++) {
            main.calculateAverageAlgorithmTime(100, "DontSort", false);
            main.calculateAverageAlgorithmTime(100, "DontSortAlternative", false);
            int newNearestBeaconNo = main.getNearestBeaconNo() * 10;
            main.setNearestBeaconNo(newNearestBeaconNo);
        }
    }

    /*@Test
    public void test() {
        Main main = new Main();
        main.setTotalBeaconNo(100);
        main.setNearestBeaconNo(10);
        main.calculateAverageAlgorithmTime(1, "DontSortAlternative", true);
    }*/
}
