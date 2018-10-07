import java.util.*;
public class MedianSlidingWindow {
    /**
     * https://www.lintcode.com/problem/sliding-window-median/description?_from=ladder&&fromId=6
     * <p>
     * 给定一个包含 n 个整数的数组，和一个大小为 k 的滑动窗口,从左到右在数组中滑动这个窗口，找到数组中每个窗口内的中位数。(如果数组个数是偶数，则在该窗口排序数字后，返回第 N/2 个数字。)
     * 挑战
     * 时间复杂度为 O(nlog(n))
     *
     * @param nums: A list of integers
     * @param k:    An integer
     * @return: The median of the element inside the window at each moving
     */
    public List<Integer> medianSlidingWindow(int[] nums, int k) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return new ArrayList<Integer>();
        }
        List<Integer> res = new ArrayList<>();
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
            public int compare(Integer x, Integer y) {
                return y - x;
            }
        });

        int curMedian;
        if (k > 1) {
            maxHeap.add(nums[0]);
            for (int i = 1; i < k - 1; i++) {
                int x = maxHeap.peek();
                if (nums[i] <= x) {
                    maxHeap.add(nums[i]);
                } else {
                    minHeap.add(nums[i]);
                }
            }
            curMedian = maxHeap.peek();
        } else {
            curMedian = 0;
        }

        for (int i = k - 1; i < nums.length; i++) {
            if (nums[i] <= curMedian) {
                maxHeap.add(nums[i]);
            } else {
                minHeap.add(nums[i]);
            }
            while (maxHeap.size() > minHeap.size() + 1) {
                minHeap.add(maxHeap.poll());
            }
            while (maxHeap.size() < minHeap.size()) {
                maxHeap.add(minHeap.poll());
            }
            curMedian = maxHeap.peek();
            res.add(curMedian);
            if (nums[i - k + 1] <= curMedian) {
                maxHeap.remove(nums[i - k + 1]);
            } else {
                minHeap.remove(nums[i - k + 1]);
            }
        }

        return res;
    }
}
