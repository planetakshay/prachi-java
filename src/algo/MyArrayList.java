package algo;

import java.util.Arrays;

public class MyArrayList<T> {
    private final T[] array;
    private int size = 0;
    public MyArrayList(int capacity) {
        array = (T[]) new Object[capacity];
    }
    public static void main(String[] args) {
        MyArrayList<Integer> arrayList = new MyArrayList<>(10);

        System.out.println(arrayList.size());
        for (int i = 1; i <= 7; i++) {
            arrayList.add(i);
        }
        System.out.println("Values: " + arrayList);
        System.out.println(arrayList.size());
        System.out.println(arrayList.get(5));
    }
    public void add(T num) {
        int currLen = array.length;
        if (size >= currLen * 0.75) {
            T[] temp = array;
            Arrays.copyOf(array, currLen * 2);
        }
        array[size++] = num;
    }
    public T get(int i) {
        if (i < 0 || i >= array.length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return array[i];
    }
    public void remove(int i) {
        if (i < 0 || i >= array.length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        // array[i] = null;
        for (int j = i; j < array.length - 1; j++) {
            array[j] = array[j + 1];
            size = j;
        }
    }
    public int size() {
        return this.size;
    }
}