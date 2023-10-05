package practice2023.strings;

/**
 * https://leetcode.com/problems/determine-color-of-a-chessboard-square/
 */
public class ColorOfChessBoard {
    public static void main(String[] args) {
        String coordinates = "a1";
        System.out.println("Chessboard Square: " + squareIsWhite(coordinates));
        System.out.println("Chessboard Square: " + isSquareWhiteSmaller(coordinates));
    }
    public static boolean squareIsWhite(String coordinates) {
        if(coordinates == null || coordinates.isBlank() || coordinates.length() < 2) {
            return false;
        }
        char alpha = coordinates.charAt(0);
        int num = Character.getNumericValue(coordinates.charAt(1));

        int col = alpha - 'a';
        if((col % 2 == 0 && num % 2 == 1) || (col % 2 == 1 && num % 2 == 0)) {
            return false;
        }
        return true;
    }

    public static boolean isSquareWhiteSmaller(String coordinates) {
        if ((coordinates.charAt(0) + Character.getNumericValue(coordinates.charAt(1))) % 2  == 0){
            return false;
        }
        return true;
    }
}