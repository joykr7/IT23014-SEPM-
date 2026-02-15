import java.util.LinkedList;
import java.util.Queue;

// Shared resource between threads
public class ParkingPool {

    private Queue<RegistrarParking> queue = new LinkedList<>();
    private int capacity = 5;

    // Add car request (Producer)
    public synchronized void addCar(RegistrarParking car) {

        while (queue.size() == capacity) {
            try {
                System.out.println("Parking Full... waiting");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        queue.add(car);
        System.out.println("Car Added -> Car " + car.getCarId());

        notifyAll();
    }

    // Remove car request (Consumer)
    public synchronized RegistrarParking getCar() {

        while (queue.isEmpty()) {
            try {
                System.out.println("No cars waiting...");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        RegistrarParking car = queue.remove();
        notifyAll();
        return car;
    }
}

