package practice2023.strings;

/**
 * https://leetcode.com/problems/remove-colored-pieces-if-both-neighbors-are-the-same-color/description/
 */
public class RemoveColoredPieces {
    public boolean winnerOfGame(String colors) {

        int len = colors.length();
        int player1 = 0;
        int player2 = 0;

        for (int i = 1; i < len - 1; i++) {
            if (colors.charAt(i - 1) == colors.charAt(i) && colors.charAt(i) == colors.charAt(i + 1)) {
                if (colors.charAt(i) == 'A') {
                    player1++;
                } else {
                    player2++;
                }
            }
        }
        return player1 - player2 >= 1;
    }
}