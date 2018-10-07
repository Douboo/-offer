public class TwoSum {
    /**
     * https://www.lintcode.com/problem/two-sum/description?_from=ladder&&fromId=6
     *
     * 给一个整数数组，找到两个数使得他们的和等于一个给定的数 target。
     *
     * 你需要实现的函数twoSum需要返回这两个数的下标, 并且第一个下标小于第二个下标。注意这里下标的范围是 0 到 n-1。
     * @param numbers: An array of Integer
     * @param target: target = numbers[index1] + numbers[index2]
     * @return: [index1, index2] (index1 < index2)
     */
    public int[] twoSum(int[] numbers, int target) {
        // write your code here
        if(numbers == null || numbers.length == 0){
            return null;
        }
        int[] copy = new int[numbers.length];
        for(int i=0; i<numbers.length; i++){
            copy[i] = numbers[i];
        }
        // 先快速排序，再找下标
        qSort(numbers, 0, numbers.length-1);
        int[] result = new int[2];
        int small = 0;
        int big = numbers.length - 1;
        while(small < big){
            int sum = numbers[small] + numbers[big];
            if(target < sum){
                big--;
            }else if(target == sum){
                result[0] = numbers[small];
                result[1] = numbers[big];
                break;
            }else{
                small++;
            }
        }
        for(int i=0; i<copy.length; i++){
            if(copy[i] == result[0]){
                result[0] = i;
                break;
            }
        }
        for(int i=0; i<copy.length; i++){
            if(copy[i] == result[1] && i != result[0]){
                result[1] = i;
                break;
            }
        }
        if(result[0] > result[1]){
            int temp = result[1];
            result[1] = result[0];
            result[0] = temp;
        }
        return result;

    }
    public void qSort(int[] nums, int start, int end){
        if(start < end){
            int idx = sort(nums, start, end);
            qSort(nums, start, idx-1);
            qSort(nums, idx+1, end);
        }
    }
    public int sort(int[] nums, int start, int end){
        int p = nums[start];
        while(start < end){
            while(start < end && p <= nums[end]){
                end--;
            }
            nums[start] = nums[end];
            while(start < end && p >= nums[start]){
                start++;
            }
            nums[end] = nums[start];
        }
        nums[start] = p;
        return start;
    }
}
