public class KthLargestElement {
    /**
     * https://www.lintcode.com/problem/kth-largest-element/description?_from=ladder&&fromId=6
     *
     * 在数组中找到第k大的元素
     * @param n: An integer
     * @param nums: An array
     * @return: the Kth largest element
     */
    public int kthLargestElement(int n, int[] nums) {
        // write your code here
        if(nums == null || n <= 0 || n > nums.length){
            return 0;
        }
        int start = 0;
        int end = nums.length - 1;
        int idx = patition(nums, start, end);
        while(n-1 != idx){
            if(n-1 > idx){
                start = idx+1;
                idx = patition(nums, start, end);
            }else{
                end = idx-1;
                idx = patition(nums, start, end);
            }
        }
        return nums[n-1];
    }
    public int patition(int[] nums, int start, int end){
        int p = nums[start];
        while(start < end){
            while(start < end && p >= nums[end]){
                end--;
            }
            nums[start] = nums[end];
            while(start < end && p <= nums[start]){
                start++;
            }
            nums[end] = nums[start];
        }
        nums[start] = p;
        return start;
    }
}
