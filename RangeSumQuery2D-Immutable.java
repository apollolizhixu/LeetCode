public class NumMatrix {
    //Time: Build: O(n^2), getSum: O(1); Space: O(n ^ 2)
    int[][] sum = null;
    public NumMatrix(int[][] matrix) {
        if (matrix != null && matrix.length != 0 && matrix[0].length != 0) {
            int m = matrix.length;
            int n = matrix[0].length;
            sum = new int[m][n];
            sum[0][0] = matrix[0][0];
            for (int i = 1; i < m; i++) {
                sum[i][0] = sum[i - 1][0] + matrix[i][0];
            }
            for (int i = 1; i < n; i++) {
                sum[0][i] = sum[0][i - 1] + matrix[0][i];
            }
            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    sum[i][j] = matrix[i][j] + sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1];
                }
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if (sum == null) {
            return 0;
        }
        int rst = sum[row2][col2];
        if (row1 > 0) {
            rst -= sum[row1 - 1][col2];
        }
        if (col1 > 0) {
            rst -= sum[row2][col1 - 1];
        }
        if (row1 > 0 && col1 > 0) {
            rst += sum[row1 - 1][col1 - 1];
        }
        return rst;
    }
}


// Your NumMatrix object will be instantiated and called as such:
// NumMatrix numMatrix = new NumMatrix(matrix);
// numMatrix.sumRegion(0, 1, 2, 3);
// numMatrix.sumRegion(1, 2, 3, 4);