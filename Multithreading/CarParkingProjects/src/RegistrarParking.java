// Represents a car parking request
public class RegistrarParking {

    private static int count = 1;
    private int carId;

    public RegistrarParking() {
        carId = count++;
    }

    public int getCarId() {
        return carId;
    }
}
