import java.util.*;
public class MedianII {
    /**
     * https://www.lintcode.com/problem/find-median-from-data-stream/description?_from=ladder&&fromId=6
     *
     * 数字是不断进入数组的，在每次添加一个新的数进入数组的同时返回当前新数组的中位数。
     *
     * 样例
     * 持续进入数组的数的列表为：[1, 2, 3, 4, 5]，则返回[1, 1, 2, 2, 3]
     * 持续进入数组的数的列表为：[4, 5, 1, 3, 2, 6, 0]，则返回 [4, 4, 4, 3, 3, 3, 3]
     * 持续进入数组的数的列表为：[2, 20, 100]，则返回[2, 2, 20]
     *
     * 挑战
     * 时间复杂度为O(nlogn)
     * @param nums: A list of integers
     * @return: the median of numbers
     */
    public int[] medianII(int[] nums) {
        // write your code here
        if(nums == null){
            return null;
        }
        int len = nums.length;
        int[] result = new int[len];
        Comparator<Integer> revCom = new Comparator<Integer>(){
            @Override
            public int compare(Integer left, Integer right){
                return right.compareTo(left);
            }
        };
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(len, revCom);
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(len);
        for(int i=0; i<len; i++){
            if(i%2 == 0){
                if(minHeap.size() > 0 && nums[i] > minHeap.peek()){
                    maxHeap.add(minHeap.poll());
                    minHeap.add(nums[i]);
                }else{
                    maxHeap.add(nums[i]);
                }
            }else{
                if(maxHeap.size() > 0 && nums[i] < maxHeap.peek()){
                    minHeap.add(maxHeap.poll());
                    maxHeap.add(nums[i]);
                }else{
                    minHeap.add(nums[i]);
                }
            }
            result[i] = maxHeap.peek();
        }
        return result;
    }
}
