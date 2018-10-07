import java.util.*;
public class SingleNumberTwo {
    /**
     * https://www.lintcode.com/problem/single-number-iii/description?_from=ladder&&fromId=6
     *
     * 给出2*n + 2个的数字，除其中两个数字之外其他每个数字均出现两次，找到这两个数字。
     * @param A: An integer array
     * @return: An integer array
     */
    public List<Integer> singleNumberIII(int[] A) {
        // write your code here
        List<Integer> singleList = new ArrayList<>();
        if(A == null || A.length == 0){
            return singleList;
        }
        int num = 0;
        for(int i=0; i<A.length; i++){
            num ^= A[i];
        }
        int idxOfBit1 = findIdxOfBit1(num);
        int num1 = 0;
        int num2 = 0;
        for(int i=0; i<A.length; i++){
            if((A[i] & idxOfBit1) == idxOfBit1){
                num1 ^= A[i];
            }else{
                num2 ^= A[i];
            }
        }
        singleList.add(num1);
        singleList.add(num2);
        return singleList;
    }
    public int findIdxOfBit1(int num) {
        int idxOfBit1 = 1;
        while ((num & idxOfBit1) == 0) {
            idxOfBit1 = idxOfBit1 << 1;
        }
        return idxOfBit1;
    }
}
