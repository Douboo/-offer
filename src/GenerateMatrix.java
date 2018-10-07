public class GenerateMatrix {
    /**
     * https://www.lintcode.com/problem/spiral-matrix-ii/description?_from=ladder&&fromId=6
     *
     * 给你一个数n生成一个包含1-n^2的螺旋形矩阵
     * @param n: An integer
     * @return: a square matrix
     */
    public int[][] generateMatrix(int n) {
        // write your code here
        if(n < 0){
            return null;
        }
        int[][] matrix = new int[n][n];
        if(n > 0){
            int start = 0;
            int[] count = new int[1];
            while(start*2 < n){
                generateCircle(matrix, start, count);
                start++;
            }
        }
        return matrix;
    }
    public void generateCircle(int[][] matrix, int start, int[] count){
        if(matrix == null || start < 0 || matrix.length == 0 || matrix[0].length == 0){
            return;
        }
        int endColumn = matrix[0].length - 1 - start;
        int endRow = matrix.length - 1 - start;
        for(int i=start; i<=endColumn; i++){
            count[0]++;
            matrix[start][i] = count[0];
        }
        for(int i=start+1; i<=endRow; i++){
            count[0]++;
            matrix[i][endColumn] = count[0];
        }
        if(start < endRow){
            for(int i=endColumn-1; i>=start; i--){
                count[0]++;
                matrix[endRow][i] = count[0];
            }
        }
        if(start < endColumn){
            for(int i=endRow-1; i>start; i--){
                count[0]++;
                matrix[i][start] = count[0];
            }
        }

    }
}
