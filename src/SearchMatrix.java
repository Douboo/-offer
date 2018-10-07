public class SearchMatrix {
    /**
     * https://www.lintcode.com/problem/search-a-2d-matrix/description?_from=ladder&&fromId=6
     *
     * 写出一个高效的算法来搜索 m × n矩阵中的值。
     *
     * 这个矩阵具有以下特性：
     *
     * 每行中的整数从左到右是排序的。
     * 每行的第一个数大于上一行的最后一个整数。
     * 样例
     * 考虑下列矩阵：
     *
     * [
     *   [1, 3, 5, 7],
     *   [10, 11, 16, 20],
     *   [23, 30, 34, 50]
     * ]
     * 给出 target = 3，返回 true
     *
     * 挑战
     * O(log(n) + log(m)) 时间复杂度
     * @param matrix: matrix, a list of lists of integers
     * @param target: An integer
     * @return: a boolean, indicate whether matrix contains target
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        // write your code here
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return false;
        }
        int rows = matrix.length;
        int colums = matrix[0].length;
        int low = 0;
        int high = rows - 1;
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(matrix[mid][0] > target){
                high = mid - 1;
            }else if(matrix[mid][0] == target){
                return true;
            }else{
                low = mid + 1;
            }
        }
        if(high == -1){
            return false;
        }
        low = 0;
        int idx = high;
        high = colums - 1;
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(matrix[idx][mid] > target){
                high = mid - 1;
            }else if(matrix[idx][mid] == target){
                return true;
            }else{
                low = mid + 1;
            }
        }
        return false;
    }
}
