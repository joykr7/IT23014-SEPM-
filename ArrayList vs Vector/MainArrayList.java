import java.util.ArrayList;
import java.lang.reflect.Field;

public class MainArrayList {

    // Method to get internal capacity of ArrayList
    static int getCapacity(ArrayList<?> list) throws Exception {
        Field field = ArrayList.class.getDeclaredField("elementData");
        field.setAccessible(true);
        Object[] data = (Object[]) field.get(list);
        return data.length;
    }

    public static void main(String[] args) throws Exception {

        // Initial capacity = 10
        ArrayList<String> list = new ArrayList<>(10);

        System.out.println("Initial Capacity: " + getCapacity(list));

        // Add 10 elements
        for(int i = 1; i <= 10; i++) {
            list.add("IT2300" + i);
        }

        System.out.println("Size after adding 10 elements: " + list.size());
        System.out.println("Capacity before exceeding: " + getCapacity(list));

        // Exceed capacity
        list.add("IT23011");

        System.out.println("Size after exceeding: " + list.size());
        System.out.println("New Capacity: " + getCapacity(list));
    }
}
