package practice2023.design;

import java.util.TreeSet;

/**
 *
 */
public class MKAverage {

    int m;
    int k;
    TreeSet<Integer> stream;
    int sum = 0;

    public MKAverage(int m, int k) {
        this.m = m;
        this.k = k;
        stream = new TreeSet<>();
    }

    public static void main(String[] args) {
        MKAverage mkAverage = new MKAverage(3, 1);
        mkAverage.addElement(3);
        mkAverage.addElement(1);
        int avg = mkAverage.calculateMKAverage();
        mkAverage.addElement(10);
        avg = mkAverage.calculateMKAverage();
        mkAverage.addElement(5);
        mkAverage.addElement(5);
        mkAverage.addElement(5);
        avg = mkAverage.calculateMKAverage();
    }
    public void addElement(int num) {
        if(stream.isEmpty()) {
            sum = num;
        } else {
            sum += num;
        }
        stream.add(num);
    }

    public int calculateMKAverage() {
        if(stream.size() < m) {
            return -1;
        }
        int count = 0;
        while(count < k) {
            sum -= stream.pollFirst();
            count++;
        }
        count = 0;
        while(count < k) {
            sum -= stream.pollLast();
            count++;
        }
        double avg = sum / stream.size();
        return (int) Math.floor(avg);
    }
}