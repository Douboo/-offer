public class Fibonacci {
    /**
     * 查找斐波纳契数列中第 N 个数
     * @param n: an integer
     * @return: an ineger f(n)
     */
    public int fibonacci(int n) {
        // write your code here
        if(n == 1){
            return 0;
        }
        if(n == 2){
            return 1;
        }
        int minOne = 0;
        int minTwo = 1;
        int fibonaN = 0;
        for(int i=2; i<n; i++){
            fibonaN = minOne + minTwo;
            minOne = minTwo;
            minTwo = fibonaN;
        }
        return fibonaN;
    }
}
