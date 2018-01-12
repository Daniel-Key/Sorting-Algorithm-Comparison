package extensionAlgorithms;

import common.Beacon;

import java.util.ArrayList;
import java.util.Collections;

//A alternative sorting algorithm which only sorts the sorted beacons initially, and when one is added

//The main difference between this class and the DontSort class is the use of Collections.sort, rather than insertion sort,
//which is less efficient with larger sizes of the sortedBeacons array
public class DontSortAlternative {

    private Beacon[] unsortedBeacons;
    private Beacon[] sortedBeacons;
    private ArrayList<Beacon> sortedBeaconsArrayList;
    //Avoids iterating through the sortBeacons array, to check if any indexes are null, each time a beacon is added
    int count;
    private boolean arrayFilled;

    public DontSortAlternative() {
    }

    public Beacon[] findNearestBeacons(int x, int y, int nearestBeaconsNo, ArrayList<Beacon> beacons) {
        unsortedBeacons = new Beacon[beacons.size()];
        for (int i = 0; i < beacons.size(); i++) {
            double xDistance = Math.abs(beacons.get(i).getxCoord() - x);
            double yDistance = Math.abs(beacons.get(i).getyCoord() - y);
            double distance = Math.sqrt((xDistance * xDistance) + (yDistance * yDistance));
            beacons.get(i).setDistance(distance);
            unsortedBeacons[i] = beacons.get(i);
        }

        sortedBeacons = new Beacon[nearestBeaconsNo];
        count = 0;
        sortedBeaconsArrayList = new ArrayList<>();
        //Fills the sortBeaconsArrayList with nulls to get it to the correct size
        for (int i = 0; i < sortedBeacons.length; i++) {
            sortedBeaconsArrayList.add(null);
        }
        //Iterates through each beacon in the beacons ArrayList, and calls the addBeacon method on it
        for (int i = 0; i < beacons.size(); i++) { ;
            addBeacon(beacons.get(i));
        }
        //Sets the sortedBeacons array to the values of the sortedBeaconsArrayList ArrayList
        for (int i = 0; i < sortedBeacons.length; i++) {
            sortedBeacons[i] = sortedBeaconsArrayList.get(i);
        }
        return sortedBeacons;
    }

    private void addBeacon(Beacon beacon) {
        if (!arrayFilled) {
            count++;
            //Iterates through the sortedBeaconsArrayList and adds the beacon in the first index with a value of null
            for (int i = 0; i < sortedBeacons.length; i++) {
                if (sortedBeaconsArrayList.get(i) == null) {
                    sortedBeaconsArrayList.set(i, beacon);
                    break;
                }
            }
            if (count == sortedBeacons.length) {
                //Sorts the ArrayList once it is full
                Collections.sort(sortedBeaconsArrayList);
                arrayFilled = true;
            }
        }
        else {
            //If the current beacon is closest than the largest beacon in the nearestBeacons ArrayList,
            //replaces the largest beacon with the current beacon and sorts the list again
            if (beacon.getDistance() < sortedBeaconsArrayList.get(sortedBeaconsArrayList.size()-1).getDistance()) {
                sortedBeaconsArrayList.set(sortedBeaconsArrayList.size()-1, beacon);
                Collections.sort(sortedBeaconsArrayList);
            }
        }
    }
}