public class Singleton {
    /**
     * https://www.lintcode.com/problem/singleton/description?_from=ladder&&fromId=6
     *
     * 单例 是最为最常见的设计模式之一
     * 你的任务是设计一个 getInstance 方法，对于给定的类，每次调用 getInstance 时，都可得到同一个实例。
     * @return: The same instance of this class every time
     */
    private static Singleton instance = new Singleton();
    public static Singleton getInstance() {
        // write your code here
        return instance;

    }
}
