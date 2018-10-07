import java.util.*;
public class MinStack {
    /**
     * https://www.lintcode.com/problem/min-stack/description?_from=ladder&&fromId=6
     *
     * 实现一个带有取最小值min方法的栈，min方法将返回当前栈中的最小值。
     * 你实现的栈将支持push，pop 和 min 操作，所有操作要求都在O(1)时间内完成。
     */
    private Stack<Integer>[] stack = new Stack[2];
    public MinStack() {
        // do intialization if necessary
        stack[0] = new Stack<>();
        stack[1] = new Stack<>();
    }

    /**
     * @param number: An integer
     * @return: nothing
     */
    public void push(int number) {
        // write your code here
        stack[0].push(number);
        if(stack[1].isEmpty() || number < stack[1].peek()){
            stack[1].push(number);
        }else{
            stack[1].push(stack[1].peek());
        }
    }

    /*
     * @return: An integer
     */
    public int pop() {
        // write your code here
        if(stack[0].isEmpty()){
            return -1;
        }
        int result = stack[0].pop();
        stack[1].pop();
        return result;
    }

    /*
     * @return: An integer
     */
    public int min() {
        // write your code here
        if(stack[1].isEmpty()){
            return -1;
        }
        int result = stack[1].peek();
        return result;
    }
}
