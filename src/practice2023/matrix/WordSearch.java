package practice2023.matrix;

public class WordSearch {
    private final int[] rowOffsets = {0, 1, 0, -1};
    private final int[] colOffsets = {1, 0, -1, 0};

    private char[][] matrix;
    private int totalRows;
    private int totalColumns;

    public static void main(String[] args) {
        WordSearch wordSearch = new WordSearch();

        char[][] matrix = new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "ABCCED";
        System.out.println("Can the word be formed: " + wordSearch.exist(matrix, word));

        matrix = new char[][]{{'a','b'}};
        word = "ba";
        System.out.println("Can the word be formed: " + wordSearch.exist(matrix, word));
    }
    public boolean exist(char[][] board, String word) {
        this.matrix = board;
        totalRows = matrix.length;
        totalColumns = matrix[0].length;
        for (int row = 0; row < totalRows; row++) {
            for (int col = 0; col < totalColumns; col++) {
                if (backtrack(row, col, 0, word)) {
                    return true;
                }
            }
        }
        return false;
    }
    private boolean backtrack(int row, int col, int index, String word) {
        if (index >= word.length()) {
            return true;
        }
        if (row < 0 || row == totalRows || col < 0 || col == totalColumns || matrix[row][col] != word.charAt(index)) {
            return false;
        }
        boolean ret = false;
        matrix[row][col] = '#';
        for (int c = 0; c < rowOffsets.length; c++) {
            if (backtrack(row + rowOffsets[c], col + colOffsets[c], index + 1, word)) {
                return true;
            }
        }
        matrix[row][col] = word.charAt(index);
        return ret;
    }
}