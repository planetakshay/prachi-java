package practice2023.array;

public class NumbersWithDuplicateDigits {
    public static void main(String[] args) {
        int n = 20;
        System.out.println("Duplicate digits: " + numDupDigitsAtMostN(n));
        long startTime = System.currentTimeMillis();
        n = 25752598;
        System.out.println("Duplicate digits: " + numDupDigitsAtMostN(n));
        long endTime = System.currentTimeMillis();
        System.out.println("Time taken in ms: " + (endTime - startTime));
    }
    public static int numDupDigitsAtMostN(int n) {
        int eligible = 0;
        for(int i = 1; i <= n; i++) {
            int curr = i;
            int digit = 0;
            int[] digitFreq = new int[11];
            while(curr > 0) {
                digit = curr % 10;
                digitFreq[digit]++;
                curr = curr / 10;
            }
            if(hasDup(digitFreq)) {
                eligible++;
            }
        }
        return eligible;
    }
    private static boolean hasDup(int[] digitFreq) {
        for(int i=0;i<digitFreq.length;i++) {
            if(digitFreq[i] > 1) {
                return true;
            }
        }
        return false;
    }
}