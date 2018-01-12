package common;

import basicAlgorithms.Basic;
import basicAlgorithms.DontSort;
import basicAlgorithms.SortOnce;
import extensionAlgorithms.DontSortAlternative;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class Main {

    //Fields for the values of parameters of the sorting algorithms
    private int minCoordinate = 0;
    private int maxCoordinate = 1000;
    private int totalBeaconNo = 10000;
    private int nearestBeaconNo = 100;
    private ArrayList<Beacon> beacons;
    private Beacon target;

    public Main() {}

    //Generates an ArrayList of Beacon objects with random coordinates
    private ArrayList<Beacon> generateBeaconArrayList(int beaconNo) {
        ArrayList<Beacon> beacons = new ArrayList<>();
        for (int i = 0; i < beaconNo; i++) {
            int xCoord = generateRandomCoordinate();
            int yCoord = generateRandomCoordinate();
            Beacon beacon = new Beacon(xCoord, yCoord);
            beacons.add(beacon);
        }
        return beacons;
    }

    //Generates a target Beacon object with random coordinates
    private Beacon generateTarget() {
        int xCoord = generateRandomCoordinate();
        int yCoord = generateRandomCoordinate();
        Beacon beacon = new Beacon(xCoord, yCoord);
        return beacon;
    }

    //Generates a random coordinate within the range specified by minCoordinate and maxCoordinate
    private int generateRandomCoordinate() {
        int range = (maxCoordinate -minCoordinate) +1;
        return (int)(Math.random() * range) + minCoordinate;
    }

    //Runs the sorting algorithm specified in the method argument
    //Returns a double containing the amount of time taken to run the sorting algorithm
    //If boolean print is true, prints out the calculated distances and the time taken in milliseconds
    public double runAlgorithm(String algorithm, boolean print) {
        long startTime;
        double timeTaken = 0;
        if (algorithm.equals("Basic")) {
            Basic basicAlgorithm = new Basic();
            Beacon[] nearestBeacons;
            beacons = generateBeaconArrayList(totalBeaconNo);
            target = generateTarget();
            startTime = System.nanoTime();
            nearestBeacons = basicAlgorithm.findNearestBeacons(target.getxCoord(), target.getyCoord(), nearestBeaconNo, beacons);
            timeTaken = (double)(System.nanoTime() - startTime)/1000000;

            if (print) {
                System.out.println("Distances: ");
                for (Beacon beacon : nearestBeacons) {
                    System.out.println(beacon.getDistance());
                }
                System.out.println("Time taken: " + timeTaken + " milliseconds");
                System.out.println();
            }
        }
        else if (algorithm.equals("SortOnce")) {
            SortOnce sortOnce = new SortOnce();
            Beacon[] nearestBeacons;
            beacons = generateBeaconArrayList(totalBeaconNo);
            target = generateTarget();
            startTime = System.nanoTime();
            nearestBeacons = sortOnce.findNearestBeacons(target.getxCoord(), target.getyCoord(), nearestBeaconNo, beacons);
            timeTaken = (double)(System.nanoTime() - startTime)/1000000;

            if (print) {
                for (Beacon beacon : nearestBeacons) {
                    System.out.println(beacon.getDistance());
                }
                System.out.println("Time taken: " + timeTaken + " milliseconds");
                System.out.println();
            }
        }
        else if (algorithm.equals("DontSort")) {
            DontSort dontSort = new DontSort();
            Beacon[] nearestBeacons;
            beacons = generateBeaconArrayList(totalBeaconNo);
            target = generateTarget();
            startTime = System.nanoTime();
            nearestBeacons = dontSort.findNearestBeacons(target.getxCoord(), target.getyCoord(), nearestBeaconNo, beacons);
            timeTaken = (double)(System.nanoTime() - startTime)/1000000;

            if (print) {
                for (Beacon beacon : nearestBeacons) {
                    System.out.println(beacon.getDistance());
                }
                System.out.println("Time taken: " + timeTaken + " milliseconds");
                System.out.println();
            }
        }
        else if (algorithm.equals("DontSortAlternative")) {
            DontSortAlternative dontSortAlternative = new DontSortAlternative();
            Beacon[] nearestBeacons;
            beacons = generateBeaconArrayList(totalBeaconNo);
            target = generateTarget();
            startTime = System.nanoTime();
            nearestBeacons = dontSortAlternative.findNearestBeacons(target.getxCoord(), target.getyCoord(), nearestBeaconNo, beacons);
            timeTaken = (double)(System.nanoTime() - startTime)/1000000;

            if (print) {
                for (Beacon beacon : nearestBeacons) {
                    System.out.println(beacon.getDistance());
                }
                System.out.println("Time taken: " + timeTaken + " milliseconds");
                System.out.println();
            }
        }
        else {
            System.out.print("Unknown Algorithm Name");
            return -1;
        }
        return timeTaken;
    }

    //Calculates and prints the average (mean) time taken to run a sorting algorithm across a specified number of tests
    //Also calculates and prints the standard deviation of these times
    public void calculateAverageAlgorithmTime(int testNo, String algorithm, boolean print) {
        double totalTimeTaken = 0;
        double[] times = new double[testNo];
        for (int i = 0; i < testNo; i++) {
            double timeTaken = -1;
            if (print) {
                timeTaken = runAlgorithm(algorithm, true);
            }
            else {
                timeTaken = runAlgorithm(algorithm, false);
            }
            totalTimeTaken += timeTaken;
            times[i] = timeTaken;
        }
        double averageTimeTaken = (totalTimeTaken / testNo);
        DecimalFormat timeFormat = new DecimalFormat("#0.0000000000");
        System.out.println("Average time for " + algorithm + " algorithm: " + timeFormat.format(averageTimeTaken) + " milliseconds");

        //Working out the standard deviation
        double totalSquaredDifference = 0;
        for (int i = 0; i < testNo; i ++) {
            double squaredDifference = ((times[i] - averageTimeTaken) * (times[i] - averageTimeTaken));
            totalSquaredDifference += squaredDifference;
        }
        double variance = totalSquaredDifference/testNo;
        double standardDeviation = Math.sqrt(variance);
        System.out.println("Standard deviation: " + timeFormat.format(standardDeviation) + " milliseconds");
    }

    //Getters and setters used in the test class to edit the parameters of the sorting algorithm
    public int getMaxCoordinate() {
        return maxCoordinate;
    }

    public void setMaxCoordinate(int maxCoordinate) {
        this.maxCoordinate = maxCoordinate;
    }

    public int getTotalBeaconNo() {
        return totalBeaconNo;
    }

    public void setTotalBeaconNo(int totalBeaconNo) {
        this.totalBeaconNo = totalBeaconNo;
    }

    public int getNearestBeaconNo() {
        return nearestBeaconNo;
    }

    public void setNearestBeaconNo(int nearestBeaconNo) {
        this.nearestBeaconNo = nearestBeaconNo;
    }
}
