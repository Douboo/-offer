import java.util.LinkedList;
import java.util.List;

public class NumberOfRecursion {
    /**
     * https://www.lintcode.com/problem/print-numbers-by-recursion/description?_from=ladder&&fromId=6
     *
     * 用递归的方法找到从1到最大的N位整数。
     * @param n: An integer
     * @return: An array storing 1 to the largest number with n digits.
     */
    public List<Integer> numbersByRecursion(int n) {
        // write your code here
        if(n <= 0){
            return null;
        }
        char[] ch = new char[n];
        List<Integer> list = new LinkedList<>();
        print1ToMaxOfNDigit(list, ch, 0);
        return list;
    }
    public void print1ToMaxOfNDigit(List<Integer> list, char[] ch, int index){
        if(index == ch.length){
            print(list, ch);
            return;
        }
        for(int i=0; i<10; i++){
            ch[index] = (char)('0' + i);
            print1ToMaxOfNDigit(list, ch, index+1);
        }
    }
    public void print(List<Integer> list, char[] ch){
        boolean isBegining0 = true;
        StringBuilder sbd = new StringBuilder();
        for(int i=0; i<ch.length; i++){
            if(isBegining0 && ch[i] != '0'){
                isBegining0 = false;
            }
            if(!isBegining0){
                sbd.append(ch[i]);
            }
        }
        String s = sbd.toString();
        if(s.length() != 0){
            list.add(Integer.parseInt(s));
        }
    }
}
