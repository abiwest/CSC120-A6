import static org.junit.Assert.*;
import org.junit.Test;

public class TrainTest {

    // Engine Tests
    @Test
    public void testEngineConstructor() {
        Engine x = new Engine(FuelType.ELECTRIC, 20, 100);

        assertEquals(FuelType.ELECTRIC, x.getFuelType());
        assertEquals(20.0, x.getCurrentFuel(), 0.001);
        assertEquals(100.0, x.getMaxFuel(), 0.001);
    }

    @Test
    public void testEngineGo() {
        Engine x = new Engine(FuelType.ELECTRIC, 20, 100);
        boolean result = x.go();

        assertEquals(10.0, x.getCurrentFuel(), 0.001);
        assertTrue(result);
    }

    // Car Tests
    @Test
    public void testCarAddPassenger() {
        Passenger x = new Passenger("Abi");
        Car c = new Car(10);
        boolean result = c.addPassenger(x);

        assertTrue(result);
    }

    @Test
    public void testCarRemovePassenger() {
        Passenger x = new Passenger("Abi");
        Car c = new Car(10);
        c.addPassenger(x);
        boolean result = c.removePassenger(x);

        assertTrue(result);
    }

    // Passenger Tests
    @Test
    public void testPassengerBoardCarWithSpace() {
        Car c = new Car(2);
        Passenger abi = new Passenger("Abi");

        abi.boardCar(c);
        assertEquals(1, c.seatsRemaining());
    }

    @Test
    public void testPassengerBoardCarFull() {
        Car c = new Car(2);
        Passenger abi = new Passenger("Abi");
        Passenger abigail = new Passenger("Abigail");

        abi.boardCar(c);
        abigail.boardCar(c);

        assertEquals(0, c.seatsRemaining());
        
    }

    // Train Tests
    @Test
    public void testTrainConstructor() {
        Train t = new Train(FuelType.ELECTRIC, 100, 3, 100);

        assertNotNull(t.getCar(0));
        assertNotNull(t.getCar(1));
        assertNotNull(t.getCar(2));
    }

    @Test
    public void testTrainPassengerCount() {
        Passenger x = new Passenger("Abi");
        Train t = new Train(FuelType.ELECTRIC, 100, 3, 100);
        
        t.getCar(1).addPassenger(x);
        assertEquals(1, t.getMaxCapacity() - t.seatsRemaining());

        t.getCar(1).removePassenger(x);
        assertEquals(0, t.getMaxCapacity() - t.seatsRemaining());

    }

    @Test
    public void testTrainGetCar() {
        Train t = new Train(FuelType.ELECTRIC, 100, 3, 100);

        Car car1 = t.getCar(0);
        assertNotNull(car1);

        Car car2 = t.getCar(1);
        assertNotNull(car2);

        Car car3 = t.getCar(2);
        assertNotNull(car3);
    }

    @Test
    public void testTrainPrintManifest() { // I couldn't figure out how to go about this, so I will have to go to TA or office hours before I resubmit it
        Train t = new Train(FuelType.ELECTRIC, 100, 3, 100);

        t.printManifest();
    }
    
}
