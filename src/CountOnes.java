public class CountOnes {
    /**
     * https://www.lintcode.com/problem/count-1-in-binary/description?_from=ladder&&fromId=6
     *
     * 计算在一个 32 位的整数的二进制表示中有多少个 1
     * @param num: An integer
     * @return: An integer
     */
    public int countOnes(int num) {
        // write your code here
        int count  = 0;
        while(num != 0){
            num = num & (num-1);
            count++;
        }
        return count;
    }
}
