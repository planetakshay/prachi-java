package practice2023;

public class MaxDistance {

    public static void main(String[] args) {
        int[] seats = new int[]{1,0,0,0,1,0,1};
        System.out.println("Seat: " + maxDistance(seats));
        seats = new int[]{1,0,0,0};
        System.out.println("Seat: " + maxDistance(seats));

    }

    public static int maxDistance(int[] seats) {
        if(seats == null || seats.length == 0) {
            return 0;
        }
        int len = seats.length, l = -1;
        int maxDistance = 0;
        for(int i = 0; i<len;i++) {
            if(seats[i] == 1) {
                maxDistance = l < 0 ? i : Math.max(maxDistance, (i - l) / 2);
                l = i;
            }
        }
        return Math.max(maxDistance, len - 1 - l);
    }
}
