public class ReversePairs {
    /**
     * https://www.lintcode.com/problem/reverse-pairs/description?_from=ladder&&fromId=6
     *
     * 在数组中的两个数字如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。给你一个数组，求出这个数组中逆序对的总数。
     * 概括：如果a[i] > a[j] 且 i < j， a[i] 和 a[j] 构成一个逆序对。
     * @param A: an array
     * @return: total of reverse pairs
     */
    public long reversePairs(int[] A) {
        // write your code here
        if(A == null || A.length == 0){
            return 0;
        }
        int[] copy = new int[A.length];
        for(int i=0; i<A.length; i++){
            copy[i] = A[i];
        }
        int count = inversePairsCore(A, copy, 0, A.length-1);
        // copy中的数才是排好序
        // System.out.println(Arrays.toString(A));
        // System.out.println(Arrays.toString(copy));
        return count;
    }
    public int inversePairsCore(int[] A, int[] copy, int start, int end){
        if(start == end){
            copy[start] = A[start];
            return 0;
        }
        int mid = start + (end - start) / 2;
        int left = inversePairsCore(copy, A, start, mid);
        int right = inversePairsCore(copy, A, mid+1, end);
        int count = 0;
        int i = mid;
        int j = end;
        int idxCopy = end;
        while(i>=start && j>mid){
            if(A[i] > A[j]){
                count += j - mid;
                copy[idxCopy--] = A[i--];
            }else{
                copy[idxCopy--] = A[j--];
            }
        }
        while(i >= start){
            copy[idxCopy--] = A[i--];
        }
        while(j > mid){
            copy[idxCopy--] = A[j--];
        }
        return left + right + count;

    }
}
