package practice2023.array;

public class FaultySensor {
    public static void main(String[] args) {
        int[] sensor1 = {2, 3, 4, 5};
        int[] sensor2 = {2, 1, 3, 4};
        System.out.println("Faulty sensor: " + badSensor(sensor1, sensor2));

        sensor1 = new int[]{2, 2, 2, 2, 2};
        sensor2 = new int[]{2, 2, 2, 2, 5};
        System.out.println("Faulty sensor: " + badSensor(sensor1, sensor2));

        sensor1 = new int[]{2, 3, 2, 2, 3, 2};
        sensor2 = new int[]{2, 3, 2, 3, 2, 7};
        System.out.println("Faulty sensor: " + badSensor(sensor1, sensor2));

        sensor1 = new int[]{1, 2, 3, 2, 3, 2};
        sensor2 = new int[]{1, 2, 3, 3, 2, 3};
        System.out.println("Faulty sensor: " + badSensor(sensor1, sensor2));
    }

    public static int badSensor(int[] sensor1, int[] sensor2) {
        int len = sensor1.length;
        int s1 = 0, s2 = 0;

        for (int i = 0; i < len - 1; i++) {
            if (sensor1[i] != sensor2[i]) {
                if (sensor1[i] == sensor2[i + 1]) {
                    s1++;
                }
                if (sensor1[i + 1] == sensor2[i]) {
                    s2++;
                }
            }
        }
        int faultySensor = -1;
        if (s1 > s2) {
            faultySensor = 1;
        } else if (s1 < s2) {
            faultySensor = 2;
        }
        return faultySensor;
    }
}