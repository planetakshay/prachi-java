package practice2023.basics.complexity;

import java.util.Arrays;
import java.util.Random;

public class BigOAnalysis {

    int[] array;

    public static void main(String[] args) {
        BigOAnalysis analysis = new BigOAnalysis();
        analysis.bigOAnalysis();
        analysis.fillArray();
        analysis.cpuBranchPrediction(false, 4000);
        analysis.cpuBranchPrediction(true, 4000);
    }

    public void bigOAnalysis() {
        int ii = 1;
        int N = 1000;
        int countInner = 0;
        int countOuter = 0;
        while (ii < N) {
            for (int jj = 0; jj < ii; ++jj) {
                // System.out.println(ii + jj);
                ++countInner;
            }
            ii *= 2;
            ++countOuter;
        }
        System.out.println("Inner loop iterations: " + countInner);
        System.out.println("Outer loop iterations: " + countOuter);
    }

    /**
     * Following method showcases how cpuBranchPrediction works
     * <p>
     * Modern cpus have a mechanism to predict what instruction will
     * be executed next.
     * CPU makes some predictions and compares it with the actual instruction
     * if prediction and actual instructions match it will continue to make
     * predictions based on last few actual instructions.
     * <p>
     * In following example if we sort the array, we are helping CPU to make
     * correct predictions as the data in array is sorted and hence after reaching
     * a certain pivot in the array CPU will start making accurate predictions.
     * <p>
     * One point to be noted here is that sort operation is an expensive operation.
     * So we can use a pivot value and rearrange the data in array around pivot value.
     * Meaning we can move values lower than the pivot to the left of the pivot index
     * and values higher than the pivot to the right of the pivot index.
     * <p>
     * by rearranging the data around provided pivot.
     *
     * @param doSort
     */
    public void cpuBranchPrediction(boolean doSort, int pivot) {
        //write code with or without sorting
        // and check the time.
        if (doSort) {
            Arrays.sort(array);
        }
        int sum = 0;
        int len = array.length;
        long startTime = System.currentTimeMillis();
        for (int i=0;i<len;i++) {
            if (array[i] >= pivot) {
                sum += array[i];
            }
        }
        long endTime = System.currentTimeMillis();
        String suffix = doSort ? "with" : "without";
        System.out.println("Time taken " + suffix + " sorting : " + (endTime - startTime));
    }

    public void fillArray() {
        int bound = 10000;
        int len = 100000000;
        array = new int[len];
        Random random = new Random();
        for (int i = 0; i < len; i++) {
            array[i] = random.nextInt(bound);
        }
    }
}