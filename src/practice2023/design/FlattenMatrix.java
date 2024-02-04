package practice2023.design;

import java.util.NoSuchElementException;

/**
 * https://leetcode.com/problems/flatten-2d-vector/
 */
public class FlattenMatrix {
    private final int[][] matrix;
    private int row = 0;
    private int column = 0;

    public FlattenMatrix(int[][] vec) {
        this.matrix = vec;
    }

    public static void main(String[] args) {
        int[][] vector = new int[][]{{1, 2}, {3}, {4}};
        FlattenMatrix flattenMatrix = new FlattenMatrix(vector);
        System.out.println("Next: " + flattenMatrix.next());
        System.out.println("Next: " + flattenMatrix.next());
        System.out.println("Next: " + flattenMatrix.next());
        System.out.println("Has next: " + flattenMatrix.hasNext());
        System.out.println("Has next: " + flattenMatrix.hasNext());
        System.out.println("Next: " + flattenMatrix.next());
        System.out.println("Has next: " + flattenMatrix.hasNext());

        vector = new int[][]{{},{}};
        flattenMatrix = new FlattenMatrix(vector);
        System.out.println("Has next: " + flattenMatrix.hasNext());

        vector = new int[][]{{3},{},{},{}};
        flattenMatrix = new FlattenMatrix(vector);
        System.out.println("Has next: " + flattenMatrix.hasNext());
        System.out.println("Next: " + flattenMatrix.next());
        System.out.println("Has next: " + flattenMatrix.hasNext());
    }

    public int next() {
        if(!hasNext()) {
            throw new NoSuchElementException();
        }
        return matrix[row][column++];
    }

    public boolean hasNext() {
        while(row < matrix.length && column == matrix[row].length) {
            column = 0;
            row++;
        }
        return row < matrix.length;
    }
}