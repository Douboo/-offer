public class SortArrayForMinNumber {
    /**
     * https://www.lintcode.com/problem/reorder-array-to-construct-the-minimum-number/description?_from=ladder&&fromId=6
     *
     * 给定一个整数数组，请将其重新排序，以构造最小值。
     *
     * 样例
     * 给定 [3, 32, 321]，通过将数组重新排序，可构造 6 个可能性数字：
     *
     * 3+32+321=332321
     * 3+321+32=332132
     * 32+3+321=323321
     * 32+321+3=323213
     * 321+3+32=321332
     * 321+32+3=321323
     * @param nums: n non-negative integer array
     * @return: A string
     */
    public String minNumber(int[] nums) {
        // write your code here
        if(nums == null || nums.length == 0){
            return null;
        }
        if(nums.length == 1){
            return new Integer(nums[0]).toString();
        }
        StringBuilder sbd = new StringBuilder();
        qSort(nums, 0, nums.length-1);
        for(int i=0; i<nums.length; i++){
            sbd.append(nums[i]);
        }
        while(sbd.length() > 1 && sbd.charAt(0) == '0'){
            sbd.deleteCharAt(0);
        }
        return sbd.toString();
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
            while(start < end && compareTo(p, nums[end]) <= 0){
                end--;
            }
            nums[start] = nums[end];
            while(start < end && compareTo(p, nums[start]) >= 0){
                start++;
            }
            nums[end] = nums[start];
        }
        nums[start] = p;
        return start;
    }
    public int compareTo(int a, int b){
        String s1 = a + "" + b;
        String s2 = b + "" + a;
        return s1.compareTo(s2);
    }
}
