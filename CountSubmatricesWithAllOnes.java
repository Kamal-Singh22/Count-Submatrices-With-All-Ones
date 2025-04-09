public class CountSubmatricesWithAllOnes {

    public static int numSubmat(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;
        int[][] dp = new int[rows][cols];
        int count = 0;

        // Step 1: Fill dp with horizontal counts of consecutive 1s
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (mat[i][j] == 1) {
                    dp[i][j] = (j == 0) ? 1 : dp[i][j - 1] + 1;
                }
            }
        }

        // Step 2: Count submatrices with all 1s
        for (int j = 0; j < cols; j++) {
            for (int i = 0; i < rows; i++) {
                int width = dp[i][j];
                for (int k = i; k >= 0 && width > 0; k--) {
                    width = Math.min(width, dp[k][j]);
                    count += width;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[][] matrix = {
            {1, 0, 1},
            {1, 1, 0},
            {1, 1, 0}
        };
        System.out.println("Total submatrices with all 1s: " + numSubmat(matrix));
    }
}
