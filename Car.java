import java.util.ArrayList;

public class Car implements CarRequirements{
    private ArrayList<Passenger> passengersOnboard;
    private int maxCapacity;

    // Constructor
    public Car(int maxCapacity) {
        this.maxCapacity = maxCapacity;
        this.passengersOnboard = new ArrayList<>(); // creates the empty passenger list
    }

    /**
     * 
     * @return the max capacity
     */
    public int getCapacity() {
        return maxCapacity;
    }

    /**
     * 
     * @return the seats remaining in the car
     */
    public int seatsRemaining() {
        return maxCapacity - passengersOnboard.size();
    }

    /**
     * 
     * @param p (passenger)
     * @return t/f if the passenger is added
     */
    public Boolean addPassenger(Passenger p) {
        if (passengersOnboard.size() < maxCapacity) { // checks if there's space
            passengersOnboard.add(p);
            return true; // the passenger can sucessfully be added
        } else {
            return false; // the car is full
        }
    }

    /**
     * 
     * prints the passenger manifest for each car
     */
    public void printManifest() {
        if (passengersOnboard.size() < 1) {
            System.out.println("This car is EMPTY.");
        } else {
            System.out.println("Passengers aboard:");
            for (Passenger p : passengersOnboard) { // for loop that prints the name for each of the passengers
                System.out.println(p.getName());
            }
        }
    }

    /**
     * 
     * @param p (passenger)
     * @return t/f if the passenger is removed
     */
    public Boolean removePassenger(Passenger p) {
        return passengersOnboard.remove(p); // will return true or false for the boolean if the passenger is removed
    }
}