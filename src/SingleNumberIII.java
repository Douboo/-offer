public class SingleNumberIII {
    /**
     * https://www.lintcode.com/problem/single-number-ii/description?_from=ladder&&fromId=6
     *
     * 给出3*n + 1 个的数字，除其中一个数字之外其他每个数字均出现三次，找到这个数字。
     * @param A: An integer array
     * @return: An integer
     */
    public int singleNumberII(int[] A) {
        // write your code here
        if(A == null || A.length == 0){
            return 0;
        }
        int size = 32;
        int[] bitSum = new int[size];
        for(int i=0; i<A.length; i++){
            int num = 1;
            for(int j=size-1; j>=0; j--){
                if((A[i] & num) != 0){
                    bitSum[j]++;
                }
                num = num << 1;
            }
        }
        int result = 0;
        for(int i=0; i<size; i++){
            result = result << 1;
            result += bitSum[i] % 3;
        }
        return result;
    }
}
