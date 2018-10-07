public class SearchRange {

    /**
     * https://www.lintcode.com/problem/search-for-a-range/description?_from=ladder&&fromId=6
     *
     * 给定一个包含 n 个整数的排序数组，找出给定目标值 target 的起始和结束位置。
     *
     * 如果目标值不在数组中，则返回[-1, -1]
     * @param A: an integer sorted array
     * @param target: an integer to be inserted
     * @return: a list of length 2, [index1, index2]
     */
    public int[] searchRange(int[] A, int target) {
        // write your code here
        int[] result = new int[2];
        for(int i=0; i<result.length; i++){
            result[i] = -1;
        }
        if(A == null || A.length == 0){
            return result;
        }
        int low = 0;
        int high = A.length - 1;
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(A[mid] < target){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        if(low >= A.length || A[low] != target){
            return result;
        }
        result[0] = low;
        high = A.length - 1;
        while(low <= high){
            int mid = low + (high-low) / 2;
            if(A[mid] <= target){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        result[1] = high;
        return result;
    }
}
