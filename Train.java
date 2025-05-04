import java.util.ArrayList;

public class Train implements TrainRequirements{
    // Attributes
    private Engine engine;
    private ArrayList<Car> cars;

    // Constructor 
    public Train(FuelType fuelType, double fuelCapacity, int nCars, int passengerCapacity) {
        this.engine = new Engine(fuelType, nCars, passengerCapacity);
        this.cars = new ArrayList<>();
    }

    /**
     * 
     * @return engine
     */
    public Engine getEngine() {
        return engine;
    }

    /**
     * 
     * @param i
     * @return the ith car
     */
    public Car getCar(int i) {
        if (i < cars.size()) {
            return cars.get(i);
        }
        return null;
    }

    /**
     * 
     * @return the maximum total capacity across all the cars
     */
    public int getMaxCapacity() {
        int maxCapacity = 0;
        for (Car car : cars) {
            maxCapacity += car.getCapacity();
        }
        return maxCapacity;
    }

    /**
     * 
     * @return the remaining open seats across all the cars
     */
    public int seatsRemaining() {
        int seatsRemaining = 0;
        for (Car car : cars) {
            seatsRemaining += car.seatsRemaining();
        }
        return seatsRemaining;
    }

    /**
     * 
     * For each car determines the number of seat and then prints a manifest of all the passengers aboard the train
     */
    public void printManifest() {
        for (int i = 0; i < cars.size(); i++) {
            System.out.println("Car #" + i + ":");
            if (cars.get(i).seatsRemaining() < cars.get(i).getCapacity()) {
                cars.get(i).printManifest();
            } else {
                System.out.println("Sorry, this car is empty");
            }
        }
    }
}
