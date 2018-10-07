public class MaxSubArray {
    /**
     * https://www.lintcode.com/problem/maximum-subarray/description?_from=ladder&&fromId=6
     *
     * 给定一个整数数组，找到一个具有最大和的子数组，返回其最大和。
     * @param nums: A list of integers
     * @return: A integer indicate the sum of max subarray
     */
    public int maxSubArray(int[] nums) {
        // write your code here
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for(int i=0; i<nums.length; i++){
            sum += nums[i];
            if(max < sum){
                max = sum;
            }
            if(sum < 0){
                sum = 0;
            }
        }
        return max;
    }
}
