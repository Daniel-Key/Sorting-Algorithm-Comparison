package basicAlgorithms;

import common.Beacon;

import java.util.ArrayList;

//A sorting algorithm which only sorts the sorted beacons initially, and when one is added
public class DontSort {

    private Beacon[] unsortedBeacons;
    private Beacon[] sortedBeacons;
    //Avoids iterating through the sortBeacons array, to check if any indexes are null, each time a beacon is added
    int count;
    private boolean arrayFilled;

    public DontSort() {}

    public Beacon[] findNearestBeacons(int x, int y, int nearestBeaconsNo, ArrayList<Beacon> beacons) {
        unsortedBeacons = new Beacon[beacons.size()];
        for (int i = 0; i < beacons.size(); i++) {
            double xDistance = Math.abs(beacons.get(i).getxCoord()-x);
            double yDistance = Math.abs(beacons.get(i).getyCoord()-y);
            double distance = Math.sqrt((xDistance * xDistance) + (yDistance * yDistance));
            beacons.get(i).setDistance(distance);
            unsortedBeacons[i] = beacons.get(i);
        }

        sortedBeacons = new Beacon[nearestBeaconsNo];
        count = 0;
        for (int i = 0; i < beacons.size(); i++) {
            addBeacon(beacons.get(i));
        }
        return sortedBeacons;
    }

    private void addBeacon(Beacon beacon) {
        if (!arrayFilled) {
            count++;
            for (int i = 0; i < sortedBeacons.length; i++) {
                if (sortedBeacons[i] == null) {
                    sortedBeacons[i] = beacon;
                    break;
                }
                else if (sortedBeacons[i].getDistance() > beacon.getDistance()) {
                    for (int j = sortedBeacons.length-1; j > i; j--) {
                        sortedBeacons[j] = sortedBeacons[j-1];
                    }
                    sortedBeacons[i] = beacon;
                    break;
                }
            }
            if (count == sortedBeacons.length) {
                arrayFilled = true;
            }
        }
        else {
            if (beacon.getDistance() < sortedBeacons[sortedBeacons.length-1].getDistance()) {

                for (int i = sortedBeacons.length-1; i > 0; i--) {
                    if (beacon.getDistance() > sortedBeacons[i].getDistance()) {
                        for (int j = sortedBeacons.length-1; j > i+1; j--) {
                            sortedBeacons[j] = sortedBeacons[j-1];
                        }
                        sortedBeacons[i+1] = beacon;
                        break;
                    }
                }
            }
        }
    }
}
