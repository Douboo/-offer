import java.util.*;
public class MaxTwoSubArray {
    /**
     * https://www.lintcode.com/problem/maximum-subarray-ii/description?_from=ladder&&fromId=6
     *
     * 给定一个整数数组，找出两个 不重叠 子数组使得它们的和最大。
     * 每个子数组的数字在数组中的位置应该是连续的。
     * 返回最大的和。
     * @param nums: A list of integers
     * @return: An integer denotes the sum of max two non-overlapping subarrays
     */
    public int maxTwoSubArrays(List<Integer> nums) {
        // write your code here
        int size = nums.size();
        if(nums == null || size == 0){
            return 0;
        }
        int[] preMaxSum = new int[size];
        int[] postMaxSum = new int[size];
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for(int i=0; i<size; i++){
            sum += nums.get(i);
            if(max < sum){
                max = sum;
            }
            preMaxSum[i] = max;
            if(sum < 0){
                sum = 0;
            }
        }
        max = Integer.MIN_VALUE;
        sum = 0;
        for(int i=size-1; i>=0; i--){
            sum += nums.get(i);
            if(max < sum){
                max = sum;
            }
            postMaxSum[i] = max;
            if(sum < 0){
                sum = 0;
            }
        }
        int result = Integer.MIN_VALUE;
        for(int i=0; i<size-1; i++){
            int twoSum = preMaxSum[i] + postMaxSum[i+1];
            if(result < twoSum){
                result = twoSum;
            }

        }
        return result;
    }
}
