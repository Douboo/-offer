import java.util.*;
public class SpiralOrderMatrix {
    /**
     * https://www.lintcode.com/problem/spiral-matrix/description?_from=ladder&&fromId=6
     *
     * 给定一个包含 m x n 个要素的矩阵，（m 行, n 列），按照螺旋顺序，返回该矩阵中的所有要素。
     * @param matrix: a matrix of m x n elements
     * @return: an integer list
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        // write your code here
        List<Integer> list = new ArrayList<>();
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return list;
        }
        int rows = matrix.length;
        int columns = matrix[0].length;
        int i = 0;
        while(2*i < rows && 2*i < columns){
            saveCircle(matrix, i, list);
            i++;
        }
        return list;
    }
    public void saveCircle(int[][] matrix, int start, List<Integer> list){
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return;
        }
        if(start < 0 || start >= Math.min(matrix.length, matrix[0].length)){
            return;
        }
        int endR = matrix.length - start - 1;
        int endC = matrix[0].length - start - 1;
        for(int i=start; i<=endC; i++){
            list.add(matrix[start][i]);
        }
        for(int i=start+1; i<=endR; i++){
            list.add(matrix[i][endC]);
        }
        if(start < endR){
            for(int i=endC-1; i>=start; i--){
                list.add(matrix[endR][i]);
            }
        }
        if(start < endC){
            for(int i=endR-1; i>start; i--){
                list.add(matrix[i][start]);
            }
        }
    }
}
