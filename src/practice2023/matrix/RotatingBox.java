package practice2023.matrix;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/rotating-the-box/description/
 */
public class RotatingBox {
    public static void main(String[] args) {
        char[][] box = new char[][]{{'#', '.', '#'}};
        System.out.println("rotated matrix: " + Arrays.deepToString(rotateTheBox(box)));

        box = new char[][]{{'#', '.', '*', '.'}, {'#', '#', '*', '.'}};
        System.out.println("rotated matrix: " + Arrays.deepToString(rotateTheBox(box)));

        box = new char[][]{{'#', '#', '*', '.', '*', '.'}, {'#', '#', '#', '*', '.', '.'}, {'#', '#', '#', '.', '#', '.'}};
        System.out.println("rotated matrix: " + Arrays.deepToString(rotateTheBox(box)));
    }

    public static char[][] rotateTheBox(char[][] box) {
        int boxRows = box.length;
        int boxColumns = box[0].length;
        char[][] rotatedBox = new char[boxColumns][boxRows];
        int rotatedRows = rotatedBox.length;
        int rotatedColumns = rotatedBox[0].length;

        for (int i = 0; i < rotatedRows; i++) {
            for (int j = 0; j < rotatedColumns; j++) {
                rotatedBox[i][j] = box[rotatedColumns - 1 - j][i];
            }
        }
        for (int i = 0; i < rotatedColumns; i++) {
            int indI = rotatedRows - 1;
            int indJ = rotatedRows - 1;

            while (indI >= 0 && indJ >= 0) {
                if (rotatedBox[indJ][i] == '#' && rotatedBox[indI][i] == '.') {
                    rotatedBox[indJ][i] = '.';
                    rotatedBox[indI][i] = '#';
                    indI--;
                } else if (rotatedBox[indJ][i] == '*') {
                    indI = indJ - 1;
                } else if (rotatedBox[indJ][i] == '#' && rotatedBox[indI][i] == '#') {
                    indI--;
                }
                indJ--;
            }
        }
        return rotatedBox;
    }
}