import java.util.*;
public class MajorityNumberII {
    /**
     * https://www.lintcode.com/problem/majority-element-ii/description?_from=ladder&&fromId=6
     *
     * 给定一个整型数组，找到主元素，它在数组中的出现次数严格大于数组元素个数的三分之一。
     * @param nums: a list of integers
     * @return: The majority number that occurs more than 1/3
     */
    public int majorityNumber(List<Integer> nums) {
        // write your code here
        // 空间复杂度O(1)
        Map<Integer, Integer> map = new HashMap<>();
        int k = 3;
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
