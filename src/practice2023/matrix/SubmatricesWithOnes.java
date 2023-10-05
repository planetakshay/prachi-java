package practice2023.matrix;

/**
 * https://tutorialcup.com/leetcode-solutions/count-submatrices-with-all-ones-leetcode-solution.htm
 *
 * https://leetcode.com/problems/count-submatrices-with-all-ones/description/
 */
public class SubmatricesWithOnes {
    public static void main(String[] args) {
        int[][] mat = new int[][]{{1,0,1},{1,1,0},{1,1,0}};
        System.out.println("Submatrices with zeros: " + numSubmat(mat));
    }

    public static int countSubMatrices(int[][] mat, int a, int b) {
        int r=mat.length, c=mat[0].length;
        int bound=c, count=0;
        for(int i=a; i<r; i++) {
            for(int j=b; j<bound; j++) {
                if(mat[i][j]==1) {
                    count++;
                } else {
                    bound=j;
                }
            }
        }
        return count;
    }
    public static int numSubmat(int[][] mat) {
        int r=mat.length, c=mat[0].length;
        int res=0;
        for(int i=0; i<r; i++) {
            for(int j=0; j<c; j++) {
                res+=countSubMatrices(mat,i,j);
            }
        }
        return res;
    }
}