public class NthUglyNumber {
    /**
     * https://www.lintcode.com/problem/ugly-number-ii/description?_from=ladder&&fromId=6
     *
     * 设计一个算法，找出只含素因子2，3，5 的第 n 小的数。
     *
     * 符合条件的数如：1, 2, 3, 4, 5, 6, 8, 9, 10, 12...
     *
     * 样例
     * 如果n = 9， 返回 10
     *
     * 挑战
     * 要求时间复杂度为O(nlogn)或者O(n)
     * @param n: An integer
     * @return: the nth prime number as description.
     */
    public int nthUglyNumber(int n) {
        // write your code here
        if(n <= 0){
            return -1;
        }
        int[] uglyNumber = new int[n];
        uglyNumber[0] = 1;
        int i2 = 0;
        int i3 = 0;
        int i5 = 0;
        for(int i=1; i<n; i++){
            while(i2 < i && uglyNumber[i2]*2 <= uglyNumber[i-1]){
                i2++;
            }
            while(i3 < i && uglyNumber[i3]*3 <= uglyNumber[i-1]){
                i3++;
            }
            while(i5 < i && uglyNumber[i5]*5 <= uglyNumber[i-1]){
                i5++;
            }
            uglyNumber[i] = min(uglyNumber[i2]*2, uglyNumber[i3]*3, uglyNumber[i5]*5);
        }
        return uglyNumber[n-1];
    }
    public int min(int a, int b, int c){
        if(a > b){
            a = b;
        }
        if(a > c){
            a = c;
        }
        return a;
    }
}
