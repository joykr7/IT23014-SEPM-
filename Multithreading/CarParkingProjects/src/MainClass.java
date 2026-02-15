import java.util.Scanner;

public class MainClass {

    public static void main(String[] args) {

        ParkingPool pool = new ParkingPool();

        // Create N parking agents
        new ParkingAgent("Agent-1", pool).start();
        new ParkingAgent("Agent-2", pool).start();
        new ParkingAgent("Agent-3", pool).start();

        Scanner scanner = new Scanner(System.in);
        int carCount = 0;

        // Simulate car arrivals
        while (carCount < 10) {

            System.out.println(
                "Press ENTER to add a car (-1 to exit)");

            scanner.nextLine();

            RegistrarParking car = new RegistrarParking();
            pool.addCar(car);

            carCount++;
        }

        scanner.close();
    }
}
