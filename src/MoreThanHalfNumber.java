import java.util.*;
public class MoreThanHalfNumber {
    /**
     * https://www.lintcode.com/problem/majority-element/description?_from=ladder&&fromId=6
     *
     * 给定一个整型数组，找出主元素，它在数组中的出现次数严格大于数组元素个数的二分之一。
     * @param nums: a list of integers
     * @return: find a  majority number
     */
    public int majorityNumber(List<Integer> nums) {
        // write your code here
        if(nums == null || nums.size() == 0){
            return 0;
        }
        int max = nums.get(0);
        int count = 1;
        for(int i=1; i<nums.size(); i++){
            if(count == 0){
                max = nums.get(i);
                count = 1;
            }else if(max == nums.get(i)){
                count++;
            }else{
                count--;
            }
        }
        return max;
    }
}
