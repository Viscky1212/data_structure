package systemDesign.easy;


import java.util.ArrayList;
import java.util.List;

class TemperatureSensorHelper {

    // Private storage for temperature readings
    private final List<Integer> readings;

    public TemperatureSensorHelper() {
        readings = new ArrayList<>();
    }

    // Add temperature reading
    public boolean addReading(int value) {

        // Validate supported temperature range
        if (value < -50 || value > 150) {
            return false;
        }

        readings.add(value);
        return true;
    }

    // Return total accepted readings
    public int getReadingCount() {
        return readings.size();
    }

    // Calculate average temperature
    public double getAverage() {

        if (readings.isEmpty()) {
            return 0.0;
        }

        long sum = 0;

        for (int reading : readings) {
            sum += reading;
        }

        return (double) sum / readings.size();
    }

    // Return a new array (defensive copy)
    public int[] getReadings() {

        int[] result = new int[readings.size()];

        for (int i = 0; i < readings.size(); i++) {
            result[i] = readings.get(i);
        }

        return result;
    }
}

public class TemperatureSensor {

    public static void main(String[] args) {

        TemperatureSensorHelper sensor = new TemperatureSensorHelper();

        // Add readings
        System.out.println(sensor.addReading(20));   // true
        System.out.println(sensor.addReading(30));   // true
        System.out.println(sensor.addReading(25));   // true

        // Invalid readings
        System.out.println(sensor.addReading(-51));  // false
        System.out.println(sensor.addReading(151));  // false

        // Count
        System.out.println(sensor.getReadingCount());

        // Average
        System.out.println(sensor.getAverage());

        // All readings
        int[] values = sensor.getReadings();

        for (int value : values) {
            System.out.print(value + " ");
        }

        System.out.println();

        // Test defensive copy
        values[0] = 999;

        System.out.println(sensor.getReadings()[0]);
        // Still 20, not 999
    }
}
