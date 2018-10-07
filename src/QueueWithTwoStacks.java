import java.util.Stack;

public class QueueWithTwoStacks {
    Stack<Integer> stack1;
    Stack<Integer> stack2;
    boolean flag; //全局变量，判断出队时两栈是否都空
    public QueueWithTwoStacks() {
        // do intialization if necessary
        stack1 = new Stack<>();
        stack2 = new Stack<>();
        flag = false;
    }

    /**
     * https://www.lintcode.com/problem/implement-queue-by-two-stacks/description?_from=ladder&&fromId=6
     *
     * 使用两个栈来实现队列的一些操作。
     *
     * 队列应支持push(element)，pop() 和 top()，其中pop是弹出队列中的第一个(最前面的)元素。
     *
     * pop和top方法都应该返回第一个元素的值。
     * @param element: An integer
     * @return: nothing
     */
    public void push(int element) {
        // write your code here
        stack1.push(element);
    }

    /*
     * @return: An integer
     */
    public int pop() {
        // write your code here
        if(stack2.isEmpty()){
            if(stack1.isEmpty()){
                flag = true;
                return 0;
            }
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    /*
     * @return: An integer
     */
    public int top() {
        // write your code here
        if(stack2.isEmpty()){
            if(stack1.isEmpty()){
                flag = true;
                return 0;
            }
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.peek();
    }
}
