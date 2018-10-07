public class PatitionArray {
    /**
     * https://www.lintcode.com/problem/partition-array-by-odd-and-even/description?_from=ladder&&fromId=6
     *
     * 分割一个整数数组，使得奇数在前偶数在后。
     * @param nums: an array of integers
     * @return: nothing
     */
    public void partitionArray(int[] nums) {
        // write your code here
        if(nums == null || nums.length == 0){
            return;
        }
        int low = 0;
        int high = nums.length - 1;
        while(low < high){
            while(low < high && (nums[low] & 1) == 1){
                low++;
            }
            while(low < high && (nums[high] & 1) == 0){
                high--;
            }
            int t = nums[low];
            nums[low] = nums[high];
            nums[high] = t;
        }

    }
}
