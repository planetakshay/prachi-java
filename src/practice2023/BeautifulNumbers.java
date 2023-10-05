package practice2023;

public class BeautifulNumbers {

    public static void main(String[] args) {
        BeautifulNumbers numbers = new BeautifulNumbers();
        // System.out.println("Beautiful numbers in the range: " + numbers.numberOfBeautifulIntegers(10, 20, 3));
        System.out.println("Beautiful numbers in the range: " + numbers.numberOfBeautifulIntegers(1, 10, 1));
    }

    public int numberOfBeautifulIntegers(int low, int high, int k) {
        int beautifulNums = 0;
        for(int i=low;i<=high;i++) {
            int curr = i;
            if(i % k == 0) {
                int oddDigitCnt = 0;
                int evenDigitCnt = 0;
                int digit = 0;
                while(curr > 0) {
                    digit = curr % 10;
                    if(digit % 2 == 0) {
                        evenDigitCnt++;
                    } else {
                        oddDigitCnt++;
                    }
                    curr = curr / 10;
                }
                if(oddDigitCnt == evenDigitCnt) {
                    beautifulNums++;
                }
            }
        }
        return beautifulNums;
    }
}
