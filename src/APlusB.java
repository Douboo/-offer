public class APlusB {
    /**
     * https://www.lintcode.com/problem/a-b-problem/description?_from=ladder&&fromId=6
     *
     * 给出两个整数 aa 和 bb , 求他们的和。
     *
     * 样例
     * 如果 a=1 并且 b=2，返回3。
     *
     * 挑战
     * 显然你可以直接 return a + b，但是你是否可以挑战一下不这样做？（不使用++等算数运算符）
     * @param a: An integer
     * @param b: An integer
     * @return: The sum of a and b
     */
    public int aplusb(int a, int b) {
        // write your code here
        int c;
        while(b != 0){
            c = a ^ b;
            b = (a & b) << 1;
            a = c;
        }
        return a;

    }
}
