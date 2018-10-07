import java.util.*;
public class MajorityNumber {
    /**
     * https://www.lintcode.com/problem/majority-number-iii/description?_from=ladder&&fromId=6
     *
     * 给定一个整型数组，找到主元素，它在数组中的出现次数严格大于数组元素个数的1/k。
     *
     * 样例
     * 给出数组 [3,1,2,3,2,3,3,4,4,4] ，和 k = 3，返回 3
     *
     * 挑战
     * 要求时间复杂度为O(n)，空间复杂度为O(k)
     * @param nums: A list of integers
     * @param k: An integer
     * @return: The majority number
     */
    public int majorityNumber(List<Integer> nums, int k) {
        // write your code here
        // 空间复杂度O(k)
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.size(); i++){
            map.put(nums.get(i), map.getOrDefault(nums.get(i), 0)+1);
            if(map.size() >= k){
                removeKey(map);
            }
        }
        Set<Integer> set = map.keySet();
        for(Integer e: set){
            map.put(e, 0);
        }
        // 对最后的元素重新计数
        for(int i=0; i<nums.size(); i++){
            if(map.containsKey(nums.get(i))){
                map.put(nums.get(i), map.get(nums.get(i))+1);
            }
        }
        int maxCount = 0;
        int majority = 0;
        for(Integer e: set){
            if(map.get(e) > maxCount){
                maxCount = map.get(e);
                majority = e;
            }
        }
        return majority;
    }
    public void removeKey(Map<Integer, Integer> map){
        Set<Integer> set = map.keySet();
        List<Integer> removeList = new ArrayList<>();
        for(Integer k: set){
            map.put(k, map.get(k)-1);
            if(map.get(k) == 0){
                removeList.add(k);
            }
        }
        for(Integer k: removeList){
            map.remove(k);
        }
    }
}
