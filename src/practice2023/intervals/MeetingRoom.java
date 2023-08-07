package practice2023.intervals;

/**
 * https://leetcode.com/problems/meeting-rooms-iii/
 */
public class MeetingRoom {

    public static void main(String[] args) {

    }

    public int allocateRoom(int[][] appointments, int[] rooms) {

        if(rooms == null || rooms.length == 0) {
            return 0;
        }

        int index = 0;
        int[] curr = appointments[0];
        int[] rooms
        for(int i = 1; i < appointments.length; i++) {
            if((curr[0] + curr[1]) <= appointments[i][0]) {

            } else if((c))
        }
    }
}
