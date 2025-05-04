public class Engine implements EngineRequirements {

    //Attributes
    private FuelType fuelType;
    private double currentFuelLevel;
    private double maxFuelLevel; 

    /**
     * 
     * @param fuelType
     * @param currentFuelLevel
     * @param maxFuelLevel
     */
    public Engine(FuelType fuelType, double currentFuelLevel, double maxFuelLevel) {
        this.fuelType = fuelType; 
        this.currentFuelLevel = currentFuelLevel;
        this.maxFuelLevel = maxFuelLevel;
    }

    /**
     * 
     * @return fuelType
     */
    public FuelType getFuelType(){
        return this.fuelType; 
    }

    /**
     * 
     * @return maxFuelLevel
     */
    public double getMaxFuel() {
        return maxFuelLevel; 
    }

    /**
     * 
     * @return currentFuelLevel
     */
    public double getCurrentFuel() {
        return currentFuelLevel; 
    }

    /**
     * 
     * @return n/a, this refuels the engine and prints the new fuel level
     */
    public void refuel() {
        currentFuelLevel = maxFuelLevel;
        System.out.println("Train has been refueled to it's max capacity: " + maxFuelLevel);
    }

    /**
     * 
     * @return the current fuel level as the engine is running
     */
    public Boolean go() {
        if (currentFuelLevel > 0) {
            currentFuelLevel -= 10; // removes 10 from the fuel level while it's running until theres no fuel left
            System.out.println("The train is moving! Remaining fuel = " + currentFuelLevel);
            return currentFuelLevel > 0;
        } else {
            System.out.println("Sorry, there's no fuel left!");
            return false;
        }
    }

    /**
     * 
     * @return the current fuel and engine information
     */
    public String toString() {
        return("Engine has fuel type: " + this.fuelType + " current fuel level: " + this.currentFuelLevel + " and max fuel level: " + this.maxFuelLevel); 
    }

    // Main testing
     // Main method for testing
     public static void main(String[] args) {
        Engine myEngine = new Engine(FuelType.ELECTRIC, 100, 100);
        while (myEngine.go()) {
            System.out.println("Choo choo!");
        }
        System.out.println("Out of fuel.");
    }

}