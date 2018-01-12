package common;

//Class representing a Beacon, with attributes for coordinates and the distance from the target
//Implements Comparable<Beacon> to allow the compareTo method to be overridden and Collections.sort() to be used in sorting algorithms
public class Beacon implements Comparable<Beacon>{

    private int xCoord;
    private int yCoord;
    private double distance;

    //Constructor to instantiate Beacons
    public Beacon(int xCoord, int yCoord) {
        this.xCoord= xCoord;
        this.yCoord = yCoord;
    }

    public int getxCoord() {
        return xCoord;
    }

    public void setxCoord(int xCoord) {
        this.xCoord = xCoord;
    }

    public int getyCoord() {
        return yCoord;
    }

    public void setyCoord(int yCoord) {
        this.yCoord = yCoord;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    @Override
    public int compareTo(Beacon beacon) {
        if (this.distance > beacon.distance) {
            return 1;
        }
        else if (this.distance == beacon.distance){
            return 0;
        }
        else {
            return -1;
        }
    }
}
