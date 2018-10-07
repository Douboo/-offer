public class ClimbStairs {
    /**
     * https://www.lintcode.com/problem/climbing-stairs/description?_from=ladder&&fromId=6
     *
     * 假设你正在爬楼梯，需要n步你才能到达顶部。但每次你只能爬一步或者两步，你能有多少种不同的方法爬到楼顶部？
     * @param n: An integer
     * @return: An integer
     */
    public int climbStairs(int n) {
        // write your code here
        if(n==0)
            return 0;
        int pre = 1;
        int next = 1;
        for(int i=1; i<n; i++){
            int tmp = next;
            next += pre;
            pre = tmp;
        }
        return next;
    }
}
