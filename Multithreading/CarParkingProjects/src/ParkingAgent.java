// Worker thread that parks cars
public class ParkingAgent extends Thread {

    private String agentName;
    private ParkingPool pool;

    public ParkingAgent(String name, ParkingPool pool) {
        this.agentName = name;
        this.pool = pool;
    }

    @Override
    public void run() {

        while (true) {
            RegistrarParking car = pool.getCar();

            System.out.println(agentName +
                    " parked Car " + car.getCarId());

            try {
                Thread.sleep(1500); // simulate parking time
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
