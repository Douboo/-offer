public class SingleNumber {
    /**
     * 给出2*n + 1 个的数字，除其中一个数字之外其他每个数字均出现两次，找到这个数字。
     * @param A: An integer array
     * @return: An integer
     */
    public int singleNumber(int[] A) {
        // write your code here
        int result = 0;
        for(int i=0; i<A.length; i++){
            result ^= A[i];
        }
        return result;
    }
}
