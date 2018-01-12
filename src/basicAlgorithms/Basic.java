package basicAlgorithms;

import common.Beacon;

import java.util.ArrayList;

//A basic sorting algorithm, implementing an insertion sort
public class Basic {

    private Beacon[] sortedBeacons;
    private Beacon[] nearestBeacons;

    public Basic() {}

    public Beacon[] findNearestBeacons(int x, int y, int nearestBeaconsNo, ArrayList<Beacon> beacons) {
        sortedBeacons = new Beacon[beacons.size()];
        for (int i = 0; i < beacons.size(); i++) {
            double xDistance = Math.abs(beacons.get(i).getxCoord()-x);
            double yDistance = Math.abs(beacons.get(i).getyCoord()-y);
            double distance = Math.sqrt((xDistance * xDistance) + (yDistance * yDistance));
            beacons.get(i).setDistance(distance);

            int index = insertIntoSortedList(beacons.get(i));
            for (int j = sortedBeacons.length-1; j > index+1; j--) {
                sortedBeacons[j] = sortedBeacons[j-1];
            }
            sortedBeacons[index] = beacons.get(i);
        }
        nearestBeacons = new Beacon[nearestBeaconsNo];
        for (int i = 0; i < nearestBeaconsNo; i++) {
            nearestBeacons[i] = sortedBeacons[i];
        }
        return nearestBeacons;
    }

    public int insertIntoSortedList(Beacon beacon) {
        for (int i = 0; i < sortedBeacons.length; i++) {
            if ((sortedBeacons[i] != null) && (sortedBeacons[i].getDistance() > beacon.getDistance())) {
                return i;
            }
            else if (sortedBeacons[i] == null) {
                return i;
            }
        }
        return -1;
    }

}
