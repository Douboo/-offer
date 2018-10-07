import java.util.*;
public class MaxSlidingWindow {
    /**
     * https://www.lintcode.com/problem/sliding-window-maximum/description?_from=ladder&&fromId=6
     *
     * 给出一个可能包含重复的整数数组，和一个大小为 k 的滑动窗口, 从左到右在数组中滑动这个窗口，找到数组中每个窗口内的最大值。
     * @param nums: A list of integers.
     * @param k: An integer
     * @return: The maximum number inside the window at each moving.
     */
    public List<Integer> maxSlidingWindow(int[] nums, int k) {
        // write your code here
        List<Integer> result = new ArrayList<>();
        if(nums == null || nums.length == 0 || k <= 0 || k > nums.length){
            return result;
        }
        List<Integer> windows = new ArrayList<>();
        int index = 0;
        windows.add(index);
        index++;
        while(index < k){
            if(index - windows.get(0) >= k){
                windows.remove(0);
            }
            while(windows.size() > 0 && nums[windows.get(windows.size()-1)] <= nums[index]){
                windows.remove(windows.size()-1);
            }
            windows.add(index);
            index++;
        }
        result.add(nums[windows.get(0)]);
        while(index < nums.length){
            if(index - windows.get(0) >= k){
                windows.remove(0);
            }
            while(windows.size() > 0 && nums[windows.get(windows.size()-1)] <= nums[index]){
                windows.remove(windows.size()-1);
            }
            windows.add(index);
            result.add(nums[windows.get(0)]);
            index++;
        }
        return result;
    }
}
