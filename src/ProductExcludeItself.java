import java.util.*;
public class ProductExcludeItself {
    /**
     * https://www.lintcode.com/problem/product-of-array-exclude-itself/description?_from=ladder&&fromId=6
     *
     * 给定一个整数数组A。
     *
     * 定义B[i] = A[0] * ... * A[i-1] * A[i+1] * ... * A[n-1]， 计算B的时候请不要使用除法。
     *
     * 样例
     * 给出A=[1, 2, 3]，返回 B为[6, 3, 2]
     * @param nums: Given an integers array A
     * @return: A long long array B and B[i]= A[0] * ... * A[i-1] * A[i+1] * ... * A[n-1]
     */
    public List<Long> productExcludeItself(List<Integer> nums) {
        // write your code here
        if(nums == null || nums.size() == 0){
            return null;
        }
        int size = nums.size();
        long[] pre = new long[size];
        long[] post = new long[size];
        pre[0] = 1;
        post[size-1] = 1;
        for(int i=1; i<size; i++){
            pre[i] = pre[i-1] * nums.get(i-1);
        }
        for(int i=size-2; i>=0; i--){
            post[i] = post[i+1] * nums.get(i+1);
        }
        List<Long> result = new ArrayList<>();
        for(int i=0; i<size; i++){
            result.add(pre[i] * post[i]);
        }
        return result;

    }
}
