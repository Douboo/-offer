public class FastPower {
    /**
     * https://www.lintcode.com/problem/fast-power/description?_from=ladder&&fromId=6
     *
     * 计算a^n % b，其中a，b和n都是32位的非负整数
     * @param a: A 32bit integer
     * @param b: A 32bit integer
     * @param n: A 32bit integer
     * @return: An integer
     */
    public int fastPower(int a, int b, int n) {
        // write your code here
        if(n == 0){
            return 1 % b;
        }
        if(n == 1){
            return a % b;
        }
        long result = fastPower(a, b, n >> 1);
        result *= result;
        result %= b;
        if((n & 1) == 1){
            result = (result * a) % b;
        }
        return (int)result;
    }
}
