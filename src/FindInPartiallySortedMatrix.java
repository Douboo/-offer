public class FindInPartiallySortedMatrix {
    /**
     * https://www.lintcode.com/problem/search-a-2d-matrix-ii/description?_from=ladder&&fromId=6
     *
     * 写出一个高效的算法来搜索m×n矩阵中的值，返回这个值出现的次数。
     *
     * 这个矩阵具有以下特性：
     *
     * 每行中的整数从左到右是排序的。
     * 每一列的整数从上到下是排序的。
     * 在每一行或每一列中没有重复的整数。
     * @param matrix: A list of lists of integers
     * @param target: An integer you want to search in matrix
     * @return: An integer indicate the total occurrence of target in the given matrix
     */
    public int searchMatrix(int[][] matrix, int target) {
        // write your code here
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return 0;
        }
        int rows = matrix.length;
        int colums = matrix[0].length;
        int colum = colums - 1;
        int row = 0;
        int count = 0;
        while(row < rows && colum >= 0){
            while(colum >= 0 && matrix[row][colum] > target){
                colum--;
            }
            if(colum < 0){
                break;
            }
            if(matrix[row][colum] == target){
                count++;
                colum--;
                if(colum < 0){
                    break;
                }
            }
            while(row < rows && matrix[row][colum] < target){
                row++;
            }
            if(row == rows){
                break;
            }
            if(matrix[row][colum] == target){
                count++;
                row++;
                if(row == rows){
                    break;
                }
            }
        }
        return count;
    }
}
