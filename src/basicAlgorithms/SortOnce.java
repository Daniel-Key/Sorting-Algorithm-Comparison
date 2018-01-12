package basicAlgorithms;

import common.Beacon;

import java.util.ArrayList;
import java.util.Collections;

//A sorting algorithm which sorts all beacons once at the end
public class SortOnce {

    private ArrayList<Beacon> unsortedBeacons;
    private Beacon[] sortedBeacons;

    public SortOnce() {}

    public Beacon[] findNearestBeacons(int x, int y, int nearestBeaconsNo, ArrayList<Beacon> beacons) {
        unsortedBeacons = new ArrayList<>();
        for (int i = 0; i < beacons.size(); i++) {
            double xDistance = Math.abs(beacons.get(i).getxCoord() - x);
            double yDistance = Math.abs(beacons.get(i).getyCoord() - y);
            double distance = Math.sqrt((xDistance * xDistance) + (yDistance * yDistance));
            beacons.get(i).setDistance(distance);
            unsortedBeacons.add(i, beacons.get(i));
        }
        Collections.sort(unsortedBeacons);
        sortedBeacons = new Beacon[nearestBeaconsNo];
        for (int i = 0; i < nearestBeaconsNo; i++) {
            sortedBeacons[i] = unsortedBeacons.get(i);
        }
        return sortedBeacons;
    }
}
