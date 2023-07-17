package practice2023;

public class StudentMentorCompatibility {

    public static void main(String[] args) {
        int[][] students = {{1,1,0},{1,0,1},{0,0,1}};
        int[][] mentors = {{1,0,0}, {0,0,1}, {1,1,0}};
        System.out.println("Total compatible: " + maxCompatibilitySum(students, mentors));

        students = new int[][] {{0,1,0,1,1,1},{1,0,0,1,0,1},{1,0,1,1,0,0}};
        mentors = new int[][] {{1,0,0,0,0,1},{0,1,0,0,1,1},{0,1,0,0,1,1}};
        System.out.println("Total compatible: " + maxCompatibilitySum(students, mentors));
    }

    public static int maxCompatibilitySum(int[][] students, int[][] mentors) {
        if(students == null || mentors == null) {
            return 0;
        }
        int total = 0;
        for(int i = 0; i < students.length;i++) {
            int maxCompatibility = 0;
            int[] student = students[i];
            for(int j = 0; j < mentors.length; j++) {
                int currCompatibility = 0;
                for(int k = 0; k< mentors[j].length;k++) {
                    if (student[k] == mentors[j][k]) {
                        currCompatibility++;
                    }
                }
                // System.out.println("Max compatibility for current student " + i + " = " +currCompatibility);
                maxCompatibility = Math.max(maxCompatibility, currCompatibility);
            }
            total += maxCompatibility;
        }
        return total;
    }
}