import java.util.Vector;

public class MainVector {

    public static void main(String[] args) {

        // Initial capacity = 10
        Vector<String> vector = new Vector<>(10);

        System.out.println("Initial Capacity: " + vector.capacity());

        // Add 10 elements
        for(int i = 1; i <= 10; i++) {
            vector.add("IT2300" + i);
        }

        System.out.println("Size after adding 10 elements: " + vector.size());
        System.out.println("Capacity before exceeding: " + vector.capacity());

        // Exceed capacity
        vector.add("IT23011");

        System.out.println("Size after exceeding: " + vector.size());
        System.out.println("New Capacity: " + vector.capacity());
    }
}
