public class Passenger {
    
    private String name;

    public Passenger(String name) {
        this.name = name;
    }

    public String getName() { // Accessor to get the passenger name
        return name;
    }

    /**
     * 
     * @param c (car)
     * @return t/f if the passenger sucessfully boarded the car
     */
    public Boolean boardCar(Car c) {
        boolean success = c.addPassenger(this); // I had to look online at stack overflow to figure out how to use boolean success in this context
        if (success) {
            System.out.println(name + " has successfully boarded the car");
        } else {
            System.out.println("Sorry this car is full, " + name + " could not board");
        }
        return success; // returns if the function was successful in a boolean format
    }

    /**
     * 
     * @param c (car)
     * @return t/f if the passenger sucessfully exited the car
     */
    public Boolean getOffCar(Car c) {
        boolean success = c.removePassenger(this);
        if (success) {
            System.out.println(name + " has successfully departed the car");
        } else {
            System.out.println(name + " isn't onboard this car");
        }
        return success;
    }
}
